package com.example.android.projectmanagement.BasicsFunctionality.Task;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.android.projectmanagement.BasicsFunctionality.Adapter.RetrieveTasksAdapter;

import java.util.ArrayList;

public class RetrieveListOfTaskController  extends AppCompatActivity {


    private RetrieveListOfTaskDA retrieveListOfTaskDA;
    private RetrieveTasksAdapter retrieveTasksAdapter;
    private Activity activity;
    private ListView listView;




    public RetrieveListOfTaskController( Activity activity , ListView listView ) {

        this.activity = activity;
        this.listView = listView;

    }


    public boolean retrieveListOfTask (){

        retrieveListOfTaskDA = new RetrieveListOfTaskDA(this.activity );

        ArrayList<Task> taskList = retrieveListOfTaskDA.retrieveListOfTask();


        if(taskList != null) {
            retrieveTasksAdapter = new RetrieveTasksAdapter(activity.getApplicationContext(), taskList);
            listView.setAdapter(retrieveTasksAdapter);
            return true;
        }
        else{

            return false;
        }

    }


}
