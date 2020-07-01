package lee.joohan.restmvcperformacetest.repository

import lee.joohan.restmvcperformacetest.model.Customer
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class CustomerRepositoryImpl(private val template: MongoTemplate) : CustomerRepositoryCustom {
    override fun findCustomer(nameFilter: String): List<Customer> =
            template.find(Query(Criteria.where("name").regex(".*$nameFilter.*", "i")) // Putting i in option makes regex case-insensitive
    )
}