package com.bakandamiya.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PrivacyActivity extends AppCompatActivity {

    ImageView privacy_to_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        privacy_to_home = findViewById(R.id.privacytohome);

        privacy_to_home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrivacyActivity.this,MainActivity.class));
            }
        });
    }
}