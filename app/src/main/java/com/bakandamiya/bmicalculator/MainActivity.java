package com.bakandamiya.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle toggle;
    public NavigationView navView;

    //private variables

    private EditText mHeight, mWeight, mAge;
    private ImageView mMale,mFemale;
    private TextView mBmi, txtbmi;
    private Button mbtnCalculate;
    private LinearLayout mUnderweightview, mNormalview, mOverweightview,mObeseview1,
            mObeseview2,mObeseview3;

    //string variables to calculate mbi

    private String height, weight, age, gender;
    private double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mHeight = findViewById(R.id.height);
        mWeight = findViewById(R.id.weight);
        mAge = findViewById(R.id.age);
        mMale = findViewById(R.id.male);
        mFemale = findViewById(R.id.female);
        mBmi = findViewById(R.id.bmi);
        txtbmi = findViewById(R.id.txtbmi);
        mbtnCalculate = findViewById(R.id.btncalculate);
        mUnderweightview = findViewById(R.id.underweightview);
        mNormalview = findViewById(R.id.normalview);
        mOverweightview = findViewById(R.id.overweightview);
        mObeseview1 = findViewById(R.id.obeseview1);
        mObeseview2 = findViewById(R.id.obeseview2);
        mObeseview3 = findViewById(R.id.obeseview3);


        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView toolbarTitle = toolbar.findViewById(R.id.toolbarTitle);
        setSupportActionBar(toolbar);
        toolbarTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        navView = findViewById(R.id.navView);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);


        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMale.setColorFilter(getResources().getColor(R.color.blue_light));
                mFemale.setColorFilter(getResources().getColor(R.color.white));
                gender = "Male";

            }
        });

        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mFemale.setColorFilter(getResources().getColor(R.color.pink));
                mMale.setColorFilter(getResources().getColor(R.color.white));
                gender = "Female";
            }
        });

        mbtnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                height =mHeight.getText().toString().trim();
                weight= mWeight.getText().toString().trim();
                age =mAge.getText().toString().trim();

                if(height.equals("0") || height.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Height must be greater than zero!",Toast.LENGTH_LONG).
                            show();

                }  else if (weight.equals("0") || weight.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Weight must be greater than zero!",Toast.LENGTH_LONG).
                            show();

                } else if (age.equals("0") || age.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Age must be greater than zero!", Toast.LENGTH_LONG).
                            show();
/*
                }     else if (gender.isEmpty()){
                        Toast.makeText(getApplicationContext(),"Gender must be selected!",Toast.LENGTH_LONG).
                                show();*/

                } else {


                    double height2 = Double.parseDouble (height);
                    double weight2 = Double.parseDouble (weight);
                    height2= height2/100;

                    /*formula to calculate the BMI:
                    '*100' inside the parenthesis and /'100' outside
                    the parenthesis will round to 2 decimal places
*/
                    bmi = Math.round(weight2/(height2*height2)*100)/100.0;

                    mBmi.setText(String.valueOf(bmi));

                    if (bmi > 40.0) {
                        mBmi.setText(String.valueOf(bmi));
                        mObeseview3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.obesebackg));
                        mObeseview2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mObeseview1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mNormalview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mUnderweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mOverweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mBmi.setTextColor(getResources().getColor(R.color.red));
                        txtbmi.setTextColor(getResources().getColor(R.color.red));


                    } else if (bmi>35.0 && bmi <39.0) {
                        mBmi.setText(String.valueOf(bmi));
                        mObeseview2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.obesebackg));
                        mObeseview3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mObeseview1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mNormalview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mUnderweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mOverweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mBmi.setTextColor(getResources().getColor(R.color.red));
                        txtbmi.setTextColor(getResources().getColor(R.color.red));

                    } else if (bmi>30.0 && bmi <34.9) {
                        mBmi.setText(String.valueOf(bmi));
                        mObeseview1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.obesebackg));
                        mObeseview2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mObeseview3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mNormalview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mUnderweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mOverweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mBmi.setTextColor(getResources().getColor(R.color.red));
                        txtbmi.setTextColor(getResources().getColor(R.color.red));

                    } else if (bmi>25.0 && bmi <29.9) {
                        mBmi.setText(String.valueOf(bmi));
                        mObeseview2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mObeseview3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mObeseview1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mNormalview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mUnderweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mOverweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.overweightbackg));
                        mBmi.setTextColor(getResources().getColor(R.color.yellow));
                        txtbmi.setTextColor(getResources().getColor(R.color.yellow));

                    } else if (bmi>18.5 && bmi <24.9) {
                        mBmi.setText(String.valueOf(bmi));
                        mObeseview2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mObeseview3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mObeseview1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mNormalview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.normalbackg));
                        mUnderweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mOverweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mBmi.setTextColor(getResources().getColor(R.color.green));
                        txtbmi.setTextColor(getResources().getColor(R.color.green));

                    } else{
                        mBmi.setText(String.valueOf(bmi));
                        mObeseview2.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mObeseview3.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mObeseview1.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mNormalview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mUnderweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.underweighbackg));
                        mOverweightview.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nobackgroundcolor));
                        mBmi.setTextColor(getResources().getColor(R.color.brown));
                        txtbmi.setTextColor(getResources().getColor(R.color.brown));
                    }

                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {

            case R.id.idAboutus:
                startActivity(new Intent(this, AboutusActivity.class));
                break;


            case R.id.idContactus:
                startActivity(new Intent(this, ContactusActivity.class));
                break;


            case R.id.idPrivacy:
                startActivity(new Intent(this, PrivacyActivity.class));
                break;

        }
        return false;

    }

    //this method is implemented with setNavigationItemListener
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
