package com.example.beszedkepes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toast;

public class IntentionActivity extends AppCompatActivity {

    private ImageView Myself_oldal, Family_oldal, Image_View33, IdGetup, IdBreakfast, IdDressing, IdHug, IdHideSeek, IdCleaning,
    IdDieta, IdMusic;
    private TableLayout tableLayout1;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intention);

        init();

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

       IdDressing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Image_View33.equals(IdDressing))
                {
                    Image_View33.setImageResource(R.mipmap.dressingup);
                    IdDressing.setImageResource(R.mipmap.backpain);
                    IdDressing.setEnabled(false);
                }else {
                    Toast.makeText(IntentionActivity.this, "Egy másik kártya kiválasztásra került.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void init() {
        Myself_oldal = (ImageView) findViewById(R.id.Myself_oldal);
        Family_oldal = findViewById(R.id.Family_oldal);
        IdGetup = findViewById(R.id.IdGetup);
        IdBreakfast = findViewById(R.id.IdBreakfast);
        IdCleaning = findViewById(R.id.IdCleaning);
        IdDieta = findViewById(R.id.IdDieta);
        IdDressing = findViewById(R.id.IdDressing);
        IdHug = findViewById(R.id.IdHug);
        IdHideSeek = findViewById(R.id.IdHideSeek);
        IdMusic = findViewById(R.id.IdMusic);
        tableLayout1 = (TableLayout) findViewById(R.id.tableLayout1);

        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
    }
}
