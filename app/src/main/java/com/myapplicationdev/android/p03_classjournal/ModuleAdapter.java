package com.myapplicationdev.android.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter {
    private ArrayList<Module> modules;
    private Context context;
    private  int layout_id;
    private TextView tvModuleCode, tvModuleName;


    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);

        modules = objects;
        layout_id = resource;
        this.context = context;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //The usual way to get the LayoutInflater object to
        //"inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //"Inflate" the row.xml as the layout for the view object
        View rowView = inflater.inflate(R.layout.row2, parent, false);

        //Get the TextView object
        tvModuleCode = (TextView) rowView.findViewById(R.id.textViewModuleCode);
        tvModuleName = (TextView) rowView.findViewById(R.id.textViewModuleName);


        Module currentInput = modules.get(position);


        tvModuleCode.setText(currentInput.getModuleCode());
        tvModuleName.setText(currentInput.getModuleName());


        return rowView;
    }
}
