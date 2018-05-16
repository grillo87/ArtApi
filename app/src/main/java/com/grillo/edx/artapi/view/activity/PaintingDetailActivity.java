package com.grillo.edx.artapi.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.base.BaseActivity;
import com.grillo.edx.artapi.injector.component.ApplicationComponent;
import com.grillo.edx.artapi.injector.component.DaggerPaintingComponent;
import com.grillo.edx.artapi.injector.module.ActivityModule;
import com.grillo.edx.artapi.injector.module.PaintingModule;
import com.grillo.edx.artapi.model.PaintingModel;
import com.grillo.edx.artapi.presenter.PaintingDetailPresenter;
import com.grillo.edx.artapi.presenter.PaintingListPresenter;
import com.grillo.edx.artapi.view.views.PaintingDetailView;

import java.util.Locale;

import javax.inject.Inject;

public class PaintingDetailActivity extends BaseActivity implements PaintingDetailView {

    private static final String EXTRA_PAINTING = "EXTRA_PAINTING";

    private ImageView activityDetailPaintingImageView;
    private TextView activityDetailPaintingTextView;
    private TextView activityDetailPaintingAuthorTextView;
    private TextView activityDetailPaintingDetailTextView;
    private AdView activityPaintingDetailBannerAdview;

    @Inject
    PaintingDetailPresenter paintingDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_painting_detail);

        super.onCreate(savedInstanceState);

        setUpToolbar(true);
        initializePaintingDetailBanner();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            navigator.goToPaintingList(getActivity());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initializeInjector(ApplicationComponent applicationComponent) {

        DaggerPaintingComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(new ActivityModule(this))
                .paintingModule(new PaintingModule()).build().inject(this);

    }

    @Override
    protected void setViewElements() {

        appToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        appToolbarTitle = (TextView) findViewById(R.id.app_toolbar_title);
        activityDetailPaintingImageView = (ImageView) findViewById(R.id.activity_detail_painting_image_view);
        activityDetailPaintingTextView = (TextView) findViewById(R.id.activity_detail_painting_text_view);
        activityDetailPaintingAuthorTextView = (TextView) findViewById(R.id.activity_detail_painting_author_text_view);
        activityDetailPaintingDetailTextView = (TextView) findViewById(R.id.activity_detail_painting_detail_text_view);
        activityPaintingDetailBannerAdview = (AdView) findViewById(R.id.activity_painting_detail_banner_adview);

    }

    @Override
    protected void setViewsElementsCustomFont() {

        activityDetailPaintingTextView.setTypeface(getCustomFont());
        activityDetailPaintingAuthorTextView.setTypeface(getCustomFont());
        appToolbarTitle.setTypeface(getCustomFont());
    }

    @Override
    protected void initializePresenter() {

        paintingDetailPresenter.setView(this);
        paintingDetailPresenter.setPaintingElements((PaintingModel) getIntent().getSerializableExtra(EXTRA_PAINTING));

    }

    @Override
    public void onBackPressed() {

        navigator.goToPaintingList(getActivity());

    }

    public static Intent getCallingIntent(Context context, PaintingModel paintingModel) {
        Intent callingIntent = new Intent(context, PaintingDetailActivity.class);
        callingIntent.putExtra(EXTRA_PAINTING, paintingModel);
        return callingIntent;
    }

    @Override
    public void initializePaintingDetailBanner() {

        MobileAds.initialize(this, getActivity().getResources().getString(R.string.activity_painting_detail_banner_identification));
        AdRequest adRequest = new AdRequest.Builder().build();
        activityPaintingDetailBannerAdview.loadAd(adRequest);

    }

    @Override
    public void setUpPantingElements(PaintingModel paintingModel) {

        paintingDetailPresenter.setPaintingElements(paintingModel);

    }

    @Override
    public void showGenericError() {

        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.activity_painting_detail_error_message), Toast.LENGTH_LONG).show();
        navigator.goToPaintingList(getActivity());

    }

    @Override
    public void setPaintingName(String paintingName) {

        activityDetailPaintingTextView.setText(paintingName);

    }

    @Override
    public void setPaintingAuthorAndYear(String author, String year) {

        activityDetailPaintingAuthorTextView.setText(String.format(Locale.US, getActivity().getResources().getString(R.string.activity_painting_detail_author_year_format), author, year));

    }

    @Override
    public void setPaintingDescription(String paintingDescription) {

        activityDetailPaintingDetailTextView.setText(paintingDescription);

    }

    @Override
    public void setPaintingPicture(String paintingPicture) {

        Glide.with(getActivity().getApplicationContext()).load(paintingPicture).asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(activityDetailPaintingImageView);

    }

    @Override
    public void setPaintingNameAppBar(String paintingName) {

        setAppBarTittle(String.format(Locale.US, getActivity().getResources().getString(R.string.activity_painting_detail_app_bar_title), paintingName));

    }
}
