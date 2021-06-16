package com.dynamicdevz.concalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GetAgeActivity extends AppCompatActivity {


    private TextView personTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_age);

        personTV = findViewById(R.id.textView2);

        Intent rI = getIntent();
        if(rI != null){
            String name = rI.getStringExtra("name");
            int yob = rI.getIntExtra("yob", 2000);
            personTV.setText(name + " age is "+ (2021 - yob));
        }

    }
}