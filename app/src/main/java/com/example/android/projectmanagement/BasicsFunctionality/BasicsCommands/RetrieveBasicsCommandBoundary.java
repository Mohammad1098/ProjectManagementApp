package com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.android.projectmanagement.BasicsFunctionality.Reports.ProjectOverView;
import com.example.android.projectmanagement.BasicsFunctionality.Resource.AddNewResource;
import com.example.android.projectmanagement.BasicsFunctionality.Resource.RetrieveListOfResourceBoundary;
import com.example.android.projectmanagement.BasicsFunctionality.TASK_RESOURCE.RetrieveTasks_ResourcesBoundary;
import com.example.android.projectmanagement.BasicsFunctionality.Task.RetrieveListOfTaskBoundary;
import com.example.android.projectmanagement.BasicsFunctionality.Task.AddNewTask;
import com.example.android.projectmanagement.R;

public class RetrieveBasicsCommandBoundary extends AppCompatActivity {


    private GridView basicsCommandListView;
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
                return new Intent(RetrieveBasicsCommandBoundary.this , AddNewTask.class );

            case 1:
                return new Intent(RetrieveBasicsCommandBoundary.this , AddNewResource.class );

            case 2:
                return new Intent(RetrieveBasicsCommandBoundary.this , RetrieveListOfTaskBoundary.class );

            case 3:
                return new Intent(RetrieveBasicsCommandBoundary.this , RetrieveListOfResourceBoundary.class );

            case 4:
                return new Intent(RetrieveBasicsCommandBoundary.this , RetrieveTasks_ResourcesBoundary.class );

            case 5 :

                return new Intent(RetrieveBasicsCommandBoundary.this , ProjectOverView.class );

            default: return null;
        }


    }


}
