package com.grillo.edx.artapi.injector.module;

import com.grillo.edx.artapi.domain.interactor.GetPaintingsUseCase;
import com.grillo.edx.artapi.domain.interactor.GetPaintingsUseCaseImpl;
import com.grillo.edx.artapi.injector.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class PaintingModule {

    @Provides
    @PerActivity
    GetPaintingsUseCase provideGetPaintingUseCase(GetPaintingsUseCaseImpl getPaintingsUseCase) {
        return getPaintingsUseCase;
    }

}
