package com.example.android.projectmanagement.BasicsFunctionality.Task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands.Command;
import com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands.RetrieveBasicsCommandBoundary;
import com.example.android.projectmanagement.BasicsFunctionality.TASK_RESOURCE.Task_Resource_Allocation;
import com.example.android.projectmanagement.R;

public class RetrieveListOfTaskBoundary extends AppCompatActivity {

    private ListView taskListView;
    private RetrieveListOfTaskController retrieveListOfTaskController;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve_list_of_task);
        retrieveListOfTask();
        attachListViewToListener();
    }


    private void retrieveListOfTask(){


        taskListView = findViewById(R.id.task_list_view_Lay_retrieve_list_of_task);

        retrieveListOfTaskController = new RetrieveListOfTaskController(RetrieveListOfTaskBoundary.this, taskListView);


        boolean isListEmpty = retrieveListOfTaskController.retrieveListOfTask();


        if (isListEmpty == false) {
            Toast.makeText(this, "No Tasks Available !", Toast.LENGTH_LONG).show();
        }



    }


    private void attachListViewToListener(){

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent taskAllocationIntent = new Intent(RetrieveListOfTaskBoundary.this , Task_Resource_Allocation.class );

                //save the selected task
                Task task = (Task) parent.getItemAtPosition(position);

                long taskID = task.getID();

                taskAllocationIntent.putExtra("TASK_ID",taskID);

                startActivity(taskAllocationIntent);


            }
        });

    }

    private void returnToPreviousLayout(){

        Intent openHomeScreenLayoutIntent = new Intent(RetrieveListOfTaskBoundary.this, RetrieveBasicsCommandBoundary.class);

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
