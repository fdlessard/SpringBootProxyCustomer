package io.fdlessard.codebites.customer.proxy;

import io.fdlessard.codebites.customer.proxy.cfconnector.BasicAuthServiceInfo;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ServiceScan
public class CloudConfiguration extends AbstractCloudConfig {

    @Bean
    public Properties cloudProperties() {
        return properties();
    }

    @Bean
    public BasicAuthServiceInfo myBaseServiceInfo() {
        BasicAuthServiceInfo basicAuthServiceInfo = (BasicAuthServiceInfo) this.cloud().getServiceInfo("customer-service");
        return basicAuthServiceInfo;
    }
}
