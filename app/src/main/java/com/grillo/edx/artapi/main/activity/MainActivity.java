package com.grillo.edx.artapi.main.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.main.fragments.PaintingListFragment;
import com.grillo.edx.artapi.models.Painting;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "MainActivity";
    public static final int PAINTINGS_LIST_LAYOUT = 0;
    public static final int DETAIL_PAINTING_LAYOUT = 1;
    private Retrofit retrofit;
    private MainActivity activity;
    private Fragment fragment;
    private int currentFragment;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        displayListPaintings();


    }

    private void displayListPaintings() {

        fragment = new PaintingListFragment();
        FragmentTransaction fragmentManager = getSupportFragmentManager().beginTransaction();
        fragmentManager.replace(R.id.activity_main_container, fragment);
        fragmentManager.commit();

        currentFragment = PAINTINGS_LIST_LAYOUT;

    }


}
