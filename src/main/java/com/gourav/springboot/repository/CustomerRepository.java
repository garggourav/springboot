package com.gourav.springboot.repository;

import com.gourav.springboot.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author gourav
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

