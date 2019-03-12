package com.example.android.projectmanagement.BasicsFunctionality.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands.Command;
import com.example.android.projectmanagement.R;

import java.util.ArrayList;

public class RetrieveBasicsCommandAdapter extends ArrayAdapter<Command> {


    public RetrieveBasicsCommandAdapter(Context context  , ArrayList<Command> commandsList){

        super(context , 0 , commandsList);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.command_list_item, parent , false);

        }


        Command command = getItem(position);


        TextView commandName = convertView.findViewById(R.id.command_name_Lay_Command_list_item);

        commandName.setText(command.getCommandName());


        return convertView;


    }
}
