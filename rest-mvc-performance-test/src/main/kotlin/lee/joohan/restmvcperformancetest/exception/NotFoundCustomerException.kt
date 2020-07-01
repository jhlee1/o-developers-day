package lee.joohan.restmvcperformancetest.exception

class NotFoundCustomerException : RuntimeException {
    constructor(id: String) : super("The customer with id[${id}] is not found.")
}