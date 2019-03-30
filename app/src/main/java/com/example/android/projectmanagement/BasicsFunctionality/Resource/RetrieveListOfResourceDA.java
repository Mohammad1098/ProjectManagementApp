package com.example.android.projectmanagement.BasicsFunctionality.Resource;

import android.app.Activity;
import android.database.Cursor;
import android.util.Log;

import com.example.android.projectmanagement.BasicsFunctionality.DataBase.Schema;
import com.example.android.projectmanagement.BasicsFunctionality.Task.RetrieveListOfTaskController;
import com.example.android.projectmanagement.BasicsFunctionality.Task.RetrieveListOfTaskDA;

import java.util.ArrayList;

public class RetrieveListOfResourceDA {

    private Activity activity;
    private Cursor cursor,cursor2,cursor3;



    public RetrieveListOfResourceDA(Activity activity){

        this.activity = activity;
        cursor = this.activity.getApplicationContext().getContentResolver().query(Schema.Resource.CONTENT_URI , null , null , null , null);
        cursor2 = this.activity.getApplicationContext().getContentResolver().query(Schema.Resource.CONTENT_URI , null , null , null , null);
        cursor3 = this.activity.getApplicationContext().getContentResolver().query(Schema.Resource.CONTENT_URI , null , null , null , null);

    }



    public ArrayList<Resource> retrieveListOfResources(){

        if (cursor == null) {


            return null;
        }

        ArrayList<Resource>  resourceList = new ArrayList<>();

        // by default cursor will point to -1 position
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {

            Resource resource = new Resource();

            //manipulate data
            resource.setResourceName(cursor.getString(cursor.getColumnIndex(Schema.Resource.RESOURCE_NAME)));
            resource.setResourceType(cursor.getInt(cursor.getColumnIndex(Schema.Resource.RESOURCE_TYPE)));
            resource.setMaterial(cursor.getString(cursor.getColumnIndex(Schema.Resource.MATERIAL)));
            resource.setNumberOfResource(cursor.getInt(cursor.getColumnIndex(Schema.Resource.NUMBER_OF_SOURCE)));
            resource.setSalary(cursor.getDouble(cursor.getColumnIndex(Schema.Resource.SALARY_PER_HOURE)));
            resource.setOverTime(cursor.getDouble(cursor.getColumnIndex(Schema.Resource.OVERTIME)));
            resource.setMaterialCost(cursor.getDouble(cursor.getColumnIndex(Schema.Resource.COST_USE)));



            // add task to the list
            resourceList.add(resource);


            // move to next position
            cursor.moveToNext();


        }

        return resourceList;

    }



    public ArrayList<Long> retrieveResourcesId(ArrayList<String> resources_Name){

        if (cursor2 == null) {

            return null;
        }

        ArrayList<Long>  resourceIdList = new ArrayList<>();

        // by default cursor will point to -1 position
        cursor2.moveToFirst();

        for (int i = 0; i < cursor2.getCount(); i++) {


            for (int j = 0 ; j < resources_Name.size() ; j++) {



                if (cursor2.getInt(cursor2.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 1 || cursor2.getInt(cursor2.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 2) {

                    if (cursor2.getString(cursor2.getColumnIndex(Schema.Resource.RESOURCE_NAME)).equalsIgnoreCase(resources_Name.get(j).toString().trim())) {

                        resourceIdList.add(cursor2.getLong(cursor2.getColumnIndex(Schema.Resource.ID)));


                    }
                }


                if (cursor2.getInt(cursor2.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 3) {

                    if (cursor2.getString(cursor2.getColumnIndex(Schema.Resource.MATERIAL)).equalsIgnoreCase(resources_Name.get(j).toString().trim())) {


                        resourceIdList.add(cursor2.getLong(cursor2.getColumnIndex(Schema.Resource.ID)));


                    }
                }

            }

            // move to next position
            cursor2.moveToNext();


        }


        return resourceIdList;

    }






    public String retrieveResourcesById(long resourceId){

        if (cursor3 == null) {


            return null;
        }

        // by default cursor will point to -1 position
        cursor3.moveToFirst();

        for (int i = 0; i < cursor3.getCount(); i++) {


            if(cursor3.getLong(cursor3.getColumnIndex(Schema.Resource.ID))== resourceId){


                if(cursor3.getInt(cursor3.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 1 || cursor3.getInt(cursor3.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 2 ) {


                    return cursor3.getString(cursor3.getColumnIndex(Schema.Resource.RESOURCE_NAME));

                }


                if(cursor3.getInt(cursor3.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 3) {


                    return cursor3.getString(cursor3.getColumnIndex(Schema.Resource.MATERIAL));

                }
            }

            // move to next position
            cursor3.moveToNext();


        }

        return null;
    }







    public double resourceCost(long resourceId , long taskId) {

        RetrieveListOfTaskController retrieveListOfTaskController = new RetrieveListOfTaskController(this.activity);

        if (cursor2 == null) {

            return 0;
        }

        // by default cursor will point to -1 position
        cursor2.moveToFirst();

        for (int i = 0; i < cursor2.getCount(); i++) {


            if (cursor2.getLong(cursor2.getColumnIndex(Schema.Resource.ID)) == resourceId) {


                if (cursor2.getInt(cursor2.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 1) {

                    Log.e("retri resource da" , "type 1");

                    return ( cursor2.getDouble(cursor2.getColumnIndex(Schema.Resource.SALARY_PER_HOURE)) + cursor2.getDouble(cursor2.getColumnIndex(Schema.Resource.OVERTIME))) * retrieveListOfTaskController.returnTaskDuration(taskId);

                }


                if (cursor2.getInt(cursor2.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 2 || cursor2.getInt(cursor2.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 3) {

                    Log.e("retri resource da" , "type 2/3");


                    return cursor2.getDouble(cursor2.getColumnIndex(Schema.Resource.COST_USE))* cursor2.getInt(cursor2.getColumnIndex(Schema.Resource.NUMBER_OF_SOURCE));

                }

                // move to next position

            }

            cursor2.moveToNext();

        }
            return 0;

        }






    }


