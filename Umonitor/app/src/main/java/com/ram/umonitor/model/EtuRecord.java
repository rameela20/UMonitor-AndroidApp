package com.ram.umonitor.model;

/**
 * Created by ASUS on 7/7/2017.
 */

public class EtuRecord {
    private String BHT_No;
    private int bedNo;
    private String bedStatus;
    private String userID;
    private String email;
    private String password;
    private String name;
    private String userType;
    private String address;
    private String NIC;
    private String gender;

    public EtuRecord() {
    }

    public String getBHT_No() {
        return BHT_No;
    }

    public void setBHT_No(String BHT_No) {
        this.BHT_No = BHT_No;
    }

    public int getBedNo() {
        return bedNo;
    }

    public void setBedNo(int bedNo) {
        this.bedNo = bedNo;
    }

    public String getBedStatus() {
        return bedStatus;
    }

    public void setBedStatus(String bedStatus) {
        this.bedStatus = bedStatus;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
