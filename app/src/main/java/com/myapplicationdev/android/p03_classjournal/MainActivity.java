package com.myapplicationdev.android.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ArrayList<Module> alModule;
    ModuleAdapter ca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = findViewById(R.id.lvModules);


        alModule = new ArrayList<>();
        final Module module1 = new Module("C302","Web Services");
        alModule.add(module1);
        Module module2 = new Module("C347", "Android Programming II");
        alModule.add(module2);


        ca = new ModuleAdapter(this, R.layout.activity_main, alModule);
        lvModule.setAdapter(ca);



        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, InfoForC347.class);
                Module currentModule = alModule.get(position);
                intent.putExtra("moduleCode",currentModule.getModuleCode());
                startActivity(intent);
            }
        });




    }
}
