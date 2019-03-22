package com.example.android.projectmanagement.BasicsFunctionality.DataBase;

import android.net.Uri;
import android.provider.BaseColumns;

public final class Schema {



    public static abstract class Task implements BaseColumns{


        public static final String CONTENT_AUTHORITY = "com.example.android.ProjectManagement";

        public static final Uri BASE_URI = Uri.parse("content://"+CONTENT_AUTHORITY);

        public static final String PATH = "Task";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI , PATH);

        public static final String TABLE_NAME = "Task";

        public static final String ID = BaseColumns._ID;

        public static final String TASK_NAME ="TASK_NAME";

        public static final String TASK_DURATION ="TASK_DURATION";

        public static final String START_DATE ="START_DATE";

        public static final String END_DATE ="END_DATE";



    }


    public static abstract class Resource implements BaseColumns{


        public static final String CONTENT_AUTHORITY = "com.example.android.ProjectManagement";

        public static final Uri BASE_URI = Uri.parse("content://"+CONTENT_AUTHORITY);

        public static final String PATH = "Resource";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI , PATH);

        public static final String TABLE_NAME = "Resource";

        public static final String ID = BaseColumns._ID;

        public static final String RESOURCE_NAME ="RESOURCE_NAME";

        public static final String RESOURCE_TYPE ="RESOURCE_TYPE";

        public static final String MATERIAL ="MATERIAL";

        public static final String NUMBER_OF_SOURCE ="NUMBER_OF_SOURCE";

        public static final String SALARY_PER_HOURE ="SALARY_PER_HOURE";

        public static final String OVERTIME ="OVERTIME";

        public static final String COST_USE ="COST_USE";





    }

}
