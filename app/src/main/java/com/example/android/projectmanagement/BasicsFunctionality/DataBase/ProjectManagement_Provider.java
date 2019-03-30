package com.example.android.projectmanagement.BasicsFunctionality.DataBase;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;



public class ProjectManagement_Provider extends ContentProvider {


    private DbHelper mdbHelper;

    private static final UriMatcher sUriMatcher  = new UriMatcher(UriMatcher.NO_MATCH);


     static {

        // for Task table
        sUriMatcher.addURI(Schema.Task.CONTENT_AUTHORITY , Schema.Task.PATH , 1);

         // for Resource table
        sUriMatcher.addURI(Schema.Resource.CONTENT_AUTHORITY , Schema.Resource.PATH , 2);

         sUriMatcher.addURI(Schema.Task_Resource.CONTENT_AUTHORITY , Schema.Task_Resource.PATH , 3);


     };



    @Override
    public boolean onCreate() {

        mdbHelper = new DbHelper(getContext());

        return true;
    }


    @Override
    public Cursor query( Uri uri, String[] projection,String selection, String[] selectionArgs, String sortOrder) {

        int match = sUriMatcher.match(uri);

        SQLiteDatabase db = mdbHelper.getReadableDatabase();

        Cursor cursor = null;
        switch (match){

            case 1:
                cursor = db.query(Schema.Task.TABLE_NAME , projection , selection , selectionArgs , null , null , sortOrder );
                break;

            case 2:
                cursor = db.query(Schema.Resource.TABLE_NAME , projection , selection , selectionArgs , null , null , sortOrder );
                break;

            case 3:
                cursor = db.query(Schema.Task_Resource.TABLE_NAME , projection , selection , selectionArgs , null , null , sortOrder );
                break;

            default:
                throw  new IllegalArgumentException("Error "+ uri);

        }

        cursor.setNotificationUri(getContext().getContentResolver() , uri);

        return cursor;



    }




    @Override
    public Uri insert(Uri uri,ContentValues values) {

        int match = sUriMatcher.match(uri);

        switch (match){

            case 1 :
                return insertRecord(uri ,values , match );

            case 2 :
                return insertRecord(uri ,values , match );

            case 3 :
                return insertRecord(uri ,values , match );

            default:
                return null;

        }
    }


    private Uri insertRecord(Uri uri , ContentValues contentValues , int match){


        SQLiteDatabase db = mdbHelper.getWritableDatabase();

        long id = -1;
        switch (match){


            case 1:
                id=db.insert(Schema.Task.TABLE_NAME , null , contentValues);
                break;

            case 2:
                id=db.insert(Schema.Resource.TABLE_NAME , null , contentValues);
                break;

            case 3:
                id=db.insert(Schema.Task_Resource.TABLE_NAME , null , contentValues);
                break;

            default:
                return null;


        }


        return ContentUris.withAppendedId(uri , id);

    }


    @Override
    public int update(Uri uri, ContentValues values,String selection,  String[] selectionArgs) {
        return 0;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }


    @Override
    public String getType( Uri uri) {
        return null;
    }
}
