package com.myapplicationdev.android.p03_classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class AddDataForWeek extends AppCompatActivity {

    TextView tvWeek;
    Button btn_submit;
    String weekNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_for_week);

        tvWeek = findViewById(R.id.textViewWeek);
        btn_submit = findViewById(R.id.buttonSubmit);

        Intent i = getIntent();
        weekNumber = i.getStringExtra("WeekNo");
        tvWeek.setText("Week " + weekNumber);

        setTitle("Add data for Week");
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
                int selectedButtonId = rg.getCheckedRadioButtonId();

                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                Intent intent  = new Intent();
                intent.putExtra("weeknumber",weekNumber);
                intent.putExtra("rbText",rb.getText());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
