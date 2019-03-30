package com.example.beszedkepes;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ImageView Family_oldal, button_kamera, Image_View1,
            Image_10, Image_View2, Image_View3, Image_View4,
            Image_11, Image_12, Image_13, Image_20, Image_21, Image_22, Image_23, Image_30,
            Image_31, Image_32, Image_33;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        String informacio = sharedPreferences.getString("myself","");
        Bitmap seged_bitmap = decodeToBase64(informacio);
        Image_View1.setImageBitmap(seged_bitmap);

        String informacio_family = sharedPreferences.getString("family", "");
        Bitmap seged_bitmap_family = decodeToBase64(informacio_family);
        Image_View2.setImageBitmap(seged_bitmap_family);

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

                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("myself", encodeToBase64(((BitmapDrawable)Image_View1.getDrawable()).getBitmap()));
                editor.commit();
            }
        });

        Image_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Image_View1.setImageResource(R.mipmap.sad);
                Image_11.setImageResource(R.mipmap.backpain);
                Image_11.setEnabled(false);

                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("myself", encodeToBase64(((BitmapDrawable)Image_View1.getDrawable()).getBitmap()));
                editor.commit();
            }
        });

        Image_View1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Image_10.setImageResource(R.mipmap.girl);
                Image_10.setEnabled(true);

                Image_11.setImageResource(R.mipmap.sad);
                Image_11.setEnabled(true);



                Image_View1.setImageResource(0);
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

            sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        }


    public static String encodeToBase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        Log.d("Image Log:", imageEncoded);
        return imageEncoded;
    }

    public static Bitmap decodeToBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
