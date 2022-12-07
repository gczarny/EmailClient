package com.app.model;

import javax.mail.Store;
import java.util.Properties;

public class EmailAccount {

    private String address;
    private String password;
    private Properties properties;
    private Store store;

    public EmailAccount(String address, String password) {
        this.address = address;
        this.password = password;
        properties = new Properties();
        //sending
        properties.put("incomingHost", "imap.wp.pl");
        properties.put("mail.store.protocol", "imaps");

        //retrieving
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.stmps.host", "smtp.wp.pl");
        properties.put("mail.smpts.auth", "true");
        properties.put("outgoingHost", "smtp.wp.pl");
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}