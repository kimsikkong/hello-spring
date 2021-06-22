package com.example.hellospring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    @Value("${logging-module.version}")
    private String version;

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public Customer fetchCustomer(@PathVariable long id) {
        return this.customerService.fetch(id);
    }

    @GetMapping("/version")
    public String version() {
        return String.format("Project version : %s", this.version);
    }

    @GetMapping("/health")
    public String health() {
        return "healthy";
    }
}
