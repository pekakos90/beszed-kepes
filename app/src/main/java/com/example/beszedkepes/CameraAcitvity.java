package com.example.beszedkepes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CameraAcitvity extends AppCompatActivity {


    private ImageView Button_Kamera, Image_View, Myself_oldal, Family_oldal;
    private int CAMERA_REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        init();

        Button_Kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kamera_start = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(kamera_start,CAMERA_REQUEST_CODE);
            }
        });

        Myself_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myself_activity= new Intent(CameraAcitvity.this,Main2Activity.class);
                startActivity(myself_activity);
                finish();
            }
        });

        Family_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent family_activity= new Intent(CameraAcitvity.this,FamilyActivity.class);
                startActivity(family_activity);
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK)
        {
            Bitmap picture = (Bitmap)data.getExtras().get("data");
            Image_View.setImageBitmap(picture);
        }
    }

    private void init() {
        Button_Kamera = (ImageView) findViewById(R.id.Button_Kamera);
        Image_View = (ImageView) findViewById(R.id.Image_View);
        Myself_oldal = (ImageView) findViewById(R.id.Myself_oldal);
        Family_oldal = (ImageView) findViewById(R.id.Family_oldal);
    }
}
