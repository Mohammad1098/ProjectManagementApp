package com.example.android.projectmanagement.BasicsFunctionality.TASK_RESOURCE;

import android.app.Activity;
import android.database.Cursor;
import android.util.Log;

import com.example.android.projectmanagement.BasicsFunctionality.DataBase.Schema;
import com.example.android.projectmanagement.BasicsFunctionality.Resource.RetrieveListOfResourceController;
import com.example.android.projectmanagement.BasicsFunctionality.Task.RetrieveListOfTaskController;

import java.util.ArrayList;

public class RetrieveTasks_ResourcesDA {


    private ArrayList<Task_Resource> task_resourceList;
    private Activity activity;
    private Cursor cursor,cursor2,cursor3;



    public RetrieveTasks_ResourcesDA(Activity activity){


        this.activity = activity;
        cursor = activity.getApplicationContext().getContentResolver().query(Schema.Task_Resource.CONTENT_URI, null, null, null, null);
        cursor2 = activity.getApplicationContext().getContentResolver().query(Schema.Task_Resource.CONTENT_URI, null, null, null, null);
        cursor3 = activity.getApplicationContext().getContentResolver().query(Schema.Task_Resource.CONTENT_URI, null, null, null, null);
    }


    public ArrayList<Task_Resource> retrieveTask_Resource() {


        RetrieveListOfTaskController retrieveListOfTaskController = new RetrieveListOfTaskController(this.activity);

        if (cursor == null) {

            return null;
        }

        task_resourceList = new ArrayList<>();


        ArrayList<Long> tasksDone = new ArrayList<>();

        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {

            Task_Resource task_resource = new Task_Resource();

            Long taskId = cursor.getLong(cursor.getColumnIndex(Schema.Task_Resource.TASK_ID));

            Long resourceId = cursor.getLong(cursor.getColumnIndex(Schema.Task_Resource.RESOURCE_ID));



            if (!tasksDone.contains(taskId)) {


                task_resource.setTaskName(retrieveListOfTaskController.retrieveTaskById(taskId));

                task_resource.setResourceName(returnResource(taskId));


                if(getTaskCost(resourceId , taskId) !=0){


                    task_resource.setTotalCost(getTaskCost(resourceId , taskId));

                }
                task_resourceList.add(task_resource);

            }

            tasksDone.add(taskId);


            cursor.moveToNext();

        }


        return task_resourceList;

        }










        private String returnResource(long taskId){


            if (cursor2 == null) {

                return null;
            }

            RetrieveListOfResourceController retrieveListOfResourceController = new RetrieveListOfResourceController(this.activity);


            String resourcesName="";

            cursor2.moveToFirst();

            for (int i = 0 ; i< cursor2.getCount() ; i++){

                if(cursor2.getLong(cursor2.getColumnIndex(Schema.Task_Resource.TASK_ID))== taskId){

                    resourcesName += retrieveListOfResourceController.retrieveResourcesById(cursor2.getLong(cursor2.getColumnIndex(Schema.Task_Resource.RESOURCE_ID)))+" ,";

                }

                cursor2.moveToNext();

            }



            return resourcesName;


        }



        private double getTaskCost(long resourceId , long taskId){



            if (cursor3 == null) {

                return 0;
            }

            RetrieveListOfResourceController retrieveListOfResourceController = new RetrieveListOfResourceController(this.activity);


            double resourcesCost=0;

            cursor3.moveToFirst();

            for (int i = 0 ; i< cursor3.getCount() ; i++){

                if(cursor3.getLong(cursor3.getColumnIndex(Schema.Task_Resource.TASK_ID))== taskId){

                    resourcesCost += retrieveListOfResourceController.resourceCost(cursor3.getLong(cursor3.getColumnIndex(Schema.Task_Resource.RESOURCE_ID)) , taskId);

                }

                cursor3.moveToNext();

            }



            return resourcesCost;


        }



    public double getProjectCost(){



        if (cursor3 == null) {

            return 0;
        }

        RetrieveListOfResourceController retrieveListOfResourceController = new RetrieveListOfResourceController(this.activity);


        double ProjectCost=0;

        cursor3.moveToFirst();

        ArrayList<Long> taskDone = new ArrayList<>();

        ArrayList<Long> resourceDone = new ArrayList<>();

        long taskId;
        long resourceId;
        for (int i = 0 ; i< cursor3.getCount() ; i++){


            taskId = cursor3.getLong(cursor3.getColumnIndex(Schema.Task_Resource.TASK_ID));

            resourceId = cursor3.getLong(cursor3.getColumnIndex(Schema.Task_Resource.RESOURCE_ID));


            if(!taskDone.contains(taskId) || !resourceDone.contains(resourceId) ) {

                ProjectCost += retrieveListOfResourceController.resourceCost(cursor3.getLong(cursor3.getColumnIndex(Schema.Task_Resource.RESOURCE_ID)), cursor3.getLong(cursor3.getColumnIndex(Schema.Task_Resource.TASK_ID)));
            }

            taskDone.add(taskId);
            resourceDone.add(resourceId);

            cursor3.moveToNext();

        }



        return ProjectCost;


    }


}
