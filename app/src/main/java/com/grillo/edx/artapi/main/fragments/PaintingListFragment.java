package com.grillo.edx.artapi.main.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.main.activity.MainActivity;
import com.grillo.edx.artapi.main.adapters.PaintingListAdapter;
import com.grillo.edx.artapi.main.interfaces.AdapterInterface;
import com.grillo.edx.artapi.models.EmptyRequest;
import com.grillo.edx.artapi.models.Painting;
import com.grillo.edx.artapi.utils.Utils;
import com.grillo.edx.artapi.web.PaintingEndPointInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaintingListFragment extends Fragment implements AdapterInterface, Callback<ArrayList<Painting>> {

    public static final String LOG_TAG = "PaintingListFragment";
    private RecyclerView fragmentPaintingListRecyclerView;
    private PaintingListAdapter paintingListAdapter;
    private PaintingListFragment paintingListFragment;
    private ArrayList<Painting> paintings;
    private MainActivity activity;
    private Retrofit retrofit;
    private PaintingListFragment fragment;
    private Dialog dialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_painting_list, container, false);

        fragmentPaintingListRecyclerView = (RecyclerView) rootview.findViewById(R.id.fragment_painting_list_recycler_view);
        activity = (MainActivity) getActivity();
        fragment = this;

        dialog = Utils.showLoadingDialog(activity, activity.getResources().getString(R.string.loading_paints), activity.customTypeFace);
        retrofit = Utils.getRetrofitInstance();
        PaintingEndPointInterface paintingEndPointInterface = retrofit.create(PaintingEndPointInterface.class);

        Call<ArrayList<Painting>> call = paintingEndPointInterface.getPaintings(Utils.CONTENT_TYPE_JSON, new EmptyRequest());
        call.enqueue(this);

        return rootview;
    }

    @Override
    public void onItemClick(View view, int position) {

        activity.painting = paintings.get(position);
        activity.displayViewAnimation(MainActivity.DETAIL_PAINTING_LAYOUT);


    }

    @Override
    public void onResponse(Call<ArrayList<Painting>> call, Response<ArrayList<Painting>> response) {

        dialog.dismiss();
        paintings = response.body();

        paintingListAdapter = new PaintingListAdapter(activity.getApplicationContext(), paintings, fragment, activity.customTypeFace);
        fragmentPaintingListRecyclerView.setAdapter(paintingListAdapter);
        fragmentPaintingListRecyclerView.setLayoutManager(new LinearLayoutManager(activity));

    }

    @Override
    public void onFailure(Call<ArrayList<Painting>> call, Throwable t) {

        paintingListAdapter = new PaintingListAdapter(activity.getApplicationContext(), new ArrayList<Painting>(), fragment, activity.customTypeFace);
        fragmentPaintingListRecyclerView.setAdapter(paintingListAdapter);
        fragmentPaintingListRecyclerView.setLayoutManager(new LinearLayoutManager(activity));

    }
}
