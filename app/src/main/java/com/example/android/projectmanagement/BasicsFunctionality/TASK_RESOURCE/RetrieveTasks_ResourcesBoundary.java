package com.example.android.projectmanagement.BasicsFunctionality.TASK_RESOURCE;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.projectmanagement.R;


public class RetrieveTasks_ResourcesBoundary extends AppCompatActivity {

    private ListView task_resource_listView;
    private RetrieveTasks_ResourcesController retrieveTasksResourcesController;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve_task_resource_list_view);
        setTitle("task and resource");
        retrieveListOfTaskResource();

    }

    private void retrieveListOfTaskResource(){


        task_resource_listView = findViewById(R.id.task_resource_list_view_Lay_retrieve_task_resource_list_view);

        retrieveTasksResourcesController = new RetrieveTasks_ResourcesController(RetrieveTasks_ResourcesBoundary.this , task_resource_listView);

        boolean isListEmpty = retrieveTasksResourcesController.retrieveTask_Resource();


        if (isListEmpty == false) {
            Toast.makeText(this, "No Tasks Resources Available !", Toast.LENGTH_LONG).show();
        }

    }


}
