package com.example.miniapp.services;

import com.example.miniapp.models.Customer;
import com.example.miniapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    public Customer getCustomerById(Long id) {
        return null;
    }

    public Customer updateCustomer(Long id, Customer customer) {
        return null;
    }

    public void deleteCustomer(Long id) {
    }

    public List<Customer> findCustomersByEmailDomain(String domain) {
        return null;
    }

    public List<Customer> findCustomersByPhonePrefix(String prefix) {
        return null;
    }

}
