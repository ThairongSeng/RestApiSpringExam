package org.example.restapispringexam.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.restapispringexam.model.Customer;
import org.example.restapispringexam.repository.CustomerRepository;
import org.example.restapispringexam.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer, Integer id) {
        Optional<Customer> CustomerOptional = customerRepository.findById(id);

        if (CustomerOptional.isPresent()) {
            Customer cus = CustomerOptional.get();
            cus.setFirstName(customer.getFirstName());
            cus.setLastName(customer.getLastName());
            cus.setPhoneNumber(customer.getPhoneNumber());

            return customerRepository.save(cus);
        }else{
            throw new EntityNotFoundException("Customer not found with id " + id);
        }
    }

    @Override
    public Optional<Customer> findCustomerById(Integer id) {
        return customerRepository.findById(id);
    }
}
