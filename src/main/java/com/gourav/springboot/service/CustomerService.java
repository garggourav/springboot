package com.gourav.springboot.service;

import com.gourav.springboot.domain.Customer;
import com.gourav.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAll(){
        Iterable<Customer> customerIterable =  customerRepository.findAll();
        List<Customer> customerList =new ArrayList<>();
        customerIterable.iterator().forEachRemaining(customerList::add);
        return customerList;
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public boolean existsById(Long aLong) {
        return customerRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        customerRepository.deleteById(aLong);
    }



}
