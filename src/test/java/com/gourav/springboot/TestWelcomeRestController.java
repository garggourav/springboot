package com.gourav.springboot;


import com.gourav.springboot.domain.K8SPods;
import com.gourav.springboot.rest.WelcomeRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.InetAddress;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * https://spring.io/guides/gs/testing-web/
 * 3 Ways  ways to test Rest or Controller
 *  1. TestRestRequest
 *
 *  2. TestWelcomeRestController
 *      //@SpringBootTest
 *      //@AutoConfigureMockMvc
 *
 *  3. TestWelcomeRestController
 *      @WebMvcTest( WelcomeRestController.class) - light weight
 *
 *  If we want to use Junit5 features add ->  @ExtendWith(SpringExtension.class)
 */

//@SpringBootTest
//@AutoConfigureMockMvc
/**
 * Another useful approach is to not start the server at all but to test only the layer below that,
 * where Spring handles the incoming HTTP request and hands it off to your controller.
 * That way, almost of the full stack is used, and your code will be called in exactly the same way as
 * if it were processing a real HTTP request but without the cost of starting the server.
 * To do that, use Spring’s MockMvc and ask for that to be injected for you by using the @AutoConfigureMockMvc annotation on the test case.
 *
 */

/**
 * In @AutoConfigureMockMvc test, the full Spring application context is started but without the server.
 * We can narrow the tests to only the web layer by using @WebMvcTest
 *
 */
@WebMvcTest( WelcomeRestController.class)
public class TestWelcomeRestController {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetServerInfo() throws Exception {

        K8SPods response =new K8SPods(InetAddress.getLocalHost().getHostName().toString(),InetAddress.getLocalHost().getHostAddress().toString());

        mvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/server")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
            ;
    }
}
