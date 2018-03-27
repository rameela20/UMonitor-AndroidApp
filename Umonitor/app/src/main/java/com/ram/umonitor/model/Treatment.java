package com.ram.umonitor.model;

/**
 * Created by ASUS on 9/20/2017.
 */

public class Treatment {

    private String TA_ID;
    private String bedNo;
    private String drugName;
    private String dosage;


    public String getTA_ID() {
        return TA_ID;
    }

    public void setTA_ID(String TA_ID) {
        this.TA_ID = TA_ID;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
