package com.example.android.projectmanagement.BasicsFunctionality.Resource;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands.RetrieveBasicsCommandBoundary;
import com.example.android.projectmanagement.BasicsFunctionality.Task.RetrieveListOfTaskBoundary;
import com.example.android.projectmanagement.R;

public class RetrieveListOfResourceBoundary extends AppCompatActivity {


    private ListView resourceList;
    private RetrieveListOfResourceController retrieveListOfResourceController;



    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve_list_of_resource);
        retrieveSpecificDevices();

    }

    private void retrieveSpecificDevices(){


        resourceList = findViewById(R.id.resource_list_view_Lay_retrieve_list_of_resource);

        retrieveListOfResourceController  = new RetrieveListOfResourceController(RetrieveListOfResourceBoundary.this ,resourceList );

        boolean isListEmpty = retrieveListOfResourceController.retrieveListOfResources();

        if (isListEmpty == false) {
            Toast.makeText(this, "No Resource Available !", Toast.LENGTH_LONG).show();
        }

    }


    private void returnToPreviousLayout(){

        Intent openHomeScreenLayoutIntent = new Intent(RetrieveListOfResourceBoundary.this, RetrieveBasicsCommandBoundary.class);

        startActivity(openHomeScreenLayoutIntent);


    }

    @Override
    public void onBackPressed() {



        returnToPreviousLayout();



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        returnToPreviousLayout();
        return true;




    }
}
