package com.bakandamiya.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ContactusActivity extends AppCompatActivity {

    ImageView contact_to_home;
    LinearLayout mFacebook, mLinkedin, mTwitter, mWhatsapp, mInstagram, mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        contact_to_home = findViewById(R.id.contacttohome);

        contact_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactusActivity.this,MainActivity.class));
            }
        });


        mFacebook = findViewById(R.id.facebook);
        mFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sAppLink ="fb://page/1175215572518217";
                String sPackage ="com.facebook.katana";
                String sWebLink ="https://www.facebook.com/bakandamiyaa";

                //call method

                openLink(sAppLink,sPackage,sWebLink);
            }
        });


        mLinkedin = findViewById(R.id.linkedin);
        mLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sPackage ="com.linkedin.android";
                String sWebLink ="https://www.linkedin.com/company/bakandamiya/mycompany/?viewAsMember=true";

                //call method
                openLink(sWebLink,sPackage,sWebLink);

            }
        });


        mTwitter = findViewById(R.id.twitter);
        mTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sAppLink ="twitter://user?screen_name=bakandamiya";
                String sPackage ="com.twitter.android";
                String sWebLink ="https://twitter.com/bakandamiya";

                //call method

                openLink(sAppLink,sPackage,sWebLink);

            }
        });


        mWhatsapp = findViewById(R.id.whatsapp);
        mWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNum = "+2349072304845";
                Uri uri = Uri.parse(String.format(
                        "https://api.whatsapp.com/send?phone=%s",phoneNum
                ));

                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(uri);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);

            }
        });


        mInstagram = findViewById(R.id.instagram);
        mInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String sAppLink ="https://www.instagram.com/bakandamiyaa/";
                String sPackage ="com.instagram.android";

                //call method

                openLink(sAppLink,sPackage,sAppLink);
            }
        });

    }

    private void openLink(String sAppLink, String sPackage, String sWebLink) {
        try {
            Uri uri =Uri.parse(sAppLink);

            Intent intent =new Intent(Intent.ACTION_VIEW);

            intent.setData(uri);

            intent.setPackage(sPackage);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);

        } catch (ActivityNotFoundException activityNotFoundException){

            Uri uri =Uri.parse(sWebLink);

            Intent intent =new Intent(Intent.ACTION_VIEW);

            intent.setData(uri);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
        }
    }
}