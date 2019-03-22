package com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands;

public class Command {

    private String CommandName;
    private int CommandType;


    public Command(String commandName , int commandType){

        this.CommandName = commandName;
        this.CommandType = commandType;

    }



    public void setCommandName(String commandName) {
        CommandName = commandName;
    }

    public void setCommandType(int commandNumber) {
        CommandType = commandNumber;
    }

    public String getCommandName() {
        return CommandName;
    }

    public int getCommandType() {
        return CommandType;
    }
}
