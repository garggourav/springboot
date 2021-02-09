package com.gourav.springboot.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.gourav.springboot.CustomerRestController;
import com.gourav.springboot.domain.Customer;
import com.gourav.springboot.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author gourav
 */

@WebMvcTest(CustomerRestController.class)
public class TestCustomerRestController {

    @MockBean
    private CustomerService customerService;

    @Autowired
    private MockMvc mvc;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetAll() throws Exception {
        Customer customer = new Customer(1l,"Jack", "Bauer");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        org.mockito.Mockito.when(customerService.save(customer)).thenReturn(customer);
        org.mockito.Mockito.when(customerService.findById(1L)).thenReturn(customer);
        org.mockito.Mockito.when(customerService.getAll()).thenReturn(customerList);

        mvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/customer/get")
                        .contentType(MediaType.APPLICATION_JSON))

                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));

    }

    @Test
    public void testSave() throws Exception {
        Customer customer = new Customer(1L,"Jack", "Bauer");
        org.mockito.Mockito.when(customerService.save(customer)).thenReturn(customer);
        org.mockito.Mockito.when(customerService.findById(1L)).thenReturn(customer);
        System.out.println(asJsonString(customer));
        mvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post("/customer/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customer)))
                //.andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Jack"))
                .andExpect(jsonPath("$.lastName").value("Bauer"));

    }

    @Test
    public void testSave200() throws Exception {
        Customer customer = new Customer(1L,"Jack", "Bauer");
        org.mockito.Mockito.when(customerService.save(customer)).thenReturn(customer);
        org.mockito.Mockito.when(customerService.findById(1L)).thenReturn(customer);
        System.out.println(asJsonString(customer));
        mvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post("/customer/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customer)))
                .andExpect(status().is(200));

    }

    @Test
    public void testUpdate() throws Exception {
        Customer customer = new Customer(1L,"Jack", "Bauer");
        org.mockito.Mockito.when(customerService.findById(1L)).thenReturn(customer);
        org.mockito.Mockito.when(customerService.save(customer)).thenReturn(customer);
        System.out.println(asJsonString(customer));
        mvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put("/customer/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customer)))
                .andExpect(status().is(200));

    }

    @Test
    public void testDelete() throws Exception {
        org.mockito.Mockito.doNothing().when(customerService).deleteById(1L);
        mvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete("/customer/delete/1")
        ).andExpect(status().is(200));

    }

}
