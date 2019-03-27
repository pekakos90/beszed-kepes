package com.example.beszedkepes;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
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
            Image01, Image_View2, Image_View3, Image_View4,
            Image02, Image03, Image04, Image05, Image06, Image07, Image08, Image09,
            Image010, Image011, Image012;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();



        Family_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Image_View1.buildDrawingCache();
                Bitmap bitmap = Image_View1.getDrawingCache();
                Intent family_activity = new Intent(Main2Activity.this, FamilyActivity.class);
                family_activity.putExtra("BitmapImage", bitmap);
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

        Image01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Image_View1.setImageResource(R.mipmap.girl);
                if(Image_View1 == Image01) {
                    Image01.setImageResource(R.mipmap.backpain);
                }
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
            Image01 = (ImageView) findViewById(R.id.Image01);
            Image02 = (ImageView) findViewById(R.id.Image02);
            Image03 = (ImageView) findViewById(R.id.Image03);
            Image04 = (ImageView) findViewById(R.id.Image04);
            Image05 = (ImageView) findViewById(R.id.Image05);
            Image06 = (ImageView) findViewById(R.id.Image06);
            Image07 = (ImageView) findViewById(R.id.Image07);
            Image08 = (ImageView) findViewById(R.id.Image08);
            Image09 = (ImageView) findViewById(R.id.Image09);
            Image010 = (ImageView) findViewById(R.id.Image010);
            Image011 = (ImageView) findViewById(R.id.Image011);
            Image012 = (ImageView) findViewById(R.id.Image012);
        }
    }
