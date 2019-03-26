package com.example.android.projectmanagement.BasicsFunctionality.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.projectmanagement.BasicsFunctionality.Resource.Resource;
import com.example.android.projectmanagement.R;
import java.util.ArrayList;
import java.util.List;

public class RetrieveResourceAdapter extends ArrayAdapter<Resource> {

    private ArrayList<String> SalaryOrCostList;

    public RetrieveResourceAdapter(Context context , ArrayList<Resource> list){

        super(context , 0 , list);
        SalaryOrCostList = new ArrayList<>();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.resource_list_item, parent , false);
        }


        Resource currentResource = getItem(position);



        TextView resourceType = convertView.findViewById(R.id.resource_type_Lay_resource_list_item);

        resourceType.setText(returnResourceTypeAsString(currentResource.getResourceType()));




        TextView resourceName = convertView.findViewById(R.id.resource_name_Lay_resource_list_item);

        resourceName.setText(returnResourceNameAsString(currentResource));




        TextView numberOfResourceAsString = convertView.findViewById(R.id.number_of_source_String_Lay_resource_list_item);

        numberOfResourceAsString.setText("Number of Source");




        TextView numberOfResource = convertView.findViewById(R.id.number_of_source_Lay_resource_list_item);

        numberOfResource.setText(String.valueOf(currentResource.getNumberOfResource()));



        SalaryOrCostList = returnSalaryOrCost(currentResource);

        TextView SalaryOrCostAsString = convertView.findViewById(R.id.salary_or_cost_String_Lay_resource_list_item);

        SalaryOrCostAsString.setText(SalaryOrCostList.get(0)); // index 0 contains the Salary Or Cost As string




        TextView SalaryOrCost = convertView.findViewById(R.id.salary_or_cost_Lay_resource_list_item);

        SalaryOrCost.setText(SalaryOrCostList.get(1)+"$"); // index 1 contains the Salary  Or Cost As double



        if(currentResource.getOverTime() != 0){

            TextView overTimeAsString = convertView.findViewById(R.id.over_time_String_Lay_resource_list_item);

            overTimeAsString.setText("OverTime");


            TextView overTime = convertView.findViewById(R.id.over_time_Lay_resource_list_item);

            overTime.setText(String.valueOf(currentResource.getOverTime())+"$");

        }






        return convertView;


    }


    private String returnResourceTypeAsString(int resourceType){


        switch (resourceType){

            case 1 :
                return "Worker";

            case 2 :
                return "Cost";

            case 3 :
                return "Material";


            default:
                return "Wrong resource type";


        }

    }


    private String returnResourceNameAsString(Resource resource){


        switch (resource.getResourceType()){

            case 1 :
                return resource.getResourceName();

            case 2 :
                return resource.getResourceName();

            case 3 :
                return resource.getMaterial();


            default:
                return "Wrong resource name";


        }

    }


    private ArrayList<String> returnSalaryOrCost(Resource resource){

        ArrayList<String> resourceList = new ArrayList<>();

        switch (resource.getResourceType()){

            case 1 :
                resourceList.add("Salary");
                resourceList.add(String.valueOf(resource.getSalary()));
                return resourceList;

            case 2 :
                resourceList.add("Cost");
                resourceList.add(String.valueOf(resource.getMaterialCost()));
                return resourceList;

            case 3 :
                resourceList.add("Material");
                resourceList.add(String.valueOf(resource.getMaterialCost()));
                return resourceList;


            default:
                return null;


        }


    }

}
