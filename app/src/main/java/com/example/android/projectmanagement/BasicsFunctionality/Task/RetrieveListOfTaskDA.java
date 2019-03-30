package com.example.android.projectmanagement.BasicsFunctionality.Task;

import android.app.Activity;
import android.database.Cursor;
import com.example.android.projectmanagement.BasicsFunctionality.DataBase.Schema;
import java.util.ArrayList;

public class RetrieveListOfTaskDA {


    private ArrayList<Task> taskList;
    private Activity activity;
    private Cursor cursor;


    public RetrieveListOfTaskDA(Activity activity) {

        this.activity = activity;

        cursor = activity.getApplicationContext().getContentResolver().query(Schema.Task.CONTENT_URI, null, null, null, null);


    }


    public ArrayList<Task> retrieveListOfTask() {

        // in this method we will create a list of tasks , manipulate the cursor to get the data and add it to list of tasks

        if (cursor == null) {


            return null;
        }

        taskList = new ArrayList<>();

        // by default cursor will point to -1 position
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {

            Task task = new Task();

            //manipulate data
            task.setID(cursor.getLong(cursor.getColumnIndex(Schema.Task.ID)));
            task.setTaskName(cursor.getString(cursor.getColumnIndex(Schema.Task.TASK_NAME)));
            task.setStartDate(cursor.getLong(cursor.getColumnIndex(Schema.Task.START_DATE)));
            task.setEndDate(cursor.getLong(cursor.getColumnIndex(Schema.Task.END_DATE)));
            task.setDuration(cursor.getInt(cursor.getColumnIndex(Schema.Task.TASK_DURATION)));


            // add task to the list
            taskList.add(task);


            // move to next position
            cursor.moveToNext();


        }

        return taskList;

    }


    public String retrieveTaskById(long taskId) {


        if (cursor == null) {


            return null;
        }

        // by default cursor will point to -1 position
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {


            if(cursor.getLong(cursor.getColumnIndex(Schema.Task.ID))== taskId){


                return cursor.getString(cursor.getColumnIndex(Schema.Task.TASK_NAME));
            }

            // move to next position
            cursor.moveToNext();


        }

        return null;

    }






    public int returnTaskDuration(long taskId){


        if (cursor == null) {


            return 0;
        }

        // by default cursor will point to -1 position
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {


            if(cursor.getLong(cursor.getColumnIndex(Schema.Task.ID))== taskId){

                int days = (int) (cursor.getInt(cursor.getColumnIndex(Schema.Task.TASK_DURATION)) / (1000*60*60*24));

                return days+1;
            }

            // move to next position
            cursor.moveToNext();


        }

        return 0;


    }

}

