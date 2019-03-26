package com.example.android.projectmanagement.BasicsFunctionality.Resource;

import android.app.Activity;
import android.database.Cursor;
import android.util.Log;

import com.example.android.projectmanagement.BasicsFunctionality.DataBase.Schema;
import java.util.ArrayList;

public class RetrieveListOfResourceDA {

    private Activity activity;
    private Cursor cursor;

    public RetrieveListOfResourceDA(Activity activity){

        this.activity = activity;
        cursor = this.activity.getApplicationContext().getContentResolver().query(Schema.Resource.CONTENT_URI , null , null , null , null);

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

        if (cursor == null) {

            return null;
        }

        ArrayList<Long>  resourceIdList = new ArrayList<>();

        // by default cursor will point to -1 position
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {


            for (int j = 0 ; j < resources_Name.size() ; j++) {



                if (cursor.getInt(cursor.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 1 || cursor.getInt(cursor.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 2) {

                    if (cursor.getString(cursor.getColumnIndex(Schema.Resource.RESOURCE_NAME)).equalsIgnoreCase(resources_Name.get(j).toString().trim())) {

                        resourceIdList.add(cursor.getLong(cursor.getColumnIndex(Schema.Resource.ID)));


                    }
                }


                if (cursor.getInt(cursor.getColumnIndex(Schema.Resource.RESOURCE_TYPE)) == 3) {

                    if (cursor.getString(cursor.getColumnIndex(Schema.Resource.MATERIAL)).equalsIgnoreCase(resources_Name.get(j).toString().trim())) {


                        resourceIdList.add(cursor.getLong(cursor.getColumnIndex(Schema.Resource.ID)));


                    }
                }

            }

            // move to next position
            cursor.moveToNext();


        }


        return resourceIdList;

    }


}
