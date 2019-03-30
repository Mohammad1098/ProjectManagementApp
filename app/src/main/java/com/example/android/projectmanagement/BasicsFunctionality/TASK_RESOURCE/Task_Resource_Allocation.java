package com.example.android.projectmanagement.BasicsFunctionality.TASK_RESOURCE;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands.RetrieveBasicsCommandBoundary;
import com.example.android.projectmanagement.BasicsFunctionality.DataBase.Schema;
import com.example.android.projectmanagement.BasicsFunctionality.Resource.Resource;
import com.example.android.projectmanagement.BasicsFunctionality.Resource.RetrieveListOfResourceController;
import com.example.android.projectmanagement.BasicsFunctionality.Task.AddNewTask;
import com.example.android.projectmanagement.BasicsFunctionality.Task.RetrieveListOfTaskBoundary;
import com.example.android.projectmanagement.R;

import java.util.ArrayList;

public class Task_Resource_Allocation extends AppCompatActivity {

    private TextView taskName,selectedResources;
    private Button add_resource_to_task , selecteResource;
    private String[] resources_List;
    private boolean[] checked_resources;
    private ArrayList<Integer> user_resources_selected;
    private ArrayList<String> resources_List_selected;
    private Long taskId;

    @Override
    protected void onCreate(Bundle sa){


        super.onCreate(sa);
        setContentView(R.layout.task_resource_allocation);
        createViews();
    }


    private void createViews(){

        Intent TaskIntent = getIntent();

        taskId = TaskIntent.getLongExtra("TASK_ID",  -1);


        taskName = findViewById(R.id.task_name_Lay_task_resource_allocation);

        selectedResources = findViewById(R.id.display_resource_selected_Lay_task_resource_allocation);

        selecteResource = findViewById(R.id.resource_selected_Lay_task_resource_allocation);

        add_resource_to_task = findViewById(R.id.add_resource_to_task);

        user_resources_selected = new ArrayList<>();

        resources_List_selected = new ArrayList<>();

        resources_List = returnListOfResources();

        checked_resources = new boolean[resources_List.length]; // to know how many items we need based on the number of resources

        selecteResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0 ; i<checked_resources.length ; i ++){
                    checked_resources[i] = false;
                    user_resources_selected.clear();
                    selectedResources.setText("");
                    resources_List_selected.clear();

                }


                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Task_Resource_Allocation.this);

                mBuilder.setTitle("Select Resources ");

                mBuilder.setMultiChoiceItems(resources_List, checked_resources, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position , boolean isChecked) {



                        if (isChecked){  // if the user select any item


                            if(!user_resources_selected.contains(position) ){  // we check that item has not added before

                                user_resources_selected.add(position); // we add the item to user_resource_selected
                            }

                            else {

                                user_resources_selected.remove(position); // we remove the item from  user_resource_selected
                            }


                        }

                    }



                });

                mBuilder.setCancelable(false);

                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String items = "";

                        for (int i = 0 ; i < user_resources_selected.size() ; i++){

                            resources_List_selected.add(resources_List[user_resources_selected.get(i)]); // add the resources selected to the list
                            items = items + resources_List[user_resources_selected.get(i)];

                            if (i != user_resources_selected.size() - 1){

                                items = items +", ";

                            }

                        }

                        selectedResources.setText(items);

                    }
                });

                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


                mBuilder.setNeutralButton("Clear All ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        for (int i = 0 ; i<checked_resources.length ; i ++){

                            checked_resources[i] = false;
                            user_resources_selected.clear();
                            selectedResources.setText("");
                            resources_List_selected.clear();

                        }

                    }
                });

                AlertDialog dialog = mBuilder.create();

                dialog.show();
            }
        });



        //////////////////

        add_resource_to_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addResourceToDA();
            }
        });



    }


    private void addResourceToDA(){



        ArrayList<Long> resourceIds = new ArrayList<>();

        resourceIds = returnIdOfResources();

        if(resourceIds == null){

            Toast.makeText(this , "Please select Resources" , Toast.LENGTH_LONG).show();
            return;
        }



        for (int i = 0 ; i<resourceIds.size() ; i++){

            ContentValues contentValues = new ContentValues();

            contentValues.put(Schema.Task_Resource.TASK_ID , taskId);
            contentValues.put(Schema.Task_Resource.RESOURCE_ID , resourceIds.get(i));

            getContentResolver().insert(Schema.Task_Resource.CONTENT_URI , contentValues );

            contentValues.clear();

        }

        returnToPreviousLayout();





    }


    private ArrayList<Long> returnIdOfResources(){


        if(resources_List_selected.size() == 0 ){

            return null;
        }
        RetrieveListOfResourceController resourceController = new RetrieveListOfResourceController(Task_Resource_Allocation.this);

        return resourceController.retrieveResourcesId(resources_List_selected);


    }

    private String[] returnListOfResources(){

        RetrieveListOfResourceController retrieveListOfResourceController = new RetrieveListOfResourceController(Task_Resource_Allocation.this);

        ArrayList<Resource> resourceList = retrieveListOfResourceController.retrieveResources();

        String[] resource = new String[resourceList.size()] ;

        for (int i = 0 ; i <resourceList.size() ; i++){

            if(resourceList.get(i).getResourceType() == 1 || resourceList.get(i).getResourceType() == 2){


                resource[i] = resourceList.get(i).getResourceName() ;

            }

            if(resourceList.get(i).getResourceType() == 3 ){


                resource[i] =  resourceList.get(i).getMaterial();

            }



        }


        return resource;

    }


    private void returnToPreviousLayout(){

        Intent openHomeScreenLayoutIntent = new Intent(Task_Resource_Allocation.this, RetrieveListOfTaskBoundary.class);

        startActivity(openHomeScreenLayoutIntent);


    }


    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        returnToPreviousLayout();

                    }
                }).create().show();


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                new AlertDialog.Builder(this)
                        .setTitle("Really Exit?")
                        .setMessage("Are you sure you want to exit?")
                        .setNegativeButton(android.R.string.no, null)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface arg0, int arg1) {
                                returnToPreviousLayout();

                            }
                        }).create().show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
