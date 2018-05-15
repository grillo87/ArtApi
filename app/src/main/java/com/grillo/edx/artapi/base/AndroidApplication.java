package com.grillo.edx.artapi.base;

import android.app.Application;

import com.grillo.edx.artapi.injector.component.ApplicationComponent;
import com.grillo.edx.artapi.injector.component.DaggerApplicationComponent;
import com.grillo.edx.artapi.injector.module.ApplicationModule;

public class AndroidApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }

}
