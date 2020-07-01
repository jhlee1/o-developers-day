package lee.joohan.reactive_performance_test.repository

import lee.joohan.reactive_performance_test.model.Customer
import org.bson.types.ObjectId
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

@Repository
interface CustomerRepository : ReactiveCrudRepository<Customer, ObjectId>, CustomerRepositoryCustom {

}