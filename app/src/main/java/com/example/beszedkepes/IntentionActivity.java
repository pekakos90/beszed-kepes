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

    private ImageView Myself_oldal, Family_oldal, negyedik_oldal,  Image_View11, Image_View22, Image_View33,
            Image_View44, IdGetup, IdBreakfast, IdDressing, IdHug, IdHideSeek, IdCleaning, IdDancing,
            IdDieta, IdMusic, IdOlvas, IdSeta, IdAludni, IdBeszel, IdHajfest, IdFoci, IdFotoz, IdHinta,
            IdVadasz, IdFesul, IdKemping;
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

        String informacio_problem = sharedPreferences.getString("problem", "");
        Bitmap seged_bitmap_problem = decodeToBase64(informacio_problem);
        Image_View44.setImageBitmap(seged_bitmap_problem);

        Myself_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View33.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.clear();
                    editor.apply();
                    Intent myself_activity= new Intent(IntentionActivity.this,Main2Activity.class);
                    startActivity(myself_activity);
                    finish();
                } else {
                    Intent myself_activity= new Intent(IntentionActivity.this,Main2Activity.class);
                    startActivity(myself_activity);
                    finish();
                }
            }
        });

        Family_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View33.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.clear();
                    editor.apply();
                    Intent family_activity = new Intent(IntentionActivity.this, FamilyActivity.class);
                    startActivity(family_activity);
                    finish();
                } else {
                    Intent family_activity = new Intent(IntentionActivity.this, FamilyActivity.class);
                    startActivity(family_activity);
                    finish();
                }
            }
        });


        negyedik_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View33.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.clear();
                    editor.apply();
                    Intent problem_activity= new Intent(IntentionActivity.this,ProblemsActivity.class);
                    startActivity(problem_activity);
                    finish();
                } else {
                    Intent problem_activity= new Intent(IntentionActivity.this,ProblemsActivity.class);
                    startActivity(problem_activity);
                    finish();
                }
            }
        });

        IdHug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.hugging);
                    IdHug.setImageResource(R.mipmap.psbuttonx);
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
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdDressing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.dressingup);
                    IdHug.setImageResource(R.mipmap.hugging);
                    IdHug.setEnabled(true);
                    IdDressing.setImageResource(R.mipmap.psbuttonx);
                    IdDressing.setEnabled(false);
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
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.breakfast);
                    IdHug.setImageResource(R.mipmap.hugging);
                    IdHug.setEnabled(true);
                    IdDressing.setImageResource(R.mipmap.dressingup);
                    IdDressing.setEnabled(true);
                    IdBreakfast.setImageResource(R.mipmap.psbuttonx);
                    IdBreakfast.setEnabled(false);
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
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.music);
                    IdHug.setImageResource(R.mipmap.hugging);
                    IdHug.setEnabled(true);
                    IdDressing.setImageResource(R.mipmap.dressingup);
                    IdDressing.setEnabled(true);
                    IdBreakfast.setImageResource(R.mipmap.breakfast);
                    IdBreakfast.setEnabled(true);
                    IdMusic.setImageResource(R.mipmap.psbuttonx);
                    IdMusic.setEnabled(false);
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
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdDancing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.dancing);
                    IdHug.setImageResource(R.mipmap.hugging);
                    IdHug.setEnabled(true);
                    IdDressing.setImageResource(R.mipmap.dressingup);
                    IdDressing.setEnabled(true);
                    IdBreakfast.setImageResource(R.mipmap.breakfast);
                    IdBreakfast.setEnabled(true);
                    IdMusic.setImageResource(R.mipmap.music);
                    IdMusic.setEnabled(true);
                    IdDancing.setImageResource(R.mipmap.psbuttonx);
                    IdDancing.setEnabled(false);
                    IdDieta.setImageResource(R.mipmap.dieta);
                    IdDieta.setEnabled(true);
                    IdHideSeek.setImageResource(R.mipmap.amagatall);
                    IdHideSeek.setEnabled(false);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdDieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.dieta);
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
                    IdDieta.setImageResource(R.mipmap.psbuttonx);
                    IdDieta.setEnabled(false);
                    IdHideSeek.setImageResource(R.mipmap.amagatall);
                    IdHideSeek.setEnabled(false);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdHideSeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.amagatall);
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
                    IdHideSeek.setImageResource(R.mipmap.psbuttonx);
                    IdHideSeek.setEnabled(false);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.cleaning);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.psbuttonx);
                    IdCleaning.setEnabled(false);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdGetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.getup);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.psbuttonx);
                    IdGetup.setEnabled(false);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdOlvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.szervezetlen);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.psbuttonx);
                    IdOlvas.setEnabled(false);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdSeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.walking);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.psbuttonx);
                    IdSeta.setEnabled(false);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdAludni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.aludni_2);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.psbuttonx);
                    IdAludni.setEnabled(false);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdBeszel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.beszelget);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.psbuttonx);
                    IdBeszel.setEnabled(false);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdHajfest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.festhajat);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.psbuttonx);
                    IdHajfest.setEnabled(false);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdFoci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.foci);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.psbuttonx);
                    IdFoci.setEnabled(false);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdFotoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.fotoz);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.psbuttonx);
                    IdFotoz.setEnabled(false);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdHinta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.hinta);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.psbuttonx);
                    IdHinta.setEnabled(false);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdVadasz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.vadaszat);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.psbuttonx);
                    IdVadasz.setEnabled(false);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdFesul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.fesul);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.psbuttonx);
                    IdFesul.setEnabled(false);
                    IdKemping.setImageResource(R.mipmap.kemping);
                    IdKemping.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdKemping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals("")){
                    Image_View33.setImageResource(R.mipmap.kemping);
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
                    IdHideSeek.setEnabled(true);
                    IdCleaning.setImageResource(R.mipmap.cleaning);
                    IdCleaning.setEnabled(true);
                    IdGetup.setImageResource(R.mipmap.getup);
                    IdGetup.setEnabled(true);
                    IdOlvas.setImageResource(R.mipmap.szervezetlen);
                    IdOlvas.setEnabled(true);
                    IdSeta.setImageResource(R.mipmap.walking);
                    IdSeta.setEnabled(true);
                    IdAludni.setImageResource(R.mipmap.aludni_2);
                    IdAludni.setEnabled(true);
                    IdBeszel.setImageResource(R.mipmap.beszelget);
                    IdBeszel.setEnabled(true);
                    IdHajfest.setImageResource(R.mipmap.festhajat);
                    IdHajfest.setEnabled(true);
                    IdFoci.setImageResource(R.mipmap.foci);
                    IdFoci.setEnabled(true);
                    IdFotoz.setImageResource(R.mipmap.fotoz);
                    IdFotoz.setEnabled(true);
                    IdHinta.setImageResource(R.mipmap.hinta);
                    IdHinta.setEnabled(true);
                    IdVadasz.setImageResource(R.mipmap.vadaszat);
                    IdVadasz.setEnabled(true);
                    IdFesul.setImageResource(R.mipmap.fesul);
                    IdFesul.setEnabled(true);
                    IdKemping.setImageResource(R.mipmap.psbuttonx);
                    IdKemping.setEnabled(false);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("intention", encodeToBase64(((BitmapDrawable)Image_View33.getDrawable()).getBitmap()));
                editor.apply();
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
                IdHideSeek.setEnabled(true);
                IdCleaning.setImageResource(R.mipmap.cleaning);
                IdCleaning.setEnabled(true);
                IdGetup.setImageResource(R.mipmap.getup);
                IdGetup.setEnabled(true);
                IdOlvas.setImageResource(R.mipmap.szervezetlen);
                IdOlvas.setEnabled(true);
                IdSeta.setImageResource(R.mipmap.walking);
                IdSeta.setEnabled(true);
                IdAludni.setImageResource(R.mipmap.aludni_2);
                IdAludni.setEnabled(true);
                IdBeszel.setImageResource(R.mipmap.beszelget);
                IdBeszel.setEnabled(true);
                IdHajfest.setImageResource(R.mipmap.festhajat);
                IdHajfest.setEnabled(true);
                IdFoci.setImageResource(R.mipmap.foci);
                IdFoci.setEnabled(true);
                IdFotoz.setImageResource(R.mipmap.fotoz);
                IdFotoz.setEnabled(true);
                IdHinta.setImageResource(R.mipmap.hinta);
                IdHinta.setEnabled(true);
                IdVadasz.setImageResource(R.mipmap.vadaszat);
                IdVadasz.setEnabled(true);
                IdFesul.setImageResource(R.mipmap.fesul);
                IdFesul.setEnabled(true);
                IdKemping.setImageResource(R.mipmap.kemping);
                IdKemping.setEnabled(true);
                Image_View33.setImageResource(0);
            }
        });

    }

    private void init() {
        Myself_oldal = (ImageView) findViewById(R.id.Myself_oldal);
        negyedik_oldal = (ImageView) findViewById(R.id.negyedik_oldal);
        Image_View11 = findViewById(R.id.Image_View11);
        Image_View22 = findViewById(R.id.Image_View22);
        Image_View33 = findViewById(R.id.Image_View33);
        Image_View44 = findViewById(R.id.Image_View44);
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
        IdOlvas = findViewById(R.id.IdOlvas);
        IdSeta = findViewById(R.id.IdSeta);
        IdAludni = findViewById(R.id.IdAludni);
        IdBeszel = findViewById(R.id.IdBeszel);
        IdHajfest = findViewById(R.id.IdHajfest);
        IdFoci= findViewById(R.id.IdFoci);
        IdFotoz = findViewById(R.id.IdFotoz);
        IdHinta = findViewById(R.id.IdHinta);
        IdVadasz = findViewById(R.id.IdVadasz);
        IdFesul = findViewById(R.id.IdFesul);
        IdKemping = findViewById(R.id.IdKemping);
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
