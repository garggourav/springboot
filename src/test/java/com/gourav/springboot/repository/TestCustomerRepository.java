package com.gourav.springboot.repository;

import com.gourav.springboot.domain.Customer;
import com.gourav.springboot.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;


/**
 * Junit 4 - @RunWith(SpringRunner.class)
 * Junit 5 - @ExtendWith(SpringExtension.class)
 * <p>
 * DirtiesContext - Will reset TestEntityManager after each repository
 * A nice feature of the Spring Test support is that the application context is cached between tests.
 * That way, if you have multiple methods in a test case or multiple test cases with the same configuration,
 * they incur the cost of starting the application only once.
 * You can control the cache by using the @DirtiesContext annotation.
 *
 * @author gourav
 */

//@ExtendWith(SpringExtension.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TestCustomerRepository {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSave() {
        Customer customer = new Customer(  "Jack", "Bauer");
        entityManager.persist(customer);
        entityManager.flush();
        Customer response = customerRepository.findById(1L).orElseThrow();
        System.out.println(response.toString());
        org.junit.jupiter.api.Assertions.assertTrue(response.equals(customer));
        org.junit.jupiter.api.Assertions.assertEquals(customer, response);

    }

    @Test
    public void testExist() {
        Customer customer = new Customer( "Jack", "Bauer");
        entityManager.persist(customer);
        entityManager.flush();
        boolean response = customerRepository.existsById(1L);
        org.junit.jupiter.api.Assertions.assertEquals(true, response);
    }

    @Test
    public void testCount() {
        Customer customer = new Customer( "Jack", "Bauer");
        entityManager.persist(customer);
        entityManager.flush();
        long response = customerRepository.count();
        org.junit.jupiter.api.Assertions.assertEquals(1, response);
    }

    @Test
    void testFindAll() {
        entityManager.persist(new Customer(  "Jack", "Bauer"));
        entityManager.persist(new Customer( "Chloe", "O'Brian"));
        entityManager.persist(new Customer( "Kim", "Bauer"));
        entityManager.persist(new Customer( "David", "Palmer"));
        entityManager.persist(new Customer(  "Michelle", "Dessler"));
        entityManager.flush();
        Iterable<Customer> customerIterable = customerRepository.findAll();
        List<Customer> customerList = new ArrayList<>();
        customerIterable.iterator().forEachRemaining(customerList::add);
        org.junit.jupiter.api.Assertions.assertEquals(5, customerList.size());
    }
}
