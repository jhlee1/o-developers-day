package lee.joohan.reactive_performance_test.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("customers")
class Customer {
    @Id
    private lateinit var id : ObjectId

    private var name : String
    private var email : String

    constructor(name: String, email: String) {
        this.name = name;
        this.email = email
    }


    fun getId() :String {
        return id.toHexString()
    }

    fun getName() :String {
        return name
    }

    fun getEmail() :String {
        return email
    }
}
