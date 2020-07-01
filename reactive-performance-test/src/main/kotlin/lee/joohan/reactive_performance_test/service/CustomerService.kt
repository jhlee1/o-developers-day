package lee.joohan.reactive_performance_test.service

import lee.joohan.reactive_performance_test.dto.request.CreateCustomerRequest
import lee.joohan.reactive_performance_test.exception.NotFoundCustomerException
import lee.joohan.reactive_performance_test.model.Customer
import lee.joohan.reactive_performance_test.repository.CustomerRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */


@Service
class CustomerService(private val customerRepository: CustomerRepository) {
    fun getCustomer(id: String): Mono<Customer> = customerRepository.findById(ObjectId(id))
            .switchIfEmpty(Mono.error(NotFoundCustomerException(id)))

    fun createCustomer(customer: Mono<CreateCustomerRequest>): Mono<Customer> = customer
            .map { Customer(it.name, it.email) }
            .flatMap { customerRepository.save(it) }
    fun deleteCustomer(id: String): Mono<Void> = customerRepository.findById(ObjectId(id))
            .switchIfEmpty(Mono.error(NotFoundCustomerException(id)))
            .flatMap { customerRepository.delete(it) }
    fun searchCustomers(nameFilter: String): Flux<Customer> = customerRepository.findCustomer(nameFilter)
}