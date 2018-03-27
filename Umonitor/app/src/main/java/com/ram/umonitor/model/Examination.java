package com.ram.umonitor.model;

/**
 * Created by ASUS on 7/7/2017.
 */

public class Examination {
    private String ExID;
    private String exType;
    private String exDesc;
    private int bedNo;
    private String bedStatus;


    public Examination() {
    }

    public String getExID() {
        return ExID;
    }

    public void setExID(String exID) {
        ExID = exID;
    }

    public String getExType() {
        return exType;
    }

    public void setExType(String exType) {
        this.exType = exType;
    }

    public String getExDesc() {
        return exDesc;
    }

    public void setExDesc(String exDesc) {
        this.exDesc = exDesc;
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
