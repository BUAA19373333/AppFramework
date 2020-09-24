package com.example.appframework;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class OpeningActivity extends AppCompatActivity {
    private ImageView welcomeImg = null;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.hide();
        }
        welcomeImg = findViewById(R.id.wrap);
        AlphaAnimation anima = new AlphaAnimation(0f, 1.0f);
        anima.setDuration(1500);
        anima.setRepeatMode(AlphaAnimation.REVERSE);
        anima.setRepeatCount(1);
        anima.setFillAfter(true);
        welcomeImg.startAnimation(anima);
        anima.setAnimationListener(new AnimationImpl());
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        goneSystemUi();
    }*/

    private class AnimationImpl implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {
            welcomeImg.setBackgroundResource(R.mipmap.opening_pic);
        }
        @Override
        public void onAnimationEnd(Animation animation) {
            skip();
        }
        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }

    private void skip() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}