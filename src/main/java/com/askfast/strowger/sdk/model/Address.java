package com.askfast.strowger.sdk.model;

public class Address {

    private String address;
    private String tenant;
    private AddressConfig config;
    
    public Address() {}
    
    public Address(String address, String tenant, AddressConfig config) {
        this.address = address;
        this.tenant = tenant;
        this.config = config;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress( String address ) {
        this.address = address;
    }
    
    public String getTenant() {
        return tenant;
    }
    
    public void setTenant( String tenant ) {
        this.tenant = tenant;
    }
    
    public AddressConfig getConfig() {
        return config;
    }
    
    public void setConfig( AddressConfig config ) {
        this.config = config;
    }
}
