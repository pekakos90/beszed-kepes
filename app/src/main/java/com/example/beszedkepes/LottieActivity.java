package com.example.beszedkepes;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class LottieActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        LottieAnimationView animationView = findViewById(R.id.av_from_code);
        animationView.setAnimation("liquid-loading.json");
        animationView.playAnimation();
        animationView.loop(false);

        Handler mHandler = new Handler(Looper.getMainLooper());
        mHandler.postDelayed(() -> {
            Intent intent = new Intent(LottieActivity.this, Main2Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }, 3500);

    }
}
