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

public class ProblemsActivity extends AppCompatActivity {

    private ImageView IdNatha,IdTorokfaj, IdMegfaz, IdNyakfaj, IdHatfaj, IdSeb, IdFogfajas, IdVernyom,
            IdAlergia, IdGipsz, IdAjult, IdFertotlenit, IdEllenoriz, IdBeteg, Image_View11, Image_View22,
            Image_View33, Image_View44, Myself_oldal, Family_oldal, Harmadik_oldal;

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

        final String informacio_problem = sharedPreferences.getString("problem", "");
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
                if (informacio_problem.isEmpty()){
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.clear();
                    editor.commit();
                    Intent szandek_activity= new Intent(ProblemsActivity.this,IntentionActivity.class);
                    startActivity(szandek_activity);
                    finish();
                } else {
                    Intent szandek_activity= new Intent(ProblemsActivity.this,IntentionActivity.class);
                    startActivity(szandek_activity);
                    finish();
                }
            }
        });

        IdNatha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.nyatha);
                    IdNatha.setImageResource(R.mipmap.psbuttonx);
                    IdNatha.setEnabled(false);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdTorokfaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.sorethroat);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.psbuttonx);
                    IdTorokfaj.setEnabled(false);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdMegfaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.cold);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.psbuttonx);
                    IdMegfaz.setEnabled(false);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdNyakfaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.nyakfajas);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.psbuttonx);
                    IdNyakfaj.setEnabled(false);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdHatfaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.backpain);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.psbuttonx);
                    IdHatfaj.setEnabled(false);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdSeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.seb);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.psbuttonx);
                    IdSeb.setEnabled(false);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdFogfajas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.tothache);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.psbuttonx);
                    IdFogfajas.setEnabled(false);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdVernyom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.vernyomas);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.psbuttonx);
                    IdVernyom.setEnabled(false);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdAlergia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.alergia);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.psbuttonx);
                    IdAlergia.setEnabled(false);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdAjult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.ajult);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.psbuttonx);
                    IdAjult.setEnabled(false);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdFertotlenit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.fertotlenit);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.psbuttonx);
                    IdFertotlenit.setEnabled(false);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdEllenoriz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.ellenorizni);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.psbuttonx);
                    IdEllenoriz.setEnabled(false);
                    IdBeteg.setImageResource(R.mipmap.sick);
                    IdBeteg.setEnabled(true);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        IdBeteg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View44.equals("")){
                    Image_View44.setImageResource(R.mipmap.sick);
                    IdNatha.setImageResource(R.mipmap.nyatha);
                    IdNatha.setEnabled(true);
                    IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                    IdTorokfaj.setEnabled(true);
                    IdMegfaz.setImageResource(R.mipmap.cold);
                    IdMegfaz.setEnabled(true);
                    IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                    IdNyakfaj.setEnabled(true);
                    IdHatfaj.setImageResource(R.mipmap.backpain);
                    IdHatfaj.setEnabled(true);
                    IdSeb.setImageResource(R.mipmap.seb);
                    IdSeb.setEnabled(true);
                    IdFogfajas.setImageResource(R.mipmap.tothache);
                    IdFogfajas.setEnabled(true);
                    IdVernyom.setImageResource(R.mipmap.vernyomas);
                    IdVernyom.setEnabled(true);
                    IdAlergia.setImageResource(R.mipmap.alergia);
                    IdAlergia.setEnabled(true);
                    IdGipsz.setImageResource(R.mipmap.begipszel);
                    IdGipsz.setEnabled(true);
                    IdAjult.setImageResource(R.mipmap.ajult);
                    IdAjult.setEnabled(true);
                    IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                    IdFertotlenit.setEnabled(true);
                    IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                    IdEllenoriz.setEnabled(true);
                    IdBeteg.setImageResource(R.mipmap.psbuttonx);
                    IdBeteg.setEnabled(false);
                }
                SharedPreferences.Editor editor=sharedPreferences.edit();           //Editor azért kell, hogy tudjunk szerkeszteni a file-ban (képeket beletenni)
                editor.putString("problem", encodeToBase64(((BitmapDrawable)Image_View44.getDrawable()).getBitmap()));
                editor.apply();
            }
        });

        Image_View44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IdNatha.setImageResource(R.mipmap.nyatha);
                IdNatha.setEnabled(true);
                IdTorokfaj.setImageResource(R.mipmap.sorethroat);
                IdTorokfaj.setEnabled(true);
                IdMegfaz.setImageResource(R.mipmap.cold);
                IdMegfaz.setEnabled(true);
                IdNyakfaj.setImageResource(R.mipmap.nyakfajas);
                IdNyakfaj.setEnabled(true);
                IdHatfaj.setImageResource(R.mipmap.backpain);
                IdHatfaj.setEnabled(true);
                IdSeb.setImageResource(R.mipmap.seb);
                IdSeb.setEnabled(true);
                IdFogfajas.setImageResource(R.mipmap.tothache);
                IdFogfajas.setEnabled(true);
                IdVernyom.setImageResource(R.mipmap.vernyomas);
                IdVernyom.setEnabled(true);
                IdAlergia.setImageResource(R.mipmap.alergia);
                IdAlergia.setEnabled(true);
                IdGipsz.setImageResource(R.mipmap.begipszel);
                IdGipsz.setEnabled(true);
                IdAjult.setImageResource(R.mipmap.ajult);
                IdAjult.setEnabled(true);
                IdFertotlenit.setImageResource(R.mipmap.fertotlenit);
                IdFertotlenit.setEnabled(true);
                IdEllenoriz.setImageResource(R.mipmap.ellenorizni);
                IdEllenoriz.setEnabled(true);
                IdBeteg.setImageResource(R.mipmap.sick);
                IdBeteg.setEnabled(true);
                Image_View44.setImageResource(0);
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
        IdVernyom = findViewById(R.id.IdVernyom);
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
