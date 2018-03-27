package com.ram.umonitor.model;

/**
 * Created by ASUS on 7/7/2017.
 */

public class InitAssessment {
    private String InAsID;
    private double eye;
    private double motor;
    private double verbal;
    private String hydration;
    private String InAsTime;

    public InitAssessment() {
    }


    public String getInAsID() {
        return InAsID;
    }

    public void setInAsID(String inAsID) {
        InAsID = inAsID;
    }



    public double getEye() {
        return eye;
    }

    public void setEye(double eye) {
        this.eye = eye;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public double getVerbal() {
        return verbal;
    }

    public void setVerbal(double verbal) {
        this.verbal = verbal;
    }

    public String getHydration() {
        return hydration;
    }

    public void setHydration(String hydration) {
        this.hydration = hydration;
    }

    public String getInAsTime() {
        return InAsTime;
    }

    public void setInAsTime(String inAsTime) {
        InAsTime = inAsTime;
    }
}
