package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_details")
public class Customer {
	
	@Id
	@Column(name = "customer_id")
	private int customerId;
    private String firstName;
    private String lastName;
    private String addressLine_1;
    private String addressLine_2;
    private String addressLine_3;
    private String City;
    private String State;
    private String email;
    private int ZIP;

    public Customer(){

    }


    public Customer(String firstName, String lastName, int customerId, String addressLine_1, String addressLine_2,
            String addressLine_3, String city, String state, String email, int zIP) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerId = customerId;
        this.addressLine_1 = addressLine_1;
        this.addressLine_2 = addressLine_2;
        this.addressLine_3 = addressLine_3;
        City = city;
        State = state;
        this.email = email;
        ZIP = zIP;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getAddressLine_1() {
        return addressLine_1;
    }
    public void setAddressLine_1(String addressLine_1) {
        this.addressLine_1 = addressLine_1;
    }
    public String getAddressLine_2() {
        return addressLine_2;
    }
    public void setAddressLine_2(String addressLine_2) {
        this.addressLine_2 = addressLine_2;
    }
    public String getAddressLine_3() {
        return addressLine_3;
    }
    public void setAddressLine_3(String addressLine_3) {
        this.addressLine_3 = addressLine_3;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }
    public String getState() {
        return State;
    }
    public void setState(String state) {
        State = state;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getZIP() {
        return ZIP;
    }
    public void setZIP(int zIP) {
        ZIP = zIP;
    }


    @Override
    public String toString() {
        return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", customerId=" + customerId
                + ", addressLine_1=" + addressLine_1 + ", addressLine_2=" + addressLine_2 + ", addressLine_3="
                + addressLine_3 + ", City=" + City + ", State=" + State + ", email=" + email
                + ", ZIP=" + ZIP + "]";
    }

    
    
    
}