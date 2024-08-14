package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	@Id
    private int customerId;
    private String userPassword;
    private int tries = 0;
    private int isLocked = 1;
    private String status = "inactive";


    public Login(){

    }
    public Login(int customerId , String userPass){
        this.customerId = customerId;
        this.userPassword = userPass;
    }
    public Login(int customerId , String userPass , int tries , int locked , String status){
        this.customerId = customerId;
        this.userPassword = userPass;
        this.tries = tries;
        this.isLocked = locked;
        this.status = status;
    }
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getTries() {
		return tries;
	}
	public void setTries(int tries) {
		this.tries = tries;
	}
	public int getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(int isLocked) {
		this.isLocked = isLocked;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Login [customerId=" + customerId + ", userPassword=" + userPassword + ", tries=" + tries + ", isLocked="
				+ isLocked + ", status=" + status + "]";
	}
    

}
