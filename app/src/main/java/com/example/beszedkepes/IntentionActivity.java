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
import android.widget.TableLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class IntentionActivity extends AppCompatActivity {

    private ImageView Myself_oldal, Family_oldal, Image_View11, Image_View22, Image_View33,
            Image_View44, IdGetup, IdBreakfast, IdDressing, IdHug, IdHideSeek, IdCleaning, IdDancing,
    IdDieta, IdMusic;
    private TableLayout tableLayout1;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intention);

        init();

        String informacio = sharedPreferences.getString("myself","");                                         //Lekérjük a name adatott amibe beletettünk egy stringet a Mentes_Activity-nél és beletesszük egy stringbe
        Bitmap seged_bitmap = decodeToBase64(informacio);
        Image_View11.setImageBitmap(seged_bitmap);

        String informacio_family = sharedPreferences.getString("family", "");
        Bitmap seged_bitmap_family = decodeToBase64(informacio_family);
        Image_View22.setImageBitmap(seged_bitmap_family);

        String informacio_intention = sharedPreferences.getString("intention", "");
        Bitmap seged_bitmap_intention = decodeToBase64(informacio_intention);
        Image_View33.setImageBitmap(seged_bitmap_intention);

        Myself_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myself_activity= new Intent(IntentionActivity.this,Main2Activity.class);
                startActivity(myself_activity);
                finish();
            }
        });

        Family_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent family_activity = new Intent(IntentionActivity.this, FamilyActivity.class);
                startActivity(family_activity);
                finish();
            }
        });

        IdHug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.hugging);
                    IdHug.setImageResource(R.mipmap.backpain);
                    IdHug.setEnabled(false);
                    IdDressing.setImageResource(R.mipmap.dressingup);
                    IdDressing.setEnabled(true);
                    IdBreakfast.setImageResource(R.mipmap.breakfast);
                    IdBreakfast.setEnabled(true);
                    IdMusic.setImageResource(R.mipmap.music);
                    IdMusic.setEnabled(true);
                    IdDancing.setImageResource(R.mipmap.dancing);
                    IdDancing.setEnabled(true);
                    IdDieta.setImageResource(R.mipmap.dieta);
                    IdDieta.setEnabled(true);
                    IdHideSeek.setImageResource(R.mipmap.amagatall);
                    IdHideSeek.setEnabled(false);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.commit();
            }
        });

        Image_View33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdHug.setImageResource(R.mipmap.hugging);
                IdHug.setEnabled(true);
                IdDressing.setImageResource(R.mipmap.dressingup);
                IdDressing.setEnabled(true);
                IdBreakfast.setImageResource(R.mipmap.breakfast);
                IdBreakfast.setEnabled(true);
                IdMusic.setImageResource(R.mipmap.music);
                IdMusic.setEnabled(true);
                IdDancing.setImageResource(R.mipmap.dancing);
                IdDancing.setEnabled(true);
                IdDieta.setImageResource(R.mipmap.dieta);
                IdDieta.setEnabled(true);
                IdHideSeek.setImageResource(R.mipmap.amagatall);
                IdHideSeek.setEnabled(false);
                IdCleaning.setImageResource(R.mipmap.cleaning);
                IdCleaning.setEnabled(true);
                IdGetup.setImageResource(R.mipmap.getup);
                IdGetup.setEnabled(true);
                Image_View33.setImageResource(0);
            }
        });

    }

    private void init() {
        Myself_oldal = (ImageView) findViewById(R.id.Myself_oldal);
        Image_View11 = findViewById(R.id.Image_View11);
        Image_View22 = findViewById(R.id.Image_View22);
        Image_View33 = findViewById(R.id.Image_View33);
        Family_oldal = findViewById(R.id.Family_oldal);
        IdGetup = findViewById(R.id.IdGetup);
        IdBreakfast = findViewById(R.id.IdBreakfast);
        IdCleaning = findViewById(R.id.IdCleaning);
        IdDieta = findViewById(R.id.IdDieta);
        IdDancing = findViewById(R.id.IdDancing);
        IdDressing = findViewById(R.id.IdDressing);
        IdHug = findViewById(R.id.IdHug);
        IdHideSeek = findViewById(R.id.IdHideSeek);
        IdMusic = findViewById(R.id.IdMusic);
        tableLayout1 = (TableLayout) findViewById(R.id.tableLayout1);

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
