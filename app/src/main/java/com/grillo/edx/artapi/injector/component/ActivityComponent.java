package com.grillo.edx.artapi.injector.component;

import android.app.Activity;

import com.grillo.edx.artapi.injector.PerActivity;
import com.grillo.edx.artapi.injector.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();
}
