package com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.projectmanagement.BasicsFunctionality.Task.add_New_Task;
import com.example.android.projectmanagement.R;

public class RetrieveBasicsCommandBoundary extends AppCompatActivity {


    private ListView basicsCommandListView;
    private RetrieveBasicsCommandController retrieveBasicsFunctionalityController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        createViews();
        retrieveBasicsFunctionality();
        attachListViewToListener();
    }

    private void createViews(){

        basicsCommandListView = findViewById(R.id.basics_Command_Lay_activity_main);

    }

    private void retrieveBasicsFunctionality(){


        retrieveBasicsFunctionalityController = new RetrieveBasicsCommandController(getApplicationContext() , basicsCommandListView);

        retrieveBasicsFunctionalityController.retrieveBasicsCommands();



    }

    private void attachListViewToListener(){

        basicsCommandListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent commandIntent;

                //save the selected list view item
                Command command = (Command) parent.getItemAtPosition(position);

                int commandType = command.getCommandType();

                commandIntent = appropriateIntent(commandType);

                if(commandIntent == null){return;}

                startActivity(commandIntent);


            }
        });

    }



    private Intent appropriateIntent(int commandType){



        switch (commandType){


            case 0:
                return new Intent(RetrieveBasicsCommandBoundary.this , add_New_Task.class );


            default: return null;
        }


    }


}
