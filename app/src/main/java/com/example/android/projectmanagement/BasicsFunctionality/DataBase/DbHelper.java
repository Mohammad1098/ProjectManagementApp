package com.example.android.projectmanagement.BasicsFunctionality.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="ProjectManagement.db";
    private static final int DATABASE_VERSION=1;

    public DbHelper(Context context){

        super(context , DATABASE_NAME , null , DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String TASK_Table ="CREATE TABLE "+Schema.Task.TABLE_NAME +"("

                +Schema.Task.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Schema.Task.TASK_NAME +" TEXT NOT NULL ,"
                +Schema.Task.START_DATE +" INTEGER NOT NULL ,"
                +Schema.Task.END_DATE +" INTEGER NOT NULL ,"
                +Schema.Task.TASK_DURATION +" INTEGER NOT NULL );";



        String Resource_Table = "CREATE TABLE "+Schema.Resource.TABLE_NAME +"("

                +Schema.Resource.ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                +Schema.Resource.RESOURCE_NAME +" TEXT NOT NULL ,"
                +Schema.Resource.RESOURCE_TYPE +" INTEGER  ,"
                +Schema.Resource.MATERIAL +" INTEGER  ,"
                +Schema.Resource.NUMBER_OF_SOURCE +" INTEGER  ,"
                +Schema.Resource.SALARY_PER_HOURE +" REAL  ,"
                +Schema.Resource.OVERTIME +" REAL  ,"
                +Schema.Resource.COST_USE +" REAL  );";



        db.execSQL(TASK_Table);
        db.execSQL(Resource_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}