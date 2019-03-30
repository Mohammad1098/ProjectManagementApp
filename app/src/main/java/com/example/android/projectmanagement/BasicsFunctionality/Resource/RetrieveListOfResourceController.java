package com.example.android.projectmanagement.BasicsFunctionality.Resource;

import android.app.Activity;
import android.util.Log;
import android.widget.ListView;

import com.example.android.projectmanagement.BasicsFunctionality.Adapter.RetrieveResourceAdapter;

import java.util.ArrayList;

public class RetrieveListOfResourceController {


    private Activity activity;
    private ListView resourceList;
    private RetrieveListOfResourceDA retrieveListOfResourceDA;
    private RetrieveResourceAdapter retrieveResourceAdapter;

    public RetrieveListOfResourceController(Activity activity , ListView listView){

        this.activity = activity;
        this.resourceList = listView;

    }

    public RetrieveListOfResourceController(Activity activity ){

        this.activity = activity;

    }

    public boolean retrieveListOfResources(){

        retrieveListOfResourceDA = new RetrieveListOfResourceDA(this.activity);

        ArrayList<Resource> resourceList = retrieveListOfResourceDA.retrieveListOfResources();


        if(resourceList != null){

            retrieveResourceAdapter = new RetrieveResourceAdapter(this.activity , resourceList);
            this.resourceList.setAdapter(retrieveResourceAdapter);
            return true;

        }

        return false;

    }



    public ArrayList<Resource> retrieveResources(){

        retrieveListOfResourceDA = new RetrieveListOfResourceDA(this.activity);

        ArrayList<Resource> resourceList = retrieveListOfResourceDA.retrieveListOfResources();


        if(resourceList != null){


            return resourceList;

        }

        return null;

    }



    public ArrayList<Long> retrieveResourcesId(ArrayList<String> resource_Name){

        retrieveListOfResourceDA = new RetrieveListOfResourceDA(this.activity);

        return retrieveListOfResourceDA.retrieveResourcesId(resource_Name);

    }


    public String retrieveResourcesById(long resourceId){

        retrieveListOfResourceDA = new RetrieveListOfResourceDA(this.activity);


        return retrieveListOfResourceDA.retrieveResourcesById(resourceId);


    }


    public double resourceCost(long resourceId , long taskId){

        retrieveListOfResourceDA = new RetrieveListOfResourceDA(this.activity);

        return retrieveListOfResourceDA.resourceCost(resourceId , taskId);


    }





}
