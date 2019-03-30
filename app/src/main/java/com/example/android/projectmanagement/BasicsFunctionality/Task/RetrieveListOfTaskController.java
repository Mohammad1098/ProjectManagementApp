package com.example.android.projectmanagement.BasicsFunctionality.Task;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.android.projectmanagement.BasicsFunctionality.Adapter.RetrieveTasksAdapter;
import com.example.android.projectmanagement.BasicsFunctionality.DataBase.Schema;

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


    public RetrieveListOfTaskController( Activity activity  ) {

        this.activity = activity;

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


    public String retrieveTaskById(long taskId){

        retrieveListOfTaskDA = new RetrieveListOfTaskDA(this.activity );


        return retrieveListOfTaskDA.retrieveTaskById(taskId);

    }


    public int returnTaskDuration(long taskId){

        retrieveListOfTaskDA = new RetrieveListOfTaskDA(this.activity );


        return retrieveListOfTaskDA.returnTaskDuration(taskId);

    }


}
