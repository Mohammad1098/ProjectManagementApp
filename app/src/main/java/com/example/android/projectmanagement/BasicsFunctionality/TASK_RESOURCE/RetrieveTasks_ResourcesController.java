package com.example.android.projectmanagement.BasicsFunctionality.TASK_RESOURCE;

import android.app.Activity;
import android.widget.ListView;

import com.example.android.projectmanagement.BasicsFunctionality.Adapter.RetrieveTasksAdapter;
import com.example.android.projectmanagement.BasicsFunctionality.Adapter.RetrieveTasks_ResourcesAdapter;
import com.example.android.projectmanagement.BasicsFunctionality.Task.RetrieveListOfTaskDA;
import com.example.android.projectmanagement.BasicsFunctionality.Task.Task;

import java.util.ArrayList;

public class RetrieveTasks_ResourcesController {


    private RetrieveTasks_ResourcesDA retrieveTasksResourcesDA;
    private RetrieveTasks_ResourcesAdapter retrieveTasksResourcesAdapter;
    private Activity activity;
    private ListView listView;

    public RetrieveTasks_ResourcesController(Activity activity , ListView listView){

        this.activity = activity;
        this.listView = listView;

    }

    public RetrieveTasks_ResourcesController(Activity activity ){

        this.activity = activity;

    }



    public boolean retrieveTask_Resource (){

        retrieveTasksResourcesDA = new RetrieveTasks_ResourcesDA(this.activity );

        ArrayList<Task_Resource> task_resourceList = retrieveTasksResourcesDA.retrieveTask_Resource();


        if(task_resourceList != null) {
            retrieveTasksResourcesAdapter = new RetrieveTasks_ResourcesAdapter(activity.getApplicationContext(), task_resourceList);
            listView.setAdapter(retrieveTasksResourcesAdapter);
            return true;
        }
        else{

            return false;
        }

    }


    public double getProjectCost(){

        retrieveTasksResourcesDA = new RetrieveTasks_ResourcesDA(this.activity );

        return retrieveTasksResourcesDA.getProjectCost();

    }

}
