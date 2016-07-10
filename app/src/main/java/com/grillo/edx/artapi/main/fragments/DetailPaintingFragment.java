package com.grillo.edx.artapi.main.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.main.activity.MainActivity;
import com.grillo.edx.artapi.models.Painting;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailPaintingFragment extends Fragment {

    public static final String LOG_TAG = "DetailPaintingFragment";
    private Painting painting;
    private MainActivity activity;
    private ImageView fragmentDetailPaintingImageView;
    private TextView fragmentDetailPaintingTextView;
    private TextView fragmentDetailPaintingAuthorTextView;
    private TextView fragmentDetailPaintingDetailTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail_painting, container, false);

        activity = (MainActivity) getActivity();
        painting = activity.painting;

        fragmentDetailPaintingImageView = (ImageView) rootView.findViewById(R.id.fragment_detail_painting_image_view);
        fragmentDetailPaintingTextView = (TextView) rootView.findViewById(R.id.fragment_detail_painting_text_view);
        fragmentDetailPaintingAuthorTextView = (TextView) rootView.findViewById(R.id.fragment_detail_painting_author_text_view);
        fragmentDetailPaintingDetailTextView = (TextView) rootView.findViewById(R.id.fragment_detail_painting_detail_text_view);

        Glide.with(activity.getApplicationContext()).load(painting.getUrl()).asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(fragmentDetailPaintingImageView);

        fragmentDetailPaintingTextView.setText(painting.getName());
        fragmentDetailPaintingTextView.setTypeface(activity.openSansLight);

        String fragmentDetailPaintingAuthorYearFormatString = painting.getAuthor() + " " + String.format(getString(R.string.fragment_detail_painting_year_format), painting.getYear());
        fragmentDetailPaintingAuthorTextView.setText(fragmentDetailPaintingAuthorYearFormatString);
        fragmentDetailPaintingAuthorTextView.setTypeface(activity.openSansLight);

        fragmentDetailPaintingDetailTextView.setText(painting.getDescription());
        fragmentDetailPaintingDetailTextView.setTypeface(activity.openSansLight);


        return rootView;
    }

}
