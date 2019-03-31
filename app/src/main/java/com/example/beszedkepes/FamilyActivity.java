package com.example.beszedkepes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class FamilyActivity extends AppCompatActivity {

    private ImageView Myself_oldal, button_kamera, Image_View1, Image_View2, Image_View22, ImageEn, ImageViewGrandPa, Harmadik_oldal;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);


        init();

        String informacio = sharedPreferences.getString("myself","");                                         //Lekérjük a name adatott amibe beletettünk egy stringet a Mentes_Activity-nél és beletesszük egy stringbe
        Bitmap seged_bitmap = decodeToBase64(informacio);
        Image_View1.setImageBitmap(seged_bitmap);

        Myself_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myself_activity= new Intent(FamilyActivity.this,Main2Activity.class);
                startActivity(myself_activity);
                finish();
            }
        });

        button_kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kamera_activity= new Intent(FamilyActivity.this,CameraAcitvity.class);
                startActivity(kamera_activity);
                finish();
            }
        });

        Harmadik_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent szandek_activity= new Intent(FamilyActivity.this,IntentionActivity.class);
                startActivity(szandek_activity);
                finish();
            }
        });

        ImageEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Image_View22.setImageResource(R.mipmap.en);
                ImageEn.setImageResource(R.mipmap.backpain);
                ImageEn.setEnabled(false);

                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("family", encodeToBase64(((BitmapDrawable)Image_View1.getDrawable()).getBitmap()));
                editor.commit();
            }
        });

        Image_View22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageEn.setImageResource(R.mipmap.en);
                ImageEn.setEnabled(true);

                Image_View22.setImageResource(0);
            }
        });
    }

    private void init() {
        Myself_oldal = (ImageView) findViewById(R.id.Myself_oldal);
        button_kamera = findViewById(R.id.button_kamera);
        Image_View1 = findViewById(R.id.Image_View11);
        ImageViewGrandPa = findViewById(R.id.ImageViewGrandPa);
        ImageEn = findViewById(R.id.ImageEn);
        Image_View22 = findViewById(R.id.Image_View22);
        Harmadik_oldal = findViewById(R.id.Harmadik_oldal);

        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
    }

    public static Bitmap decodeToBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
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
}
