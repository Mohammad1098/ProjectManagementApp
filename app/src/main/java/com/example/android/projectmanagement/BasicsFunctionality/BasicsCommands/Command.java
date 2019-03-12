package com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands;

public class Command {

    private String CommandName;
    private int CommandNumber;


    public Command(String commandName , int commandNumber){

        this.CommandName = commandName;
        this.CommandNumber = commandNumber;

    }



    public void setCommandName(String commandName) {
        CommandName = commandName;
    }

    public void setCommandNumber(int commandNumber) {
        CommandNumber = commandNumber;
    }

    public String getCommandName() {
        return CommandName;
    }

    public int getCommandNumber() {
        return CommandNumber;
    }
}
