package lee.joohan.restmvcperformancetest.repository

import lee.joohan.restmvcperformancetest.model.Customer
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

@Repository
interface CustomerRepository : MongoRepository<Customer, ObjectId>, CustomerRepositoryCustom
