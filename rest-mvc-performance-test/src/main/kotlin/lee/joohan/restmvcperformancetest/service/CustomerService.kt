package lee.joohan.restmvcperformancetest.service

import lee.joohan.restmvcperformancetest.dto.request.CreateCustomerRequest
import lee.joohan.restmvcperformancetest.exception.NotFoundCustomerException
import lee.joohan.restmvcperformancetest.model.Customer
import lee.joohan.restmvcperformancetest.repository.CustomerRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */


@Service
class CustomerService(private val customerRepository: CustomerRepository) {
    fun getCustomer(id: String): Customer = customerRepository.findById(ObjectId(id))
            .orElseThrow{ NotFoundCustomerException(id) }
    fun createCustomer(customer: CreateCustomerRequest): Customer = customerRepository.save(Customer(customer.name, customer.email))
    fun deleteCustomer(id: String) {
        val customer = customerRepository.findById(ObjectId(id))
                .orElseThrow { NotFoundCustomerException(id) }

        customerRepository.delete(customer)
    }

    fun searchCustomers(name: String): List<Customer> = customerRepository.findCustomer(name)
}