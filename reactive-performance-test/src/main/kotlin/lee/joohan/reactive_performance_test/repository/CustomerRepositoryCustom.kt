package lee.joohan.reactive_performance_test.repository

import lee.joohan.reactive_performance_test.model.Customer
import reactor.core.publisher.Flux

interface CustomerRepositoryCustom {
    fun findCustomer(nameFilter: String): Flux<Customer>
}