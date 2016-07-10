package com.grillo.edx.artapi.splash.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.main.activity.MainActivity;
import com.grillo.edx.artapi.utils.Utils;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private TextView activitySplashATextview;
    private TextView activitySplashRTextview;
    private TextView activitySplashTTextview;
    private TextView activitySplashSTextview;
    private TextView activitySplashDevelopedByTextview;
    private long splashDelay = 5000;
    private Typeface customTypeFace;
    private Handler handlerR;
    private Handler handlerT;
    private long animationDelay = 500;
    private long animationDuration = 5000;
    private Animation inAnimationA;
    private Animation inAnimationR;
    private Animation inAnimationT;
    private Animation inAnimationS;
    private Animation inAnimationNameExplained;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        customTypeFace = Typeface.createFromAsset(getApplicationContext().getAssets(), Utils.CUSTOM_FONT_LOCATION);

        activitySplashATextview = (TextView) findViewById(R.id.activity_splash_a_textview);
        activitySplashRTextview = (TextView) findViewById(R.id.activity_splash_r_textview);
        activitySplashTTextview = (TextView) findViewById(R.id.activity_splash_t_textview);
        activitySplashSTextview = (TextView) findViewById(R.id.activity_splash_s_textview);
        activitySplashDevelopedByTextview = (TextView) findViewById(R.id.activity_splash_developed_by_textview);

        activitySplashATextview.setTypeface(customTypeFace);
        activitySplashRTextview.setTypeface(customTypeFace);
        activitySplashTTextview.setTypeface(customTypeFace);
        activitySplashSTextview.setTypeface(customTypeFace);
        activitySplashDevelopedByTextview.setTypeface(customTypeFace);

        handlerR = new Handler();
        handlerT = new Handler();

        inAnimationA = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        inAnimationA.setDuration(animationDuration);

        inAnimationR = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        inAnimationR.setDuration(animationDuration);

        inAnimationT = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        inAnimationT.setDuration(animationDuration);

        inAnimationS = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        inAnimationS.setDuration(animationDuration);

        inAnimationNameExplained = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        inAnimationNameExplained.setDuration(animationDuration);

        activitySplashATextview.startAnimation(inAnimationA);
        activitySplashATextview.setVisibility(View.VISIBLE);

        handlerR.postDelayed(new Runnable() {
            @Override
            public void run() {

                startRAnimation();

            }
        }, animationDelay);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {


                Intent mainIntent = new Intent().setClass(
                        SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();

            }
        };

        Timer timer = new Timer();
        timer.schedule(task, splashDelay);

    }


    private void startRAnimation() {

        activitySplashRTextview.startAnimation(inAnimationR);
        activitySplashRTextview.setVisibility(View.VISIBLE);

        handlerR.postDelayed(new Runnable() {
            @Override
            public void run() {

                startTAnimation();

            }
        }, animationDelay);

    }

    private void startTAnimation() {

        activitySplashTTextview.startAnimation(inAnimationT);
        activitySplashTTextview.setVisibility(View.VISIBLE);

        handlerT.postDelayed(new Runnable() {
            @Override
            public void run() {

                startSAnimation();

            }
        }, animationDelay);

    }


    private void startSAnimation() {

        activitySplashSTextview.startAnimation(inAnimationS);
        activitySplashSTextview.setVisibility(View.VISIBLE);

    }

}
