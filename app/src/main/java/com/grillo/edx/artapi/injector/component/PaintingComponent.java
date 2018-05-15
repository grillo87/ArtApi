package com.grillo.edx.artapi.injector.component;


import com.grillo.edx.artapi.injector.PerActivity;
import com.grillo.edx.artapi.injector.module.ActivityModule;
import com.grillo.edx.artapi.injector.module.PaintingModule;
import com.grillo.edx.artapi.view.activity.PaintingDetailActivity;
import com.grillo.edx.artapi.view.activity.PaintingListActivity;
import com.grillo.edx.artapi.view.activity.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, PaintingModule.class})

public interface PaintingComponent extends ActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(PaintingListActivity paintingListActivity);

    void inject(PaintingDetailActivity paintingDetailActivity);

}
