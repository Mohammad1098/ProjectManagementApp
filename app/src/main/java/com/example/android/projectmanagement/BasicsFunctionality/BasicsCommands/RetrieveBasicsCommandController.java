package com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands;

import android.content.Context;
import android.widget.GridView;
import android.widget.ListView;
import com.example.android.projectmanagement.BasicsFunctionality.Adapter.RetrieveBasicsCommandAdapter;
import java.util.ArrayList;



public class RetrieveBasicsCommandController {


    private GridView listView;
    private RetrieveBasicsCommandAdapter retrieveBasicsCommandAdapter;
    private Context context;

    public RetrieveBasicsCommandController(Context context ,GridView listView ){

        this.context= context;
        this.listView = listView;

    }



    public boolean retrieveBasicsCommands(){

        retrieveBasicsCommandAdapter = new RetrieveBasicsCommandAdapter(context , createCommand());

        listView.setAdapter(retrieveBasicsCommandAdapter);

        return true;
    }

    private ArrayList<Command> createCommand(){

        ArrayList<Command> commandsList = new ArrayList<>();


        commandsList.add(new Command("New Task " , 0 ));
        commandsList.add(new Command("New Resource " , 1 ));
        commandsList.add(new Command("Tasks " , 2 ));
        commandsList.add(new Command("Resources " , 3 ));
        commandsList.add(new Command("Tasks with Resources " , 4 ));
        commandsList.add(new Command("Project Total Cost " , 5 ));


        return commandsList;
    }

}
