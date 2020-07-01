package lee.joohan.restmvcperformacetest.exception

import org.bson.types.ObjectId

class NotFoundCustomerException : RuntimeException {
    constructor(id: String) : super("The customer with id[${id}] is not found.")
}