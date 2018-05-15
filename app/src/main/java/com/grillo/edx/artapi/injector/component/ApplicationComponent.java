package com.grillo.edx.artapi.injector.component;

import com.grillo.edx.artapi.base.BaseActivity;
import com.grillo.edx.artapi.domain.executor.PostExecutionThread;
import com.grillo.edx.artapi.domain.executor.ThreadExecutor;
import com.grillo.edx.artapi.domain.repository.PaintingRepository;
import com.grillo.edx.artapi.injector.module.ApplicationModule;
import com.grillo.edx.artapi.navigation.Navigator;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);

    Navigator getNavigator();

    ThreadExecutor getThreadExecutor();

    PostExecutionThread getPostExecutionThread();

    PaintingRepository getPaintingRepository();
}
