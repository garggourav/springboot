package com.gourav.springboot.rest;

import com.gourav.springboot.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * @author gourav
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRestRequest {


    /**
     * Note the use of webEnvironment=RANDOM_PORT to start the server with a random port (useful to avoid conflicts in test environments)
     * and the injection of the port with @LocalServerPort.
     * Also, note that Spring Boot has automatically provided a TestRestTemplate for you.
     * All you have to do is add @Autowired to it.
     */
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

//    @MockBean
//    private CustomerService customerService;

    @Test
    public void testAPI() {
        String response = testRestTemplate.getForObject("http://localhost:" + port + "/", String.class);
        org.junit.jupiter.api.Assertions.assertTrue(response.equals("Welcome to Landing Page!"));
    }

    @Test
    public void testWhoIs() {
        String response = testRestTemplate.getForObject("http://localhost:" + port + "/whois", String.class);
        org.junit.jupiter.api.Assertions.assertTrue(response.equals("Demo project for Spring Boot - Gourav Garg"));
    }

    @Test
    public void testHello() {
        String response = testRestTemplate.getForObject("http://localhost:" + port + "/hello", String.class);
        System.out.println(response);
        org.junit.jupiter.api.Assertions.assertTrue(response.equals("World! Welcome"));
    }


}
