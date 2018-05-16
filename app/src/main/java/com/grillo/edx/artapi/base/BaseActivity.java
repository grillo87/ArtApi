package com.grillo.edx.artapi.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.grillo.edx.artapi.injector.component.ApplicationComponent;
import com.grillo.edx.artapi.navigation.Navigator;
import com.grillo.edx.artapi.utils.Utils;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {

    public String LOG_TAG = this.getClass().getSimpleName();
    protected Typeface customFont;
    protected Toolbar appToolbar;
    protected TextView appToolbarTitle;

    @Inject
    protected Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.setPortaitOrientation(this);
        Utils.tintStatusBar(this);
        customFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Pacifico.ttf");

        initializeInjector(getApplicationComponent());
        setViewElements();
        setViewsElementsCustomFont();
        initializePresenter();

    }


    private ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getComponent();
    }

    public BaseActivity getActivity() {

        return this;

    }

    protected void setUpToolbar(boolean showUpButton) {
        if (appToolbar != null) {
            setSupportActionBar(appToolbar);
            if (getSupportActionBar() != null) {

                getSupportActionBar().setDisplayHomeAsUpEnabled(showUpButton);
                getSupportActionBar().setDisplayShowHomeEnabled(showUpButton);

            }
        }
    }

    protected void setAppBarTittle(String tittle) {

        if (appToolbarTitle != null) {

            appToolbarTitle.setText(tittle);

        }

    }

    public Typeface getCustomFont() {
        return customFont;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    protected abstract void initializeInjector(ApplicationComponent applicationComponent);

    protected abstract void setViewElements();

    protected abstract void setViewsElementsCustomFont();

    protected abstract void initializePresenter();

}
