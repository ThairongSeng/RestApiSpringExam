package org.example.restapispringexam.repository;

import org.example.restapispringexam.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
