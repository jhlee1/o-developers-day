package lee.joohan.reactive_performance_test.repository

import lee.joohan.reactive_performance_test.model.Customer
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class CustomerRepositoryImpl(private val template: ReactiveMongoTemplate) : CustomerRepositoryCustom {
    override fun findCustomer(nameFilter: String) = template.find<Customer>(
            Query(Criteria.where("name").regex(".*$nameFilter.*", "i")) // Putting i in option makes regex case-insensitive
    )
}