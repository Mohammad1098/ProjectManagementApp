package com.example.android.projectmanagement.BasicsFunctionality.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.android.projectmanagement.BasicsFunctionality.Resource.Resource;
import com.example.android.projectmanagement.R;

import java.util.ArrayList;

public class ResourceSpinnerAdapter extends ArrayAdapter<Resource> {



    public ResourceSpinnerAdapter(Context context , ArrayList<Resource> list){

        super(context , 0 , list );

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        return  initView(position , convertView ,parent );

    }

    @Override
    public View getDropDownView(int position,  View convertView,  ViewGroup parent) {


        return initView(position ,convertView , parent );
    }



    private View initView (int position, View convertView, ViewGroup parent){


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.resource_spinner_adapter_item, parent, false
            );
        }


        Resource currentResource = getItem(position);


        TextView ResourceName =  convertView.findViewById(R.id.resource_name_Lay_resource_spinner_adapter_item);

        ResourceName.setText(currentResource.getResourceName());

        return convertView;
    }
}
