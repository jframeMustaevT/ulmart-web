package ru.itpark.ulmart.domain;

public class Desktop extends  Product {
    private String color;
    private String memorySpeed;
    public String hardDrive;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMemorySpeed() {
        return memorySpeed;
    }

    public void setMemorySpeed(String memorySpeed) {
        this.memorySpeed = memorySpeed;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }
}
