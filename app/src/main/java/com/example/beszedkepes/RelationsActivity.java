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
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class RelationsActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private ImageView Image_View11, Image_View22, Image_View33, Image_View44, IdEgy, IdSok, IdStop, IdHarom, IdOt,
                        IdAlso, IdKozepso, IdFelso, IdAlatt, IdFelett, IdIgen, IdNagy, IdKicsi, IdMeleg, IdHideg,
                        Myself_oldal, Family_oldal, negyedik_oldal, Harmadik_oldal, button_kamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relations);

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

        String informacio_relations = sharedPreferences.getString("relation", "");
        Bitmap seged_bitmap_relations = decodeToBase64(informacio_relations);
        Image_View44.setImageBitmap(seged_bitmap_relations);

        Myself_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View44.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.remove("relation");
                    editor.apply();
                    Intent myself_activity= new Intent(RelationsActivity.this,Main2Activity.class);
                    startActivity(myself_activity);
                    finish();
                } else {
                    Intent myself_activity= new Intent(RelationsActivity.this,Main2Activity.class);
                    startActivity(myself_activity);
                    finish();
                }

            }
        });

        Family_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View44.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.remove("relation");
                    editor.apply();
                    Intent family_activity= new Intent(RelationsActivity.this,FamilyActivity.class);
                    startActivity(family_activity);
                    finish();
                } else {
                    Intent family_activity= new Intent(RelationsActivity.this,FamilyActivity.class);
                    startActivity(family_activity);
                    finish();
                }

            }
        });

        Harmadik_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View44.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.remove("relation");
                    editor.apply();
                    Intent szandek_activity= new Intent(RelationsActivity.this,IntentionActivity.class);
                    startActivity(szandek_activity);
                    finish();
                } else {
                    Intent szandek_activity= new Intent(RelationsActivity.this,IntentionActivity.class);
                    startActivity(szandek_activity);
                    finish();
                }
            }
        });

        Harmadik_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View44.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.remove("relation");
                    editor.apply();
                    Intent intention_activity= new Intent(RelationsActivity.this,IntentionActivity.class);
                    startActivity(intention_activity);
                    finish();
                } else {
                    Intent intention_activity= new Intent(RelationsActivity.this,IntentionActivity.class);
                    startActivity(intention_activity);
                    finish();
                }

            }
        });

        negyedik_oldal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Image_View44.getDrawable()==null){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.remove("relation");
                    editor.apply();
                    Intent problem_activity= new Intent(RelationsActivity.this,ProblemsActivity.class);
                    startActivity(problem_activity);
                    finish();
                } else {
                    Intent problem_activity= new Intent(RelationsActivity.this,ProblemsActivity.class);
                    startActivity(problem_activity);
                    finish();
                }

            }
        });

        button_kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kamera_activity = new Intent(RelationsActivity.this, CameraAcitvity.class);
                startActivity(kamera_activity);
                finish();
            }
        });

        IdEgy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.egy);
                    IdEgy.setImageResource(R.mipmap.psbuttonx);
                    IdEgy.setEnabled(false);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdSok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.sok);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.psbuttonx);
                    IdSok.setEnabled(false);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.allj);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.psbuttonx);
                    IdStop.setEnabled(false);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdHarom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.harom);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.psbuttonx);
                    IdHarom.setEnabled(false);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdOt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.ot);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.psbuttonx);
                    IdOt.setEnabled(false);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdAlso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.also);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.psbuttonx);
                    IdAlso.setEnabled(false);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdKozepso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.kozepse);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.psbuttonx);
                    IdKozepso.setEnabled(false);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdFelso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.felso);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.psbuttonx);
                    IdFelso.setEnabled(false);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdAlatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.alatta);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.psbuttonx);
                    IdAlatt.setEnabled(false);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdFelett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.felette);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.psbuttonx);
                    IdFelett.setEnabled(false);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdIgen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.igen);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.psbuttonx);
                    IdIgen.setEnabled(false);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdNagy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.nagy);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.psbuttonx);
                    IdNagy.setEnabled(false);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdKicsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.kicsi);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.psbuttonx);
                    IdKicsi.setEnabled(false);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdMeleg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.meleg);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.psbuttonx);
                    IdMeleg.setEnabled(false);
                    IdHideg.setImageResource(R.mipmap.hideg);
                    IdHideg.setEnabled(true);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdHideg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.hideg);
                    IdEgy.setImageResource(R.mipmap.egy);
                    IdEgy.setEnabled(true);
                    IdSok.setImageResource(R.mipmap.sok);
                    IdSok.setEnabled(true);
                    IdStop.setImageResource(R.mipmap.allj);
                    IdStop.setEnabled(true);
                    IdHarom.setImageResource(R.mipmap.harom);
                    IdHarom.setEnabled(true);
                    IdOt.setImageResource(R.mipmap.ot);
                    IdOt.setEnabled(true);
                    IdAlso.setImageResource(R.mipmap.also);
                    IdAlso.setEnabled(true);
                    IdKozepso.setImageResource(R.mipmap.kozepse);
                    IdKozepso.setEnabled(true);
                    IdFelso.setImageResource(R.mipmap.felso);
                    IdFelso.setEnabled(true);
                    IdAlatt.setImageResource(R.mipmap.alatta);
                    IdAlatt.setEnabled(true);
                    IdFelett.setImageResource(R.mipmap.felette);
                    IdFelett.setEnabled(true);
                    IdIgen.setImageResource(R.mipmap.igen);
                    IdIgen.setEnabled(true);
                    IdNagy.setImageResource(R.mipmap.nagy);
                    IdNagy.setEnabled(true);
                    IdKicsi.setImageResource(R.mipmap.kicsi);
                    IdKicsi.setEnabled(true);
                    IdMeleg.setImageResource(R.mipmap.meleg);
                    IdMeleg.setEnabled(true);
                    IdHideg.setImageResource(R.mipmap.psbuttonx);
                    IdHideg.setEnabled(false);
                }
                //Itt hozzuk létre a sharedpreference-t//
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("relation", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        Image_View44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdEgy.setImageResource(R.mipmap.egy);
                IdEgy.setEnabled(true);
                IdSok.setImageResource(R.mipmap.sok);
                IdSok.setEnabled(true);
                IdStop.setImageResource(R.mipmap.allj);
                IdStop.setEnabled(true);
                IdHarom.setImageResource(R.mipmap.harom);
                IdHarom.setEnabled(true);
                IdOt.setImageResource(R.mipmap.ot);
                IdOt.setEnabled(true);
                IdAlso.setImageResource(R.mipmap.also);
                IdAlso.setEnabled(true);
                IdKozepso.setImageResource(R.mipmap.kozepse);
                IdKozepso.setEnabled(true);
                IdFelso.setImageResource(R.mipmap.felso);
                IdFelso.setEnabled(true);
                IdAlatt.setImageResource(R.mipmap.alatta);
                IdAlatt.setEnabled(true);
                IdFelett.setImageResource(R.mipmap.felette);
                IdFelett.setEnabled(true);
                IdIgen.setImageResource(R.mipmap.igen);
                IdIgen.setEnabled(true);
                IdNagy.setImageResource(R.mipmap.nagy);
                IdNagy.setEnabled(true);
                IdKicsi.setImageResource(R.mipmap.kicsi);
                IdKicsi.setEnabled(true);
                IdMeleg.setImageResource(R.mipmap.meleg);
                IdMeleg.setEnabled(true);
                IdHideg.setImageResource(R.mipmap.hideg);
                IdHideg.setEnabled(true);
                Image_View44.setImageResource(0);
            }
        });

    }

    private void init() {
        Image_View11 = findViewById(R.id.Image_View11);
        Image_View22 = findViewById(R.id.Image_View22);
        Image_View33 = findViewById(R.id.Image_View33);
        Image_View44 = findViewById(R.id.Image_View44);
        IdEgy = findViewById(R.id.IdEgy);
        IdSok = findViewById(R.id.IdSok);
        IdStop = findViewById(R.id.IdStop);
        IdHarom = findViewById(R.id.IdHarom);
        IdOt = findViewById(R.id.IdOt);
        IdAlso = findViewById(R.id.IdAlso);
        IdKozepso = findViewById(R.id.IdKozepso);
        IdFelso = findViewById(R.id.IdFelso);
        IdAlatt = findViewById(R.id.IdAlatt);
        IdFelett = findViewById(R.id.IdFelett);
        IdIgen = findViewById(R.id.IdIgen);
        IdNagy = findViewById(R.id.IdNagy);
        IdKicsi = findViewById(R.id.IdKicsi);
        IdMeleg = findViewById(R.id.IdMeleg);
        IdHideg = findViewById(R.id.IdHideg);
        Myself_oldal = findViewById(R.id.Myself_oldal);
        Family_oldal = findViewById(R.id.Family_oldal);
        negyedik_oldal = findViewById(R.id.negyedik_oldal);
        Harmadik_oldal = findViewById(R.id.Harmadik_oldal);
        button_kamera = findViewById(R.id.button_kamera);

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
