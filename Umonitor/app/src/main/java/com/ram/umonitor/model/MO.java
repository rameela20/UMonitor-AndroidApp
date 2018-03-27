package com.ram.umonitor.model;

/**
 * Created by ASUS on 7/7/2017.
 */

public class MO {
    private String MO_ID;
    private String specialty;
    private String LicenseNo;
    private String email;
    private String password;
    private String name;
    private String userType;
    private String address;
    private String NIC;
    private String gender;

    public MO() {
    }

    public String getMO_ID() {
        return MO_ID;
    }

    public void setMO_ID(String MO_ID) {
        this.MO_ID = MO_ID;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getLicenseNo() {
        return LicenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        LicenseNo = licenseNo;
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
