package com.gourav.springboot.rest;

import com.gourav.springboot.domain.K8SPods;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

/**
 * @author gourav
 */
@RestController
public class WelcomeRestController {

    private static final Logger logger = Logger.getLogger(WelcomeRestController.class.getName());

    @GetMapping("/")
    public String api(){
        String message =  "Welcome to Landing Page!";
        logger.info(() -> message);
        return message;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name" ,defaultValue = "World!") String name ){
        String message = name + " Welcome";
        logger.info(() -> message);
        return message;
    }

    @GetMapping("/whois")
    public String whois(){
        String message = "Demo project for Spring Boot - Gourav Garg";
        logger.info(() -> message);
        return message;
    }

    @GetMapping("/server")
    public K8SPods getServerInfo() throws UnknownHostException {
        K8SPods response =new K8SPods(InetAddress.getLocalHost().getHostName().toString(),InetAddress.getLocalHost().getHostAddress().toString());
        logger.info(() -> response.toString());
        return response;
    }
}
