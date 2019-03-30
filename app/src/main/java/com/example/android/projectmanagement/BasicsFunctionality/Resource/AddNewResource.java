package com.example.android.projectmanagement.BasicsFunctionality.Resource;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.projectmanagement.BasicsFunctionality.Adapter.ResourceSpinnerAdapter;
import com.example.android.projectmanagement.BasicsFunctionality.BasicsCommands.RetrieveBasicsCommandBoundary;
import com.example.android.projectmanagement.BasicsFunctionality.DataBase.Schema;
import com.example.android.projectmanagement.BasicsFunctionality.Task.AddNewTask;
import com.example.android.projectmanagement.R;

import java.util.ArrayList;


public class AddNewResource extends AppCompatActivity {

    private int selectedResource;
    private Spinner resourceTypeSpinner;
    private EditText resourceNameEditText , materialNameEditText ,numberOfResourceEditText , salaryEditText , overTimeEditText , materialCostEditText;
    private Button addNewResource;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_resource);
        createViews();
        attachResourceSpinnerToListener();


    }


    private void createViews(){

        resourceTypeSpinner = findViewById(R.id.resource_type_Spinner_Lay_add_new_resource);

        resourceNameEditText = findViewById(R.id.resource_name_Lay_add_new_resource);

        materialNameEditText = findViewById(R.id.material_Lay_add_new_resource);

        numberOfResourceEditText = findViewById(R.id.number_of_source_Lay_add_new_resource);

        salaryEditText = findViewById(R.id.salary_Lay_add_new_resource);

        overTimeEditText = findViewById(R.id.over_time_Lay_add_new_resource);

        materialCostEditText = findViewById(R.id.Cost_Use_Lay_add_new_resource);

        addNewResource = findViewById(R.id.add_new_resource_Lay_add_new_resource);

        addNewResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addResourceToDateBase();


            }
        });




        resourceTypeSpinner.setAdapter(createShieldCategorySpinnerItems());


    }



    private ResourceSpinnerAdapter createShieldCategorySpinnerItems(){


        ArrayList<Resource> resourcesSpinnerList = new ArrayList();


        resourcesSpinnerList.add(new Resource("Work" , 1 ));
        resourcesSpinnerList.add(new Resource("Cost" ,  2));
        resourcesSpinnerList.add(new Resource("Material" , 3));

        ResourceSpinnerAdapter shieldSpinnerAdapter = new ResourceSpinnerAdapter(this , resourcesSpinnerList);


        return shieldSpinnerAdapter;
    }

    private void attachResourceSpinnerToListener(){

        resourceTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Resource selectedResourceObj = (Resource) parent.getItemAtPosition(position);

                selectedResource = selectedResourceObj.getResourceType(); //

                createAppropriateEditText(selectedResource);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedResource = -1;

            }
        });

    }


    private void createAppropriateEditText(int type_of_Resource){


        if(type_of_Resource == 1){


            resourceNameEditText.setVisibility(View.VISIBLE);
            resourceNameEditText.setHint("Worker Name");

            numberOfResourceEditText.setVisibility(View.VISIBLE);
            salaryEditText.setVisibility(View.VISIBLE);
            overTimeEditText.setVisibility(View.VISIBLE);


            materialNameEditText.setVisibility(View.GONE);
            materialCostEditText.setVisibility(View.GONE);

        }


        if(type_of_Resource == 2){

            resourceNameEditText.setVisibility(View.VISIBLE);
            resourceNameEditText.setHint("Resource Name");
            numberOfResourceEditText.setVisibility(View.VISIBLE);
            materialCostEditText.setVisibility(View.VISIBLE);


            materialNameEditText.setVisibility(View.GONE);
            salaryEditText.setVisibility(View.GONE);
            overTimeEditText.setVisibility(View.GONE);
        }

        if(type_of_Resource == 3){

            materialNameEditText.setVisibility(View.VISIBLE);
            numberOfResourceEditText.setVisibility(View.VISIBLE);
            materialCostEditText.setVisibility(View.VISIBLE);



            resourceNameEditText.setVisibility(View.GONE);
            salaryEditText.setVisibility(View.GONE);
            overTimeEditText.setVisibility(View.GONE);


        }


    }


    private void  addResourceToDateBase(){


        ContentValues contentValues = new ContentValues();

        contentValues = returnAppropriateContentValues();

        if(contentValues == null){

            return;
        }


        getContentResolver().insert(Schema.Resource.CONTENT_URI, contentValues);

        returnToPreviousLayout();


    }



    private void returnToPreviousLayout(){

        Intent openHomeScreenLayoutIntent = new Intent(AddNewResource.this, RetrieveBasicsCommandBoundary.class);

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


    private ContentValues returnAppropriateContentValues(){


        ContentValues contentValues = new ContentValues();


        if(selectedResource == 1){

            ////////////////////////////////////////////////////////////////

            String resourceName = resourceNameEditText.getText().toString().trim();

            if(TextUtils.isEmpty(resourceName)){

                Toast.makeText(getApplicationContext() , "Please write Resource name" , Toast.LENGTH_LONG).show();
                return null;

            }



            ////////////////////////////////////////////////////////////////
            String numberOfResourceAsString = numberOfResourceEditText.getText().toString().trim();

            if(TextUtils.isEmpty(numberOfResourceAsString)){

                Toast.makeText(getApplicationContext() , "Please write number of resource" , Toast.LENGTH_LONG).show();
                return null;

            }

            int numberOfResource = Integer.valueOf(numberOfResourceAsString);



            ////////////////////////////////////////////////////////////////
            String salaryAsString = salaryEditText.getText().toString().trim();
            if(TextUtils.isEmpty(salaryAsString)){

                Toast.makeText(getApplicationContext() , "Please write salary" , Toast.LENGTH_LONG).show();
                return null;

            }

            double salary = Double.valueOf(salaryAsString);


            ////////////////////////////////////////////////////////////////
            double overTime;


            String overTimeAsString = overTimeEditText.getText().toString().trim();

            if(TextUtils.isEmpty(overTimeAsString)){

                overTime =0;

            }
            else {

                overTime = Double.valueOf(overTimeAsString);

            }


            contentValues.put(Schema.Resource.RESOURCE_NAME , resourceName);
            contentValues.put(Schema.Resource.RESOURCE_TYPE , 1);
            contentValues.put(Schema.Resource.NUMBER_OF_SOURCE , numberOfResource);
            contentValues.put(Schema.Resource.SALARY_PER_HOURE , salary);
            contentValues.put(Schema.Resource.OVERTIME , overTime);

            return contentValues;

        }







        if(selectedResource == 2 ){

            ////////////////////////////////////////////////////////////////

            String resourceName = resourceNameEditText.getText().toString().trim();

            if(TextUtils.isEmpty(resourceName)){

                Toast.makeText(getApplicationContext() , "Please write Resource name" , Toast.LENGTH_LONG).show();
                return null;

            }

            ////////////////////////////////////////////////////////////////
            String numberOfResourceAsString = numberOfResourceEditText.getText().toString().trim();

            if(TextUtils.isEmpty(numberOfResourceAsString)){

                Toast.makeText(getApplicationContext() , "Please write number of resource" , Toast.LENGTH_LONG).show();
                return null;

            }

            int numberOfResource = Integer.valueOf(numberOfResourceAsString);


            //////////////////////////////////////////////////////////////////////
            String materialCostAsString =  materialCostEditText.getText().toString().trim();
            if(TextUtils.isEmpty(materialCostAsString)){

                Toast.makeText(getApplicationContext() , "Please write Cost" , Toast.LENGTH_LONG).show();
                return null;

            }

            double materialCost = Double.valueOf(materialCostAsString);

            contentValues.put(Schema.Resource.RESOURCE_NAME , resourceName);
            contentValues.put(Schema.Resource.RESOURCE_TYPE , 2);
            contentValues.put(Schema.Resource.NUMBER_OF_SOURCE , numberOfResource);
            contentValues.put(Schema.Resource.COST_USE , materialCost);


            return contentValues;


        }







        if(selectedResource == 3){


            String materialName =  materialNameEditText.getText().toString().trim();
            if(TextUtils.isEmpty(materialName)){

                Toast.makeText(getApplicationContext() , "Please write material name" , Toast.LENGTH_LONG).show();
                return null;

            }




            //////////////////////////////////////////////////////////////////////

            String numberOfResourceAsString = numberOfResourceEditText.getText().toString().trim();
            if(TextUtils.isEmpty(numberOfResourceAsString)){

                Toast.makeText(getApplicationContext() , "Please write number of resource" , Toast.LENGTH_LONG).show();
                return null;

            }

            int numberOfResource = Integer.valueOf(numberOfResourceAsString);




            //////////////////////////////////////////////////////////////////////
            String materialCostAsString =  materialCostEditText.getText().toString().trim();
            if(TextUtils.isEmpty(materialCostAsString)){

                Toast.makeText(getApplicationContext() , "Please write Cost" , Toast.LENGTH_LONG).show();
                return null;

            }

            double materialCost = Double.valueOf(materialCostAsString);


            contentValues.put(Schema.Resource.MATERIAL , materialName);
            contentValues.put(Schema.Resource.RESOURCE_TYPE , 3);
            contentValues.put(Schema.Resource.NUMBER_OF_SOURCE , numberOfResource);
            contentValues.put(Schema.Resource.COST_USE , materialCost);

            return contentValues;


        }



        return null;




    }


}
