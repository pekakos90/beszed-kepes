package com.example.beszedkepes;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class LottieActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.av_from_code);
        animationView.setAnimation("checked_done.json");
        animationView.playAnimation();
        animationView.loop(false);


        Intent belepes = new Intent(LottieActivity.this, Main2Activity.class);
        startActivity(belepes);
        finish();


    }
}
