package lee.joohan.restmvcperformacetest.controller

import lee.joohan.restmvcperformacetest.dto.response.ErrorResponse
import lee.joohan.restmvcperformacetest.exception.NotFoundCustomerException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(NotFoundCustomerException::class)
    fun NotFoundCustomerExceptionHandler(servletRequest: HttpServletRequest, exception: Exception) : ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(404001, exception.message!!), HttpStatus.NOT_FOUND)
    }
}