package com.grillo.edx.artapi.navigation;

import android.app.Activity;
import android.content.Intent;

import com.grillo.edx.artapi.main.activity.MainActivity;
import com.grillo.edx.artapi.model.PaintingModel;
import com.grillo.edx.artapi.view.activity.PaintingDetailActivity;
import com.grillo.edx.artapi.view.activity.PaintingListActivity;
import com.grillo.edx.artapi.view.activity.SplashActivity;

import javax.inject.Inject;

public class Navigator {

    @Inject
    public Navigator() {
    }

    public void goToPaintingList(Activity currentActivity) {

        Intent paintingListIntent = new Intent().setClass(
                currentActivity, PaintingListActivity.class);
        currentActivity.startActivity(paintingListIntent);
        currentActivity.finish();

    }

    public void goToPaintingDetail(Activity activity, PaintingModel paintingModel) {
        if (activity != null) {
            Intent intentToLaunch = PaintingDetailActivity.getCallingIntent(activity, paintingModel);
            activity.startActivity(intentToLaunch);
        }
    }

}
