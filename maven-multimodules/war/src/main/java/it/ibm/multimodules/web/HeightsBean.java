package it.ibm.multimodules.web;

import static it.ibm.multimodules.Converter.*;

public class HeightsBean implements java.io.Serializable {
    private String heightCm = null;
    private String heightFeet = null;
    private String heightInches = null;
    private final int inches = 0;

    public HeightsBean() {
    }

    public String getHeightCm() {
        return heightCm;
    }

    public String getHeightFeet() {
        return heightFeet;
    }

    public String getHeightInches() {
        return heightInches;
    }

    public void setHeightCm(String heightCm) {
        this.heightCm = heightCm;
    }

    public void setHeightFeet(String heightFeet) {
        int cm = Integer.parseInt(heightCm);
        //tag::getFeet[]
        int feet = getFeet(cm);
        //end::getFeet[]
        this.heightFeet = String.valueOf(feet);
    }

    public void setHeightInches(String heightInches) {
        this.heightInches = heightInches;
    }
}