package com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.example.android.projectmanagement.R;

public class RetrieveBasicsCommandBoundary extends AppCompatActivity {


    private ListView basicsCommandListView;
    private RetrieveBasicsCommandController retrieveBasicsFunctionalityController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createViews();
        retrieveBasicsFunctionality();

    }

    private void createViews(){

        basicsCommandListView = findViewById(R.id.basics_Command_Lay_activity_main);

    }

    private void retrieveBasicsFunctionality(){


        retrieveBasicsFunctionalityController = new RetrieveBasicsCommandController(getApplicationContext() , basicsCommandListView);

        retrieveBasicsFunctionalityController.retrieveBasicsCommands();



    }


}
