package com.ram.umonitor.model;

/**
 * Created by ASUS on 7/7/2017.
 */

public class History {
    private String HisID;
    private String hisType;
    private String hisDesc;
    private int bedNo;
    private String bedStatus;


    public History() {
    }

    public String getHisID() {
        return HisID;
    }

    public void setHisID(String hisID) {
        HisID = hisID;
    }

    public String getHisType() {
        return hisType;
    }

    public void setHisType(String hisType) {
        this.hisType = hisType;
    }

    public String getHisDesc() {
        return hisDesc;
    }

    public void setHisDesc(String hisDesc) {
        this.hisDesc = hisDesc;
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
