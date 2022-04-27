package com.bakandamiya.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AboutusActivity extends AppCompatActivity {

    ImageView about_to_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        about_to_home = findViewById(R.id.abouttohome);

        about_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutusActivity.this,MainActivity.class));
            }
        });
    }
}