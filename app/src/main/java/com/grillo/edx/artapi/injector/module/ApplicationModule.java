package com.grillo.edx.artapi.injector.module;

import android.content.Context;

import com.grillo.edx.artapi.base.AndroidApplication;
import com.grillo.edx.artapi.base.UIThread;
import com.grillo.edx.artapi.data.executor.JobExecutor;
import com.grillo.edx.artapi.data.net.ApiConstants;
import com.grillo.edx.artapi.data.net.PaintingApiService;
import com.grillo.edx.artapi.data.repository.PaintingsRepositoryImpl;
import com.grillo.edx.artapi.data.repository.datasource.PaintingDataStore;
import com.grillo.edx.artapi.data.repository.datasource.RetrofitPaintingDataStore;
import com.grillo.edx.artapi.domain.executor.PostExecutionThread;
import com.grillo.edx.artapi.domain.executor.ThreadExecutor;
import com.grillo.edx.artapi.domain.repository.PaintingRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    PaintingRepository providePaintingRepository(PaintingsRepositoryImpl paintingsRepository) {
        return paintingsRepository;
    }

    @Provides
    @Singleton
    PaintingDataStore provideRetrofitPaintingDataStore(RetrofitPaintingDataStore retrofitPaintingDataStore) {
        return retrofitPaintingDataStore;
    }

    @Provides
    @Singleton
    PaintingApiService provideComicPaintingService() {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(PaintingApiService.class);
    }

}
