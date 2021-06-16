package com.dynamicdevz.concalc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText yearOBEditText;

    //Intents: How android performs it's actions
    //Implicit Intent
    //Explicit Intent
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alt_home_activity);

        nameEditText = findViewById(R.id.firstname_edittext);
        yearOBEditText = findViewById(R.id.yob_edittext);

        findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intents
                //Explicit intent
                Intent getAgeIntent = new Intent(MainActivity.this, GetAgeActivity.class);

                getAgeIntent.putExtra("yob", Integer.parseInt(yearOBEditText.getText().toString()));
                getAgeIntent.putExtra("name", nameEditText.getText().toString().trim());


            }
        });

    }
}











