package com.example.android.projectmanagement.BasicsFunctionality.Reports;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.android.projectmanagement.BasicsFunctionality.TASK_RESOURCE.RetrieveTasks_ResourcesController;
import com.example.android.projectmanagement.R;

public class ProjectOverView extends AppCompatActivity{


    @Override
    protected void onCreate (Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_over_view);
        CreateViews();
    }

    private void CreateViews(){

        TextView projectCost = findViewById(R.id.project_cost_Lay_project_over_view);

        Log.e("dasda" , "cost is "+returnProjectCost());
        projectCost.setText(String.valueOf(returnProjectCost())+"$");


    }


    private double returnProjectCost(){

        RetrieveTasks_ResourcesController retrieveTasks_resourcesController = new RetrieveTasks_ResourcesController(ProjectOverView.this);

        return  retrieveTasks_resourcesController.getProjectCost();


    }


}
