package io.fdlessard.codebites.customer.proxy;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {


    private CustomerGateway customerGateway;

    public CustomerController(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @GetMapping(value = "/isAlive", produces = "application/json")
    public String isAlive() {
        log.info("CustomerController.isAlive()");
        return "Hello World from CustomerController";
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    public Customer get(@PathVariable long id) throws Exception {
        log.info("CustomerController.get({})", id);
        if (id % 20 == 0) {
            throw new Exception();
        }
        return customerGateway.getCustomerById(id);
    }
}
