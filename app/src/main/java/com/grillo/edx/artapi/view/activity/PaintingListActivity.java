package com.grillo.edx.artapi.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.base.BaseActivity;
import com.grillo.edx.artapi.injector.component.ApplicationComponent;

public class PaintingListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting_list);
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
}
