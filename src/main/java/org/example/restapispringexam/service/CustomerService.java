package org.example.restapispringexam.service;

import org.example.restapispringexam.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Customer customer, Integer id);

    Optional<Customer> findCustomerById(Integer id);

}
