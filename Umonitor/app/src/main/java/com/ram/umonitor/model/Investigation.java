package com.ram.umonitor.model;

/**
 * Created by ASUS on 7/7/2017.
 */

public class Investigation {
    private String InID;
    private String InType;
    private int bedNo;
    private String bedStatus;


    public Investigation() {
    }

    public String getInID() {
        return InID;
    }

    public void setInID(String inID) {
        InID = inID;
    }

    public String getInType() {
        return InType;
    }

    public void setInType(String inType) {
        InType = inType;
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
}
