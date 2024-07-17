package org.example.restapispringexam.controller;


import lombok.RequiredArgsConstructor;
import org.example.restapispringexam.model.Customer;
import org.example.restapispringexam.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerRestController {

    private final CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer student) {
        return customerService.saveCustomer(student);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@RequestBody Customer student, @PathVariable Integer id) {
        return customerService.updateCustomer(student, id);
    }

    @GetMapping
    public List<Customer> findAllCustomer(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Integer id) {
        Optional<Customer> student = customerService.findCustomerById(id);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
