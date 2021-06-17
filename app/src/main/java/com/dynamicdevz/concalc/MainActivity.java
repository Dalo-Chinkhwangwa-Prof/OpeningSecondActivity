package com.dynamicdevz.concalc;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText yearOBEditText;
    public static final String TAG = "TAG_X";
    private final int REQUEST_CODE = 797;


    private SharedPreferences sharedPreferences;
    private TextView tv;
    //Intents: How android performs it's actions
    //Implicit Intent
    //Explicit Intent
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alt_home_activity);
        tv = findViewById(R.id.my_text);
        sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String value = sharedPreferences.getString("KEY", null);
        if(value != null){
            tv.setVisibility(View.VISIBLE);
            tv.setText(value);
        }


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
                startActivityForResult(getAgeIntent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: ");
        if(requestCode == REQUEST_CODE){
            String dataString = data.getStringExtra("from");
            Toast.makeText(this, dataString, Toast.LENGTH_LONG).show();

            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("KEY", dataString);
            edit.apply();
            //class Human(String name, int age)
        }
    }
}











