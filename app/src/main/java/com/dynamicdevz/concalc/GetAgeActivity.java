package com.dynamicdevz.concalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GetAgeActivity extends AppCompatActivity {

    public static final String TAG = "TAG_X";
    private TextView personTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_age);

        personTV = findViewById(R.id.textView2);

        Intent rI = getIntent();
        Log.d(TAG, "onCreate: 2nd");
        if(rI != null){
            String name = rI.getStringExtra("name");
            int yob = rI.getIntExtra("yob", 2000);

            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.US);
            int dateYear = Integer.parseInt(dateFormat.format(date));

            Log.d(TAG, "Date year "+ dateYear);
            String fromActivity = name + " age is "+ (dateYear - yob);
            personTV.setText(fromActivity);

            Intent dataIntent = new Intent();
            dataIntent.putExtra("from", fromActivity.toUpperCase());
            setResult(RESULT_OK, dataIntent);

//            new Handler(getMainLooper()).postDelayed(new Runnable() {
//                @Override
//                public void run() {
                    Log.d(TAG, "closing");
                    finish();//Closes current activity
//                }
//            }, 3000);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: 2nd");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: 2nd");
    }
}