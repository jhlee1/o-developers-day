package lee.joohan.restmvcperformancetest.repository

import lee.joohan.restmvcperformancetest.model.Customer

interface CustomerRepositoryCustom {
    fun findCustomer(nameFilter: String): List<Customer>
}