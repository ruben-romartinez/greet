package com.ruben.spring.docker.kubernetes.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetController {

    private static Logger logger = LoggerFactory.getLogger(GreetController.class);

    private static String url = "http://localhost:9090";

    private String getRequest(String url) {
        logger.info("Url to access {}", url);
        RestTemplate request = new RestTemplate();
        String result = request.getForObject(url, String.class);
        logger.info("Result: {}", result);
        return result;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        String response = getRequest(url + "/message");
        return name + response;
    }
}