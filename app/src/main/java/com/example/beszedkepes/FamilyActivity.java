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

    private ImageView Myself_oldal, button_kamera, Image_View11,
            Image_View33, Image_View22, Image_View44, ImageEn, ImageGrandPa,ImageOlderbro,ImageOldersis,
            ImageGrandma,ImageYoungerbro, ImageYoungersis, ImageAnya, Harmadik_oldal, negyedik_oldal, otodik_oldal;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);


        init();

        setKivalasztottKep();

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

        String informacio_relations = sharedPreferences.getString("relation", "");
        Bitmap seged_bitmap_relations = decodeToBase64(informacio_relations);
        Image_View44.setImageBitmap(seged_bitmap_relations);

        Myself_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View22.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.remove("family");
                    editor.apply();
                    Intent myself_activity= new Intent(FamilyActivity.this,Main2Activity.class);
                    startActivity(myself_activity);
                    finish();
                } else {
                    Intent myself_activity= new Intent(FamilyActivity.this,Main2Activity.class);
                    startActivity(myself_activity);
                    finish();
                }
            }
        });

        button_kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View22.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.remove("family");
                    editor.apply();
                    Intent kamera_activity= new Intent(FamilyActivity.this,CameraAcitvity.class);
                    startActivity(kamera_activity);
                    finish();
                } else {
                    Intent kamera_activity= new Intent(FamilyActivity.this,CameraAcitvity.class);
                    startActivity(kamera_activity);
                    finish();
                }
            }
        });

        Harmadik_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View22.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.remove("family");
                    editor.apply();
                    Intent szandek_activity= new Intent(FamilyActivity.this,IntentionActivity.class);
                    startActivity(szandek_activity);
                    finish();
                } else {
                    Intent szandek_activity= new Intent(FamilyActivity.this,IntentionActivity.class);
                    startActivity(szandek_activity);
                    finish();
                }
            }
        });

        negyedik_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View22.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.remove("family");
                    editor.apply();
                    Intent problem_activity= new Intent(FamilyActivity.this,ProblemsActivity.class);
                    startActivity(problem_activity);
                    finish();
                } else {
                    Intent problem_activity= new Intent(FamilyActivity.this,ProblemsActivity.class);
                    startActivity(problem_activity);
                    finish();
                }
            }
        });

        otodik_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View22.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.remove("family");
                    editor.apply();
                    Intent relation_activity= new Intent(FamilyActivity.this, RelationsActivity.class);
                    startActivity(relation_activity);
                    finish();
                } else {
                    Intent relation_activity= new Intent(FamilyActivity.this,RelationsActivity.class);
                    startActivity(relation_activity);
                    finish();
                }
            }
        });

        ImageEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View22.equals("")){
                    Image_View22.setImageResource(R.mipmap.en);
                    ImageEn.setImageResource(R.mipmap.psbuttonx);
                    ImageEn.setEnabled(false);
                    ImageGrandPa.setImageResource(R.mipmap.grandpa);
                    ImageGrandPa.setEnabled(true);
                    ImageGrandma.setImageResource(R.mipmap.grandma);
                    ImageGrandma.setEnabled(true);
                    ImageOlderbro.setImageResource(R.mipmap.olderbrother);
                    ImageOlderbro.setEnabled(true);
                    ImageOldersis.setImageResource(R.mipmap.oldersister);
                    ImageOldersis.setEnabled(true);
                    ImageYoungerbro.setImageResource(R.mipmap.youngerbrother);
                    ImageYoungerbro.setEnabled(true);
                    ImageYoungersis.setImageResource(R.mipmap.youngersister);
                    ImageYoungersis.setEnabled(true);
                    ImageAnya.setImageResource(R.mipmap.anya);
                    ImageAnya.setEnabled(true);
                }
                editSharedPreferencesKivalasztottKep(1);
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("family", encodeToBase64(((BitmapDrawable)Image_View22.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        ImageGrandPa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View22.equals("")){
                    Image_View22.setImageResource(R.mipmap.grandpa);
                    ImageEn.setImageResource(R.mipmap.en);
                    ImageEn.setEnabled(true);
                    ImageGrandPa.setImageResource(R.mipmap.psbuttonx);
                    ImageGrandPa.setEnabled(false);
                    ImageGrandma.setImageResource(R.mipmap.grandma);
                    ImageGrandma.setEnabled(true);
                    ImageOlderbro.setImageResource(R.mipmap.olderbrother);
                    ImageOlderbro.setEnabled(true);
                    ImageOldersis.setImageResource(R.mipmap.oldersister);
                    ImageOldersis.setEnabled(true);
                    ImageYoungerbro.setImageResource(R.mipmap.youngerbrother);
                    ImageYoungerbro.setEnabled(true);
                    ImageYoungersis.setImageResource(R.mipmap.youngersister);
                    ImageYoungersis.setEnabled(true);
                    ImageAnya.setImageResource(R.mipmap.anya);
                    ImageAnya.setEnabled(true);
                }
                editSharedPreferencesKivalasztottKep(2);
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("family", encodeToBase64(((BitmapDrawable)Image_View22.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        ImageGrandma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View22.equals("")){
                    Image_View22.setImageResource(R.mipmap.grandma);
                    ImageEn.setImageResource(R.mipmap.en);
                    ImageEn.setEnabled(true);
                    ImageGrandPa.setImageResource(R.mipmap.grandpa);
                    ImageGrandPa.setEnabled(true);
                    ImageGrandma.setImageResource(R.mipmap.psbuttonx);
                    ImageGrandma.setEnabled(false);
                    ImageOlderbro.setImageResource(R.mipmap.olderbrother);
                    ImageOlderbro.setEnabled(true);
                    ImageOldersis.setImageResource(R.mipmap.oldersister);
                    ImageOldersis.setEnabled(true);
                    ImageYoungerbro.setImageResource(R.mipmap.youngerbrother);
                    ImageYoungerbro.setEnabled(true);
                    ImageYoungersis.setImageResource(R.mipmap.youngersister);
                    ImageYoungersis.setEnabled(true);
                    ImageAnya.setImageResource(R.mipmap.anya);
                    ImageAnya.setEnabled(true);
                }
                editSharedPreferencesKivalasztottKep(3);
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("family", encodeToBase64(((BitmapDrawable)Image_View22.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        ImageOlderbro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View22.equals("")){
                    Image_View22.setImageResource(R.mipmap.olderbrother);
                    ImageEn.setImageResource(R.mipmap.en);
                    ImageEn.setEnabled(true);
                    ImageGrandPa.setImageResource(R.mipmap.grandpa);
                    ImageGrandPa.setEnabled(true);
                    ImageGrandma.setImageResource(R.mipmap.grandma);
                    ImageGrandma.setEnabled(true);
                    ImageOlderbro.setImageResource(R.mipmap.psbuttonx);
                    ImageOlderbro.setEnabled(false);
                    ImageOldersis.setImageResource(R.mipmap.oldersister);
                    ImageOldersis.setEnabled(true);
                    ImageYoungerbro.setImageResource(R.mipmap.youngerbrother);
                    ImageYoungerbro.setEnabled(true);
                    ImageYoungersis.setImageResource(R.mipmap.youngersister);
                    ImageYoungersis.setEnabled(true);
                    ImageAnya.setImageResource(R.mipmap.anya);
                    ImageAnya.setEnabled(true);
                }
                editSharedPreferencesKivalasztottKep(4);
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("family", encodeToBase64(((BitmapDrawable)Image_View22.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        ImageOldersis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View22.equals("")){
                    Image_View22.setImageResource(R.mipmap.oldersister);
                    ImageEn.setImageResource(R.mipmap.en);
                    ImageEn.setEnabled(true);
                    ImageGrandPa.setImageResource(R.mipmap.grandpa);
                    ImageGrandPa.setEnabled(true);
                    ImageGrandma.setImageResource(R.mipmap.grandma);
                    ImageGrandma.setEnabled(true);
                    ImageOlderbro.setImageResource(R.mipmap.olderbrother);
                    ImageOlderbro.setEnabled(true);
                    ImageOldersis.setImageResource(R.mipmap.psbuttonx);
                    ImageOldersis.setEnabled(false);
                    ImageYoungerbro.setImageResource(R.mipmap.youngerbrother);
                    ImageYoungerbro.setEnabled(true);
                    ImageYoungersis.setImageResource(R.mipmap.youngersister);
                    ImageYoungersis.setEnabled(true);
                    ImageAnya.setImageResource(R.mipmap.anya);
                    ImageAnya.setEnabled(true);
                }
                editSharedPreferencesKivalasztottKep(5);
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("family", encodeToBase64(((BitmapDrawable)Image_View22.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        ImageYoungerbro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View22.equals("")){
                    Image_View22.setImageResource(R.mipmap.youngerbrother);
                    ImageEn.setImageResource(R.mipmap.en);
                    ImageEn.setEnabled(true);
                    ImageGrandPa.setImageResource(R.mipmap.grandpa);
                    ImageGrandPa.setEnabled(true);
                    ImageGrandma.setImageResource(R.mipmap.grandma);
                    ImageGrandma.setEnabled(true);
                    ImageOlderbro.setImageResource(R.mipmap.olderbrother);
                    ImageOlderbro.setEnabled(true);
                    ImageOldersis.setImageResource(R.mipmap.oldersister);
                    ImageOldersis.setEnabled(true);
                    ImageYoungerbro.setImageResource(R.mipmap.psbuttonx);
                    ImageYoungerbro.setEnabled(false);
                    ImageYoungersis.setImageResource(R.mipmap.youngersister);
                    ImageYoungersis.setEnabled(true);
                    ImageAnya.setImageResource(R.mipmap.anya);
                    ImageAnya.setEnabled(true);
                }
                editSharedPreferencesKivalasztottKep(6);
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("family", encodeToBase64(((BitmapDrawable)Image_View22.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        ImageYoungersis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View22.equals("")){
                    Image_View22.setImageResource(R.mipmap.youngersister);
                    ImageEn.setImageResource(R.mipmap.en);
                    ImageEn.setEnabled(true);
                    ImageGrandPa.setImageResource(R.mipmap.grandpa);
                    ImageGrandPa.setEnabled(true);
                    ImageGrandma.setImageResource(R.mipmap.grandma);
                    ImageGrandma.setEnabled(true);
                    ImageOlderbro.setImageResource(R.mipmap.olderbrother);
                    ImageOlderbro.setEnabled(true);
                    ImageOldersis.setImageResource(R.mipmap.oldersister);
                    ImageOldersis.setEnabled(true);
                    ImageYoungerbro.setImageResource(R.mipmap.youngerbrother);
                    ImageYoungerbro.setEnabled(true);
                    ImageYoungersis.setImageResource(R.mipmap.psbuttonx);
                    ImageYoungersis.setEnabled(false);
                    ImageAnya.setImageResource(R.mipmap.anya);
                    ImageAnya.setEnabled(true);
                }
                editSharedPreferencesKivalasztottKep(7);
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("family", encodeToBase64(((BitmapDrawable)Image_View22.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        ImageAnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View22.equals("")){
                    Image_View22.setImageResource(R.mipmap.anya);
                    ImageEn.setImageResource(R.mipmap.en);
                    ImageEn.setEnabled(true);
                    ImageGrandPa.setImageResource(R.mipmap.grandpa);
                    ImageGrandPa.setEnabled(true);
                    ImageGrandma.setImageResource(R.mipmap.grandma);
                    ImageGrandma.setEnabled(true);
                    ImageOlderbro.setImageResource(R.mipmap.olderbrother);
                    ImageOlderbro.setEnabled(true);
                    ImageOldersis.setImageResource(R.mipmap.oldersister);
                    ImageOldersis.setEnabled(true);
                    ImageYoungerbro.setImageResource(R.mipmap.youngerbrother);
                    ImageYoungerbro.setEnabled(true);
                    ImageYoungersis.setImageResource(R.mipmap.youngersister);
                    ImageYoungersis.setEnabled(true);
                    ImageAnya.setImageResource(R.mipmap.psbuttonx);
                    ImageAnya.setEnabled(false);
                }
                editSharedPreferencesKivalasztottKep(8);
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("family", encodeToBase64(((BitmapDrawable)Image_View22.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        Image_View22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageEn.setImageResource(R.mipmap.en);
                ImageEn.setEnabled(true);
                ImageGrandPa.setImageResource(R.mipmap.grandpa);
                ImageGrandPa.setEnabled(true);
                ImageGrandma.setImageResource(R.mipmap.grandma);
                ImageGrandma.setEnabled(true);
                ImageOlderbro.setImageResource(R.mipmap.olderbrother);
                ImageOlderbro.setEnabled(true);
                ImageOldersis.setImageResource(R.mipmap.oldersister);
                ImageOldersis.setEnabled(true);
                ImageYoungerbro.setImageResource(R.mipmap.youngerbrother);
                ImageYoungerbro.setEnabled(true);
                ImageYoungersis.setImageResource(R.mipmap.youngersister);
                ImageYoungersis.setEnabled(true);
                ImageAnya.setImageResource(R.mipmap.anya);
                ImageAnya.setEnabled(true);
                editSharedPreferencesKivalasztottKep(0);
                Image_View22.setImageResource(0);
            }
        });
    }

    private void init() {
        Myself_oldal = (ImageView) findViewById(R.id.Myself_oldal);
        button_kamera = findViewById(R.id.button_kamera);
        Image_View11 = findViewById(R.id.Image_View11);
        ImageGrandPa = findViewById(R.id.ImageGrandPa);
        ImageGrandma = findViewById(R.id.ImageGrandma);
        ImageOlderbro = findViewById(R.id.ImageOlderbro);
        ImageOldersis = findViewById(R.id.ImageOldersis);
        ImageYoungerbro = findViewById(R.id.ImageYoungerbro);
        ImageYoungersis = findViewById(R.id.ImageYoungersis);
        ImageEn = findViewById(R.id.ImageEn);
        ImageAnya = findViewById(R.id.ImageAnya);
        Image_View22 = findViewById(R.id.Image_View22);
        Image_View33 = findViewById(R.id.Image_View33);
        Image_View44 = findViewById(R.id.Image_View44);
        Harmadik_oldal = findViewById(R.id.Harmadik_oldal);
        negyedik_oldal = findViewById(R.id.negyedik_oldal);
        otodik_oldal = findViewById(R.id.otodik_oldal);

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

    private void editSharedPreferencesKivalasztottKep(int i) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Csalad", i);
        editor.apply();

    }

    // A korábban kiválasztott kép helyére X-et rak be
    private void setKivalasztottKep() {

        int kivalasztottSzam = sharedPreferences.getInt("Csalad", 0);

        switch (kivalasztottSzam) {
            case 1:
                ImageEn.setImageResource(R.mipmap.psbuttonx);
                break;
            case 2:
                ImageGrandPa.setImageResource(R.mipmap.psbuttonx);
                break;
            case 3:
                ImageGrandma.setImageResource(R.mipmap.psbuttonx);
                break;
            case 4:
                ImageOlderbro.setImageResource(R.mipmap.psbuttonx);
                break;
            case 5:
                ImageOldersis.setImageResource(R.mipmap.psbuttonx);
                break;
            case 6:
                ImageYoungerbro.setImageResource(R.mipmap.psbuttonx);
                break;
            case 7:
                ImageYoungersis.setImageResource(R.mipmap.psbuttonx);
                break;
            case 8:
                ImageAnya.setImageResource(R.mipmap.psbuttonx);
                break;
        }
    }
}
