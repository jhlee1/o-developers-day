package lee.joohan.restmvcperformacetest.repository

import lee.joohan.restmvcperformacetest.model.Customer

interface CustomerRepositoryCustom {
    fun findCustomer(nameFilter: String): List<Customer>
}