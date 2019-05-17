package io.fdlessard.codebites.customer.proxy;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerGatewayImpl implements CustomerGateway {

    private RestTemplate restTemplate;

    public CustomerGatewayImpl() {
        this.restTemplate = new RestTemplate();
    }

    public Customer getCustomerById(long id){
        return restTemplate.getForObject("https://customer.cfapps.us10.hana.ondemand.com/customers/" + id, Customer.class);
    }
}
