package lee.joohan.reactive_performance_test.handler

import lee.joohan.reactive_performance_test.dto.response.CustomerResponse
import lee.joohan.reactive_performance_test.dto.response.ErrorResponse
import lee.joohan.reactive_performance_test.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.bodyToMono

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

@Component
class CustomerRequestHandler(val customerService: CustomerService) {
    fun get(serverRequest: ServerRequest) = customerService.getCustomer(serverRequest.pathVariable("id"))
            .flatMap { ok().body(fromValue(it)) }
            .onErrorResume { status(HttpStatus.NOT_FOUND).body(fromValue(ErrorResponse(404001, it.message.toString()))) }

    fun create(serverRequest: ServerRequest) = customerService.createCustomer(serverRequest.bodyToMono())
            .flatMap { ok().bodyValue(true) }

    fun delete(serverRequest: ServerRequest) = customerService.deleteCustomer(serverRequest.pathVariable("id"))
            .flatMap { ok().bodyValue(true) }
            .onErrorResume { status(HttpStatus.NOT_FOUND).body(fromValue(ErrorResponse(404001, it.message.toString()))) }

    fun search(serverRequest: ServerRequest) = ok().body(customerService.searchCustomers(serverRequest.queryParam("name").orElse(""))
            .map { CustomerResponse(it.getId(), it.getName(), it.getEmail()) }, CustomerResponse::class.java)
}