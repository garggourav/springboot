package com.gourav.springboot.repository;

import com.gourav.springboot.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

