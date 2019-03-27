package com.example.beszedkepes;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ImageView Family_oldal, button_kamera, Image_View1,
            Image_10, Image_View2, Image_View3, Image_View4,
            Image_11, Image_12, Image_13, Image_20, Image_21, Image_22, Image_23, Image_30,
            Image_31, Image_32, Image_33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();


        Family_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent family_activity = new Intent(Main2Activity.this, FamilyActivity.class);
                startActivity(family_activity);
                finish();
            }
        });


        button_kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kamera_activity = new Intent(Main2Activity.this, CameraAcitvity.class);
                startActivity(kamera_activity);
                finish();
            }
        });

        Image_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Image_View1.setImageResource(R.mipmap.girl);
                Image_10.setImageResource(R.mipmap.backpain);
                Image_10.setEnabled(false);
            }
        });

        Image_View1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Image_10.setImageResource(R.mipmap.girl);
                Image_View1.setImageResource(0);
                Image_10.setEnabled(true);
            }
        });


    }
        private void init ()
        {
            Family_oldal = (ImageView) findViewById(R.id.Family_oldal);
            button_kamera = (ImageView) findViewById(R.id.button_kamera);
            Image_View1 = (ImageView) findViewById(R.id.Image_View1);
            Image_View2 = (ImageView) findViewById(R.id.Image_View2);
            Image_View3 = (ImageView) findViewById(R.id.Image_View3);
            Image_View4 = (ImageView) findViewById(R.id.Image_View4);
            Image_10 = (ImageView) findViewById(R.id.Image_10);
            Image_11 = (ImageView) findViewById(R.id.Image_11);
            Image_12 = (ImageView) findViewById(R.id.Image_12);
            Image_13 = (ImageView) findViewById(R.id.Image_13);
            Image_20 = (ImageView) findViewById(R.id.Image_20);
            Image_21 = (ImageView) findViewById(R.id.Image_21);
            Image_22 = (ImageView) findViewById(R.id.Image_22);
            Image_23 = (ImageView) findViewById(R.id.Image_23);
            Image_30 = (ImageView) findViewById(R.id.Image_30);
            Image_31 = (ImageView) findViewById(R.id.Image_31);
            Image_32 = (ImageView) findViewById(R.id.Image_32);
            Image_33 = (ImageView) findViewById(R.id.Image_33);
        }


}
