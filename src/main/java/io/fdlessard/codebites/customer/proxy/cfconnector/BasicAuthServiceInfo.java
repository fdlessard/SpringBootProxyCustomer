package io.fdlessard.codebites.customer.proxy.cfconnector;

import org.springframework.cloud.service.BaseServiceInfo;

public class BasicAuthServiceInfo extends BaseServiceInfo {

    private String url;
    private String username;
    private String password;

    public BasicAuthServiceInfo(String id) {
        super(id);
    }

    public BasicAuthServiceInfo(String id, String url, String username, String password) {
        super(id);
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @ServiceProperty
    public String getUrl() {
        return url;
    }

    @ServiceProperty
    public String getUsername() {
        return username;
    }

    @ServiceProperty
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "BasicAuthServiceInfo [url=" + url + ", username=" + username + ", password=" + password + "]";
    }

}
