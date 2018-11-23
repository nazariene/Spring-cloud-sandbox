package ru.nazariene.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class DemoApplication {

    @Value("${test.name}")
    private String name;

    @Value("${test.number}")
    private String number;

    @RequestMapping(path = "/name", method = RequestMethod.GET)
    public String getName() {
        return name;
    }

    @RequestMapping(path = "/number", method = RequestMethod.GET)
    public String getNumber() {
        return number;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
