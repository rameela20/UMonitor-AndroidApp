package com.ram.umonitor.model;

/**
 * Created by ASUS on 7/7/2017.
 */

public class Allergy {
    private String AlID;
    private String AlType;
    private String AlName;
    private int bedNo;
    private String bedStatus;

    public Allergy() {
    }

    public void setAlID(String alID) {
        AlID = alID;
    }

    public String getAlType() {
        return AlType;
    }

    public void setAlType(String alType) {
        AlType = alType;
    }

    public String getAlName() {
        return AlName;
    }

    public void setAlName(String alName) {
        AlName = alName;
    }

    public String getAlID() {
        return AlID;
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
