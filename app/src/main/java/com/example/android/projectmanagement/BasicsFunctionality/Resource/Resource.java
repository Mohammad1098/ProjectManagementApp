package com.example.android.projectmanagement.BasicsFunctionality.Resource;

public class Resource {

    private String resourceName,material ;
    private int resourceType,numberOfResource;
    private double salary,overTime,materialCost;
    private long resourceID;

    public Resource(){
    }

    public Resource(String resourceName , int resourceType){

        this.resourceName = resourceName;
        this.resourceType = resourceType;


    }

    public void setResourceID(long resourceID) {this.resourceID = resourceID;}

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setNumberOfResource(int numberOfResource) {this.numberOfResource = numberOfResource;}

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }


    public long getResourceID() {return resourceID;}

    public String getResourceName() {
        return resourceName;
    }

    public int getResourceType() {
        return resourceType;
    }

    public String getMaterial() {
        return material;
    }

    public int getNumberOfResource() {
        return numberOfResource;
    }

    public double getSalary() {
        return salary;
    }

    public double getOverTime() {
        return overTime;
    }

    public double getMaterialCost() {
        return materialCost;
    }
}
