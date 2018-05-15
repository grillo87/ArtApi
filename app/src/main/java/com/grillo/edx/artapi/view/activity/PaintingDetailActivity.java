package com.grillo.edx.artapi.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.base.BaseActivity;
import com.grillo.edx.artapi.injector.component.ApplicationComponent;
import com.grillo.edx.artapi.model.PaintingModel;

public class PaintingDetailActivity extends BaseActivity {

    private static final String EXTRA_PAINTING = "EXTRA_PAINTING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting_detail);
    }

    @Override
    protected void initializeInjector(ApplicationComponent applicationComponent) {

    }

    @Override
    protected void setViewElements() {

    }

    @Override
    protected void setViewsElementsCustomFont() {

    }

    @Override
    protected void initializePresenter() {

    }


    public static Intent getCallingIntent(Context context, PaintingModel paintingModel) {
        Intent callingIntent = new Intent(context, PaintingDetailActivity.class);
        callingIntent.putExtra(EXTRA_PAINTING, paintingModel);
        return callingIntent;
    }
}
