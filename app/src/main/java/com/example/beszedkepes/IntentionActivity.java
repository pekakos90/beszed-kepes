package com.example.beszedkepes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class IntentionActivity extends AppCompatActivity {

    private ImageView Myself_oldal, Family_oldal;

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
    }

    private void init() {
        Myself_oldal = (ImageView) findViewById(R.id.Myself_oldal);
        Family_oldal = findViewById(R.id.Family_oldal);

        sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
    }
}
