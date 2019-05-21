package io.fdlessard.codebites.customer.proxy;


import io.fdlessard.codebites.customer.proxy.cfconnector.BasicAuthServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@Slf4j
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private RestTemplate restTemplate;
    private Properties cloudProperties;
    private BasicAuthServiceInfo basicAuthServiceInfo;

    public CustomerController(Properties cloudProperties, BasicAuthServiceInfo basicAuthServiceInfo) {
        this.cloudProperties = cloudProperties;
        this.basicAuthServiceInfo = basicAuthServiceInfo;
        this.restTemplate = new RestTemplate();
    }

    @GetMapping(value = "/isAlive", produces = "application/json")
    public String isAlive() {
        log.info("CustomerController.isAlive()");
        return "Hello World from CustomerController";
    }

    @GetMapping(value = "/properties")
    public String getProperties() {
        log.info("CustomerController.getProperties()");
        return cloudProperties.toString();
    }

    @GetMapping(value = "/services")
    public String getServices() {
        log.info("CustomerController.getServices()");
        return basicAuthServiceInfo.toString();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public Customer get(@PathVariable long id) {

        log.info("CustomerController.get({})", id);
        String url = "https://" + basicAuthServiceInfo.getUrl() + "/customers/" + id;
        log.info("CustomerController.get() - url - {}", url);
        Customer customer = restTemplate.getForObject(url, Customer.class);
        log.info("CustomerController.get() - customer : {}", customer);

        return customer;
    }
}
