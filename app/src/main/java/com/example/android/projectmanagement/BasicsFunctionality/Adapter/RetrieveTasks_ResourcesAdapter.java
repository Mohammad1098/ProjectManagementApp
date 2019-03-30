package com.example.android.projectmanagement.BasicsFunctionality.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.android.projectmanagement.BasicsFunctionality.TASK_RESOURCE.Task_Resource;
import com.example.android.projectmanagement.R;

import java.util.ArrayList;

public class RetrieveTasks_ResourcesAdapter extends ArrayAdapter<Task_Resource> {


    public RetrieveTasks_ResourcesAdapter(Context context , ArrayList<Task_Resource> list){

        super(context , 0 , list);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_resource_list_item, parent , false);
        }


        Task_Resource currentTask_Resource = getItem(position);



        TextView task_Column = convertView.findViewById(R.id.task_Column_Lay_retrieve_task_resource_list_item);

        task_Column.setText("Task");




        TextView taskName = convertView.findViewById(R.id.task_name_Lay_retrieve_task_resource_list_item);

        taskName.setText(currentTask_Resource.getTaskName());




        TextView resource_Column = convertView.findViewById(R.id.resource_Column_Lay_retrieve_task_resource_list_item);

        resource_Column.setText("Resources");




        TextView resourceName = convertView.findViewById(R.id.resource_name_Lay_retrieve_task_resource_list_item);

        resourceName.setText(String.valueOf(currentTask_Resource.getResourceName()));


        TextView taskTotalCost = convertView.findViewById(R.id.task_total_cost_Lay_retrieve_task_resource_list_item);


        if(currentTask_Resource.getTotalCost() !=0){

            taskTotalCost.setText(String.valueOf(currentTask_Resource.getTotalCost())+"$");

        }
        else {

            taskTotalCost.setText("0$");


        }


        return convertView;


    }


}
