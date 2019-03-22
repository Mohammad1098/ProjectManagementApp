package com.example.android.projectmanagement.BasicsFunctionality.Task;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.projectmanagement.R;

import java.util.Calendar;

public class add_New_Task extends AppCompatActivity {

    private EditText taskNameEditText;
    private Button taskStartDate,taskEndDate,addTask;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
    private int day,month,year;
    private int startDay,startMonth,startYear;
    private int endDay,endMonth,endYear;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_task);
        createViews();

    }


    private void createViews(){

        taskNameEditText = findViewById(R.id.task_name_Lay_add_new_task);

        taskStartDate = findViewById(R.id.task_startDate_Lay_add_new_task);

        taskEndDate = findViewById(R.id.task_endDate_Lay_add_new_task);

        addTask = findViewById(R.id.add_new_task_Lay_add_new_task);

        taskStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                day= calendar.get(Calendar.DAY_OF_MONTH);
                month= calendar.get(Calendar.MONTH)+1;
                year= calendar.get(Calendar.YEAR);


                datePickerDialog = new DatePickerDialog(add_New_Task.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        startDay =dayOfMonth;
                        startMonth =month;
                        startYear=year;



                    }
                },year , month , day );


                datePickerDialog.show();

            }



        });



        taskEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                day= calendar.get(Calendar.DAY_OF_MONTH);
                month= calendar.get(Calendar.MONTH)+1;
                year= calendar.get(Calendar.YEAR);


                datePickerDialog = new DatePickerDialog(add_New_Task.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        endDay =dayOfMonth;
                        endMonth =month;
                        endYear=year;



                    }
                },year , month , day );


                datePickerDialog.show();

            }



        });

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTaskToDateBase();
            }
        });

    }




    private void addTaskToDateBase(){


        String taskName = taskNameEditText.getText().toString().trim();



        if(TextUtils.isEmpty(taskName) ){

            Toast.makeText(getApplicationContext() , "Please write task name" , Toast.LENGTH_LONG).show();
            return;

        }


        if(startDay==0 || startMonth ==0 || startYear == 0 || endDay==0 || endMonth ==0 || endYear == 0){

            Toast.makeText(getApplicationContext() , "Please select start/end date" , Toast.LENGTH_LONG).show();
            return;

        }



        //ContentValues contentValues = new ContentValues();

        //contentValues.put(Schema.Device.NAME , deviceName);
       // contentValues.put(Schema.Device.PIN , devicePin);
        //contentValues.put(Schema.Device.ROOM , deviceRoom);
        //contentValues.put(Schema.Device.TYPE , selectedCategory);

        //getContentResolver().insert(Schema.Device.CONTENT_URI, contentValues);

        //returnToPreviousLayout();


    }



    private void returnToPreviousLayout(){

        //Intent openSpecificDeviceLayoutIntent = new Intent(Add_new_device.this, RetrieveSpecificDeviceBoundary.class);


        //send the id of selected device to RetrieveListOfOperationBoundary class
        //openSpecificDeviceLayoutIntent.putExtra("TYPE", type);
        //openSpecificDeviceLayoutIntent.putExtra("MICROCONTROLLER_ID", MicroControllerID);


        //startActivity(openSpecificDeviceLayoutIntent);


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
