package com.grillo.edx.artapi.view.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.base.BaseActivity;
import com.grillo.edx.artapi.injector.component.ApplicationComponent;
import com.grillo.edx.artapi.injector.component.DaggerPaintingComponent;
import com.grillo.edx.artapi.injector.module.ActivityModule;
import com.grillo.edx.artapi.injector.module.PaintingModule;
import com.grillo.edx.artapi.view.adapter.PaintingListAdapter;
import com.grillo.edx.artapi.model.PaintingModel;
import com.grillo.edx.artapi.presenter.PaintingListPresenter;
import com.grillo.edx.artapi.utils.Utils;
import com.grillo.edx.artapi.view.listener.PaintingListClickInterface;
import com.grillo.edx.artapi.view.views.PaintingListView;

import java.util.List;

import javax.inject.Inject;

public class PaintingListActivity extends BaseActivity implements PaintingListView, PaintingListClickInterface {

    private RecyclerView activityPaintingListRecyclerView;
    private Dialog dialog;

    private PaintingListAdapter paintingListAdapter;

    @Inject
    PaintingListPresenter paintingListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_painting_list);

        super.onCreate(savedInstanceState);

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
        activityPaintingListRecyclerView = (RecyclerView) findViewById(R.id.activity_painting_list_recycler_view);

    }

    @Override
    protected void setViewsElementsCustomFont() {

    }

    @Override
    protected void initializePresenter() {

        paintingListPresenter.setView(this);
        paintingListPresenter.loadPaintings();

    }

    @Override
    public void onItemClick(View view, int position) {

        navigator.goToPaintingDetail(getActivity(), paintingListAdapter.getElementAtIndex(position));

    }

    @Override
    public void showLoadingDialog() {

        dialog = Utils.showLoadingDialog(getActivity(), getActivity().getResources().getString(R.string.loading_paints), getCustomFont());


    }

    @Override
    public void hideLoadingDialog() {

        if (dialog != null) {

            dialog.dismiss();

        }

    }

    @Override
    public void setListItems(List<PaintingModel> paintings) {

        paintingListAdapter = new PaintingListAdapter(getActivity().getApplicationContext(), paintings, this, getCustomFont());
        activityPaintingListRecyclerView.setAdapter(paintingListAdapter);
        activityPaintingListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void showGenericErrorMessage() {

        Toast.makeText(getActivity().getApplicationContext(), getActivity().getResources().getString(R.string.activity_painting_list_error_message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErrorMessage(String message) {

        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();

    }
}
