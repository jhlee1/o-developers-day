package lee.joohan.restmvcperformacetest.service

import lee.joohan.restmvcperformacetest.dto.request.CreateCustomerRequest
import lee.joohan.restmvcperformacetest.exception.NotFoundCustomerException
import lee.joohan.restmvcperformacetest.model.Customer
import lee.joohan.restmvcperformacetest.repository.CustomerRepository
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