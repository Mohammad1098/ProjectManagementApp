package com.example.android.projectmanagement.BasicsFunctionality.Adapter;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.android.projectmanagement.BasicsFunctionality.Task.Task;
import com.example.android.projectmanagement.R;
import java.util.ArrayList;
import java.util.Date;

public class RetrieveTasksAdapter extends ArrayAdapter<Task> {

    public RetrieveTasksAdapter(Context context , ArrayList<Task> list){

        super(context , 0 , list);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_list_item, parent , false);
        }


        Task currentTask = getItem(position);


        TextView taskName = (TextView) convertView.findViewById(R.id.task_name_Lay_task_list_item);

        taskName.setText(currentTask.getTaskName());


        TextView taskStartDate = (TextView) convertView.findViewById(R.id.task_start_date_Lay_task_list_item);

        taskStartDate.setText(returnDateAsString(currentTask.getStartDate()));


        TextView taskEndDate = (TextView) convertView.findViewById(R.id.task_end_date_Lay_task_list_item);

        taskEndDate.setText(returnDateAsString(currentTask.getEndDate()));



        TextView taskDuration = (TextView) convertView.findViewById(R.id.task_duration_Lay_task_list_item);

        int day = returnDays(currentTask.getDuration());
        if(day > 1){

            taskDuration.setText(String.valueOf(day)+" Days");
        }
        else {

            taskDuration.setText(String.valueOf(day)+" Day");

        }




        return convertView;


    }



    private String returnDateAsString(long dateAsLong){


        String dateString = DateFormat.format("MM/dd/yyyy", new Date(dateAsLong)).toString();

        return dateString;
    }

    private int returnDays(long time){


        int days = (int) (time / (1000*60*60*24));

        return days+1;

    }

}
