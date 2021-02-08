package com.gourav.springboot;

import com.gourav.springboot.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * @author gourav
 */
@SpringBootTest
class SpringbootApplicationTests {

	@MockBean
	private CustomerService customerService;

	@Test
	void contextLoads() {
	}

}
