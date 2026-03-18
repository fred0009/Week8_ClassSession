package com.example.week8_classsession;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private final String sharedPrefFile = "com.example.android.myapplication" ;
    public static final String KEY = "MyKey" ;
    SharedPreferences mPreferences;

    TextView tv_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv_first = findViewById(R.id.first_text);

        // Loading data from intent
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");

        // Loading data from shared preferences
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        String txt = mPreferences.getString(KEY, "Default Value");

        if (data != null)
            tv_first.setText(data);
        else
            tv_first.setText(txt);


        Button buttonOne = findViewById(R.id.btn_one);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);

                Log.i("Class Demo", "button is clicked");
            }
        });

        Button buttonMap = findViewById(R.id.btn_map);
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = "SUTD";
                Uri.Builder builder = new Uri.Builder();
                builder.scheme("geo").opaquePart("0.0").appendQueryParameter("q", location);
                Uri geoLocation = builder.build();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });
    }

    // Saving data at onDestroy life cycle is not reliable
    // Recommended to save data at onPause or onStop
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Class Demo", "onStop");

        // The following is to store data in app local storage
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString(KEY, tv_first.getText().toString());
        preferencesEditor.apply();
    }
}