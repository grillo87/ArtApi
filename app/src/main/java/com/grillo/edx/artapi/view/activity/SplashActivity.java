package com.grillo.edx.artapi.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.base.BaseActivity;
import com.grillo.edx.artapi.injector.component.ApplicationComponent;
import com.grillo.edx.artapi.injector.component.DaggerPaintingComponent;
import com.grillo.edx.artapi.injector.module.ActivityModule;
import com.grillo.edx.artapi.injector.module.PaintingModule;
import com.grillo.edx.artapi.presenter.SplashPresenter;
import com.grillo.edx.artapi.view.views.SplashView;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashView {

    private TextView activitySplashATextview;
    private TextView activitySplashRTextview;
    private TextView activitySplashTTextview;
    private TextView activitySplashSTextview;
    private TextView activitySplashDevelopedByTextview;

    private Handler handlerR;
    private Handler handlerT;

    private long splashDelay = 5000;
    private long animationDelay = 500;
    private long animationDuration = 5000;

    private Animation inAnimationA;
    private Animation inAnimationR;
    private Animation inAnimationT;
    private Animation inAnimationS;
    private Animation inAnimationNameExplained;

    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);

        setHandlers();
        setAnimations();
        initializeTimerTask();

        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initializeInjector(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);

        DaggerPaintingComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(new ActivityModule(this))
                .paintingModule(new PaintingModule()).build().inject(this);

    }

    @Override
    protected void setViewElements() {

        activitySplashATextview = (TextView) findViewById(R.id.activity_splash_a_textview);
        activitySplashRTextview = (TextView) findViewById(R.id.activity_splash_r_textview);
        activitySplashTTextview = (TextView) findViewById(R.id.activity_splash_t_textview);
        activitySplashSTextview = (TextView) findViewById(R.id.activity_splash_s_textview);
        activitySplashDevelopedByTextview = (TextView) findViewById(R.id.activity_splash_developed_by_textview);

    }

    @Override
    protected void setViewsElementsCustomFont() {

        activitySplashATextview.setTypeface(getCustomFont());
        activitySplashRTextview.setTypeface(getCustomFont());
        activitySplashTTextview.setTypeface(getCustomFont());
        activitySplashSTextview.setTypeface(getCustomFont());

    }

    @Override
    protected void initializePresenter() {

        splashPresenter.setView(this);
        splashPresenter.startViewAnimations();

    }


    @Override
    public void setHandlers() {

        handlerR = new Handler();
        handlerT = new Handler();

    }

    @Override
    public void setAnimations() {

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

    }

    @Override
    public void startAAnimation() {

        activitySplashATextview.startAnimation(inAnimationA);
        activitySplashATextview.setVisibility(View.VISIBLE);
        handlerR.postDelayed(new Runnable() {
            @Override
            public void run() {

                startRAnimation();

            }
        }, animationDelay);

    }

    @Override
    public void startRAnimation() {

        activitySplashRTextview.startAnimation(inAnimationR);
        activitySplashRTextview.setVisibility(View.VISIBLE);

        handlerR.postDelayed(new Runnable() {
            @Override
            public void run() {

                startTAnimation();

            }
        }, animationDelay);

    }

    @Override
    public void startTAnimation() {

        activitySplashTTextview.startAnimation(inAnimationT);
        activitySplashTTextview.setVisibility(View.VISIBLE);

        handlerT.postDelayed(new Runnable() {
            @Override
            public void run() {

                startSAnimation();

            }
        }, animationDelay);

    }

    @Override
    public void startSAnimation() {

        activitySplashSTextview.startAnimation(inAnimationS);
        activitySplashSTextview.setVisibility(View.VISIBLE);

    }

    @Override
    public void initializeTimerTask() {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {


                getNavigator().goToPaintingList(getActivity());

            }
        };

        Timer timer = new Timer();
        timer.schedule(task, splashDelay);

    }
}
