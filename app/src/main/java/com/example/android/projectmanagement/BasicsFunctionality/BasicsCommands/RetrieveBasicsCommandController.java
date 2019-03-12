package com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands;

import android.content.Context;
import android.widget.ListView;
import com.example.android.projectmanagement.BasicsFunctionality.Adapter.RetrieveBasicsCommandAdapter;
import java.util.ArrayList;



public class RetrieveBasicsCommandController {


    private ListView listView;
    private RetrieveBasicsCommandAdapter retrieveBasicsCommandAdapter;
    private Context context;

    public RetrieveBasicsCommandController(Context context ,ListView listView ){

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


        commandsList.add(new Command("Adding New Task " , 0 ));
        commandsList.add(new Command("Adding New Resource " , 1 ));
        commandsList.add(new Command("Allocate Resources to the Task " , 2 ));
        commandsList.add(new Command("Display Tasks " , 3 ));
        commandsList.add(new Command("Display Resources " , 4 ));
        commandsList.add(new Command("Display Tasks with Resources " , 5 ));
        commandsList.add(new Command("Total Cost for each Task" , 6 ));
        commandsList.add(new Command("Total Cost " , 7 ));


        return commandsList;
    }

}
