package com.grillo.edx.artapi.presenter;

import com.grillo.edx.artapi.injector.PerActivity;
import com.grillo.edx.artapi.view.views.SplashView;
import com.grillo.edx.artapi.view.views.View;

import javax.inject.Inject;

@PerActivity
public class SplashPresenter implements Presenter {

    private SplashView splashView;

    @Inject
    public SplashPresenter() {

    }


    @Override
    public void setView(View view) {

        this.splashView = (SplashView) view;

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public void startViewAnimations() {
        splashView.startAAnimation();
    }

}
