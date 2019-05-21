package io.fdlessard.codebites.customer.proxy.cfconnector;


import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;

import java.util.Map;

public class BasicAuthServiceInfoCreator extends CloudFoundryServiceInfoCreator<BasicAuthServiceInfo> {

    public BasicAuthServiceInfoCreator() {
        super(new Tags(""), "customer-service");
    }

    @Override
    public BasicAuthServiceInfo createServiceInfo(Map<String, Object> serviceData) {

        @SuppressWarnings("unchecked")
        Map<String, Object> credentials = (Map<String, Object>) serviceData.get("credentials");

        String id = (String) serviceData.get("name");
        String url = (String) credentials.get("url");
        String username = (String) credentials.get("username");
        String password = (String) credentials.get("password");

        return new BasicAuthServiceInfo(id, url, username, password);
    }

    @Override
    public boolean accept(Map<String, Object> serviceData) {
        String name = (String) serviceData.get("name");
        return name.startsWith("customer-service"); // Kicks in only if the service name starts with kafka
    }

}
