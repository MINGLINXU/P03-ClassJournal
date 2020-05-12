package com.myapplicationdev.android.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoForC347 extends AppCompatActivity {

    int requestCodeForC302 = 1;
    int requestCodeForC347 = 2;

    ListView lv;
    ArrayAdapter aa;
    ArrayList<DG> DailyGrades1, DailyGrades2;
    Button btnInfo, btnAdd, btnEmail;
    String weekNo, emailContent, moduleCode;
    int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_for_c347);

        lv = this.findViewById(R.id.lvInfo);
        btnInfo = this.findViewById(R.id.buttonInfo);
        btnAdd = this.findViewById(R.id.buttonAdd);
        btnEmail = this.findViewById(R.id.buttonEmail);
        DailyGrades1 = new ArrayList<DG>();
        DailyGrades2 = new ArrayList<DG>();

        DailyGrades2.add(new DG("1","B"));
        DailyGrades2.add(new DG("2","C"));
        DailyGrades2.add(new DG("3","A"));




        Intent i = getIntent();
        moduleCode = i.getStringExtra("moduleCode");
        setTitle("Info for " + moduleCode);

        if(moduleCode.equals("C302")){
            aa = new CustomAdapter(this, R.layout.activity_info_for_c347, DailyGrades1);
            lv.setAdapter(aa);
        }
        else if(moduleCode.equals("C347")){
            aa = new CustomAdapter(this, R.layout.activity_info_for_c347, DailyGrades2);
            lv.setAdapter(aa);
        }

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);

                if(moduleCode.equals("C302")){
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C302"));
                }
                else if(moduleCode.equals("C347")){
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                }


                startActivity(rpIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoForC347.this, AddDataForWeek.class);
                if(moduleCode.equals("C302")){
                    number = DailyGrades1.size()+1;
                    weekNo = Integer.toString(number);
                    i.putExtra("WeekNo",weekNo);
                    startActivityForResult(i, requestCodeForC302);
                }
                else if(moduleCode.equals("C347")){
                    number = DailyGrades2.size()+1;
                    weekNo = Integer.toString(number);
                    i.putExtra("WeekNo",weekNo);
                    startActivityForResult(i, requestCodeForC347);
                }


            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent email = new Intent(Intent.ACTION_SEND);

                if(moduleCode.equals("C302")){
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"hew_ka_kian@rp.edu.sg"});
                    email.putExtra(Intent.EXTRA_SUBJECT, "Test Email from C302");
                    emailContent = "";
                    for(int i = 0; i<DailyGrades1.size(); i++){
                        emailContent += "Week " + DailyGrades1.get(i).getWeek() + ": DG: " + DailyGrades1.get(i).getDailyGrade() + "\n";

                    }
                }
                else if(moduleCode.equals("C347")){
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                    email.putExtra(Intent.EXTRA_SUBJECT, "Test Email from C347");
                    emailContent = "";
                    for(int i = 0; i<DailyGrades2.size(); i++){
                        emailContent += "Week " + DailyGrades2.get(i).getWeek() + ": DG: " + DailyGrades2.get(i).getDailyGrade() + "\n";

                    }
                }

                email.putExtra(Intent.EXTRA_TEXT, "Hi faci, \n\n I am Minglin here, \n Please" +
                        "see my remarks so far, thank you!\n\n" + emailContent);

                //This MIME type indicates email
                email.setType("message/rfc822");

                //createChooser shows user a list of app that can handle
                //this MIME type, which is, email
                startActivity(Intent.createChooser(email, "Choose an Email client: "));
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Only handle when 2nd activity closed normally
        //and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {
                String weekNumber = data.getStringExtra("weeknumber");
                String grade = data.getStringExtra("rbText");
                if(requestCode == requestCodeForC302){
                    DailyGrades1.add(new DG(weekNumber,grade));
                    aa = new CustomAdapter(this, R.layout.activity_info_for_c347, DailyGrades1);
                    lv.setAdapter(aa);
                }
                else if(requestCode == requestCodeForC347){
                    DailyGrades2.add(new DG(weekNumber,grade));
                    aa = new CustomAdapter(this, R.layout.activity_info_for_c347, DailyGrades2);
                    lv.setAdapter(aa);
                }
            }
        }
    }

}
