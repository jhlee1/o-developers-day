package lee.joohan.restmvcperformacetest.controller

import lee.joohan.restmvcperformacetest.dto.request.CreateCustomerRequest
import lee.joohan.restmvcperformacetest.dto.response.CustomerResponse
import lee.joohan.restmvcperformacetest.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

@RestController
class CustomerController(val customerService: CustomerService) {
    @GetMapping("/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") name: String) = customerService.searchCustomers(name)

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id : String) : ResponseEntity<CustomerResponse?> {
        val customer = customerService.getCustomer(id)

        return ResponseEntity.ok(CustomerResponse(customer.getId(), customer.getName(), customer.getEmail()))
    }

    @PostMapping("/customer")
    fun createCustomer(@RequestBody customerRequest: CreateCustomerRequest) : ResponseEntity<Boolean> {
        val customer = customerService.createCustomer(customerRequest)

        return ResponseEntity.ok(true)
    }

    @DeleteMapping("/customer/{id}")
    fun deleteCustomer(@PathVariable id: String) : ResponseEntity<Boolean> {
        customerService.deleteCustomer(id)
        return ResponseEntity.ok(true)
    }
}