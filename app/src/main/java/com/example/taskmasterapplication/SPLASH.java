package com.example.taskmasterapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SPLASH extends AppCompatActivity {
    Animation animation,slogan;
    ProgressBar progressBar;

    TextView tvslogan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
      init();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SPLASH.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2500);


    }
    private void init()
    {
        animation= AnimationUtils.loadAnimation(this,R.anim.animation);
        slogan=AnimationUtils.loadAnimation(this,R.anim.slogan);
        progressBar=findViewById(R.id.progressBar);
        tvslogan=findViewById(R.id.tvSlogan);

        tvslogan.setAnimation(animation);

    }

}
