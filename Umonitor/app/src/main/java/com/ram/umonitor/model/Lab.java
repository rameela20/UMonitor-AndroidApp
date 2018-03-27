package com.ram.umonitor.model;

/**
 * Created by ASUS on 7/7/2017.
 */

public class Lab {
    private String LabID;
    private String labRoomNo;

    public Lab() {
    }

    public String getLabID() {
        return LabID;
    }

    public void setLabID(String labID) {
        LabID = labID;
    }

    public String getLabRoomNo() {
        return labRoomNo;
    }

    public void setLabRoomNo(String labRoomNo) {
        this.labRoomNo = labRoomNo;
    }
}
