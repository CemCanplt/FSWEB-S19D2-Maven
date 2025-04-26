package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Validated
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    // Bu genelde bir service olur.

    @GetMapping
    public List<Customer> getAll() {
        return customerService.findAll();
    }


    @GetMapping("/{id}")
    public Customer get(@PathVariable long id) {
        return customerService.find(id);
    }

    @PostMapping
    public CustomerResponse save(@RequestBody Customer customer) {
        Customer saved = this.customerService.save(customer);
        return new CustomerResponse(saved.getId(), saved.getEmail(), saved.getSalary());
    }
}
