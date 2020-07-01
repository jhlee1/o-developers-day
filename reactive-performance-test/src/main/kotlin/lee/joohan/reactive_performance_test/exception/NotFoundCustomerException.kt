package lee.joohan.reactive_performance_test.exception

class NotFoundCustomerException : RuntimeException {
    constructor(id: String) : super("The customer with id[${id}] is not found.")
}