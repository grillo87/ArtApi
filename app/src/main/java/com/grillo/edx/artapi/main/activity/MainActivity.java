package com.grillo.edx.artapi.main.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.main.fragments.DetailPaintingFragment;
import com.grillo.edx.artapi.main.fragments.PaintingListFragment;
import com.grillo.edx.artapi.models.Painting;
import com.grillo.edx.artapi.utils.Utils;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "MainActivity";
    public static final int PAINTINGS_LIST_LAYOUT = 0;
    public static final int DETAIL_PAINTING_LAYOUT = 1;
    public Painting painting;
    public Typeface customTypeFace;
    private MainActivity activity;
    private Fragment fragment;
    private int currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customTypeFace = Typeface.createFromAsset(getApplicationContext().getAssets(), Utils.CUSTOM_FONT_LOCATION);

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

    @Override
    public void onBackPressed() {

        if (currentFragment == DETAIL_PAINTING_LAYOUT) {
            displayViewAnimation(PAINTINGS_LIST_LAYOUT);
        }

    }

    public void displayViewAnimation(int viewToDisplay) {

        fragment = null;
        currentFragment = viewToDisplay;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (viewToDisplay) {

            case (DETAIL_PAINTING_LAYOUT):

                fragment = new DetailPaintingFragment();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);

                break;

            case (PAINTINGS_LIST_LAYOUT):

                fragment = new PaintingListFragment();
                transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);

                break;

        }

        transaction.replace(R.id.activity_main_container, fragment);
        transaction.commit();

    }


}
