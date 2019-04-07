package com.example.beszedkepes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class ProblemsActivity extends AppCompatActivity {

    private ImageView IdNatha,IdTorokfaj, IdMegfaz, IdNyakfaj, IdHatfaj, IdSeb, IdFogfajas, IdVernyom,
            IdAlergia, IdGipsz, IdAjult, IdFertotlenit, IdEllenoriz, IdBeteg, Image_View11, Image_View22,
            Image_View33, Image_View44, Myself_oldal, Family_oldal, Harmadik_oldal, negyedik_oldal;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problems);

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

        String informacio_problem = sharedPreferences.getString("problem", "");
        Bitmap seged_bitmap_problem = decodeToBase64(informacio_problem);
        Image_View44.setImageBitmap(seged_bitmap_problem);

        Myself_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myself_activity= new Intent(ProblemsActivity.this,Main2Activity.class);
                startActivity(myself_activity);
                finish();
            }
        });

        Family_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent family_activity= new Intent(ProblemsActivity.this,FamilyActivity.class);
                startActivity(family_activity);
                finish();
            }
        });

        Harmadik_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent szandek_activity= new Intent(ProblemsActivity.this,IntentionActivity.class);
                startActivity(szandek_activity);
                finish();
            }
        });

    }

    private void init() {
        IdTorokfaj = findViewById(R.id.IdTorokfaj);
        IdNatha = findViewById(R.id.IdNatha);
        IdMegfaz = findViewById(R.id.IdMegfaz);
        IdNyakfaj =  findViewById(R.id.IdNyakfaj);
        IdHatfaj = findViewById(R.id.IdHatfaj);
        IdSeb = findViewById(R.id.IdSeb);
        IdFogfajas = findViewById(R.id.IdFogfajas);
        IdAlergia = findViewById(R.id.IdAlergia);
        IdGipsz = findViewById(R.id.IdGipsz);
        IdAjult = findViewById(R.id.IdAjult);
        IdFertotlenit = findViewById(R.id.IdFertotlenit);
        IdEllenoriz = findViewById(R.id.IdEllenoriz);
        IdBeteg = findViewById(R.id.IdBeteg);
        Image_View11 = findViewById(R.id.Image_View11);
        Image_View22 = findViewById(R.id.Image_View22);
        Image_View33 = findViewById(R.id.Image_View33);
        Image_View44 = findViewById(R.id.Image_View44);
        Myself_oldal = findViewById(R.id.Myself_oldal);
        Family_oldal = findViewById(R.id.Family_oldal);
        Harmadik_oldal = findViewById(R.id.Harmadik_oldal);
        negyedik_oldal = findViewById(R.id.negyedik_oldal);

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
