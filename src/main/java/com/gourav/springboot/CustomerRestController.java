package com.gourav.springboot;

import com.gourav.springboot.domain.Customer;
import com.gourav.springboot.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author gourav
 */

@RestController
@RequestMapping("/customer")
public class CustomerRestController {


    Logger logger = LoggerFactory.getLogger(Customer.class);

    @Autowired
    CustomerService customerService;

    @GetMapping("/get")
    public List<Customer> getAll() {
        logger.info("Incoming request to getAll");
        return customerService.getAll();
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        logger.info("Incoming request to save");
        return customerService.save(customer);
    }

    @PutMapping("/update/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable long id) {
        logger.info("Incoming request to update");
        Customer old = customerService.findById(id);
        return customerService.save(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        logger.info("Incoming request to delete");
        customerService.deleteById(id);
    }

    @PostConstruct
    public void addData() {
        customerService.save(new Customer(1L, "Jack", "Bauer"));
        customerService.save(new Customer(2L, "Chloe", "O'Brian"));
        customerService.save(new Customer(3L, "Kim", "Bauer"));
        customerService.save(new Customer(4L, "David", "Palmer"));
        customerService.save(new Customer(5L, "Michelle", "Dessler"));
    }
}
