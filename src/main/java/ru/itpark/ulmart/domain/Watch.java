package ru.itpark.ulmart.domain;

public class Watch extends Product {
    private String color;
    private String caseMaterial;
    private int caseSize;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCaseMaterial() {
        return caseMaterial;
    }

    public void setCaseMaterial(String caseMaterial) {
        this.caseMaterial = caseMaterial;
    }

    public int getCaseSize() {
        return caseSize;
    }

    public void setCaseSize(int caseSize) {
        this.caseSize = caseSize;
    }
}
