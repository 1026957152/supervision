package org.ylgjj.loan.config;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "mail")
public class ConfigProperties {
     
    private String hostName;
    private int port;
    private String from;
 
    // standard getters and setters

    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;


    private Credentials credentials;
    private Icbc icbc;

    public Icbc getIcbc() {
        return icbc;
    }

    public void setIcbc(Icbc icbc) {
        this.icbc = icbc;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getDefaultRecipients() {
        return defaultRecipients;
    }

    public void setDefaultRecipients(List<String> defaultRecipients) {
        this.defaultRecipients = defaultRecipients;
    }

    public Map<String, String> getAdditionalHeaders() {
        return additionalHeaders;
    }

    public void setAdditionalHeaders(Map<String, String> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }



}