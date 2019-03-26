package com.example.android.projectmanagement.BasicsFunctionality.Task;

public class Task {

    private long ID;
    private String taskName;
    private long startDate;
    private long endDate;
    private int duration;



    public void setID(long ID) {this.ID = ID;}

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public long getID() {return ID;}

    public String getTaskName() {
        return taskName;
    }

    public long getStartDate() {
        return startDate;
    }

    public long getEndDate() {
        return endDate;
    }


    public int getDuration() {
        return duration;
    }

}
