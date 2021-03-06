package com.ram.umonitor.model;

/**
 * Created by Ahmed on 5/9/2017.
 */

public class Patient {



    private String PID;
    private String email;
    private String password;
    private String name;
    private String userType;
    private String address;
    private String NIC;
    private String gender;
    private String guardian;

    public Patient() {

    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public String getPID() {
        return PID;
    }

    public void setUserID(String PID) {
        this.PID = PID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
