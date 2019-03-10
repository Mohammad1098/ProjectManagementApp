package com.example.android.projectmanagement.BasicsFunctionality;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.android.projectmanagement.R;

public class RetrieveBasicsFunctionalityBoundary extends AppCompatActivity {


    private ListView basicsFunctionalityListView;
    private RetrieveBasicsFunctionalityController retrieveBasicsFunctionalityController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    private void createViews(){

        basicsFunctionalityListView = findViewById(R.id.basics_functionality_Lay_activity_main);

    }

    private void retrieveBasicsFunctionality(){


        retrieveBasicsFunctionalityController = new RetrieveBasicsFunctionalityController();


    }


}
