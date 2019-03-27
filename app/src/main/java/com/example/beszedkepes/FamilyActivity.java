package com.example.beszedkepes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FamilyActivity extends AppCompatActivity {

    private ImageView Myself_oldal, button_kamera, Image_View1;
    String kep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);


        init();

        Myself_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myself_activity= new Intent(FamilyActivity.this,Main2Activity.class);
                Bitmap bitmap = (Bitmap) myself_activity.getParcelableExtra("BitmapImage");
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
    }

    private void init() {
        Myself_oldal = (ImageView) findViewById(R.id.Myself_oldal);
        button_kamera = (ImageView) findViewById(R.id.button_kamera);
        Image_View1 = (ImageView) findViewById(R.id.Image_View1);
    }
}
