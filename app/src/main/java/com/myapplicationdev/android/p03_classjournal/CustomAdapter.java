package com.myapplicationdev.android.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    private ArrayList<DG> DG;
    private Context context;
    private int layout_id;
    private TextView tvDG, tvWeek, tvText;
    private ImageView imClass;

    public CustomAdapter(Context context, int resource, ArrayList<DG> objects){
        super(context, resource, objects);

        DG = objects;
        layout_id = resource;
        this.context = context;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //The usual way to get the LayoutInflater object to
        //"inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //"Inflate" the row.xml as the layout for the view object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        //Get the TextView object
        tvDG = (TextView) rowView.findViewById(R.id.textViewGrade);
        tvWeek = (TextView) rowView.findViewById(R.id.textViewWeek);
        tvText =(TextView) rowView.findViewById(R.id.textViewDG);
        imClass = (ImageView) rowView.findViewById(R.id.imageView);







        DG currentInput = DG.get(position);



        tvDG.setText(currentInput.getDailyGrade());
        tvWeek.setText("Week " + currentInput.getWeek());
        tvText.setText("DG");
        imClass.setImageResource(R.drawable.dg);

        return rowView;
    }
}
