package lee.joohan.restmvcperformancetest.controller

import lee.joohan.restmvcperformancetest.dto.request.CreateCustomerRequest
import lee.joohan.restmvcperformancetest.dto.response.CustomerResponse
import lee.joohan.restmvcperformancetest.model.Customer
import lee.joohan.restmvcperformancetest.service.CustomerService
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
    fun createCustomer(@RequestBody customerRequest: CreateCustomerRequest) : ResponseEntity<Customer> {
        return ResponseEntity.ok(customerService.createCustomer(customerRequest))
    }

    @DeleteMapping("/customer/{id}")
    fun deleteCustomer(@PathVariable id: String) : ResponseEntity<Boolean> {
        customerService.deleteCustomer(id)
        return ResponseEntity.ok(true)
    }
}