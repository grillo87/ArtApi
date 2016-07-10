package com.grillo.edx.artapi.main.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.main.interfaces.AdapterInterface;
import com.grillo.edx.artapi.main.viewholders.PaintViewHolder;
import com.grillo.edx.artapi.models.Painting;

import java.util.ArrayList;

/**
 * Created by jose on 09/07/16.
 */
public class PaintingListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Painting> items;
    private AdapterInterface adapterInterface;
    private Typeface customTypeFace;

    public PaintingListAdapter(Context context, ArrayList<Painting> items, AdapterInterface adapterInterface, Typeface customTypeFace) {

        this.items = items;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(this.context);
        this.adapterInterface = adapterInterface;
        this.customTypeFace = customTypeFace;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.paint_view_holder, parent, false);
        PaintViewHolder holder = new PaintViewHolder(view, this.adapterInterface);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final Painting painting = this.items.get(position);
        PaintViewHolder viewHolder = (PaintViewHolder) holder;

        Glide.with(context).load(painting.getUrl()).asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(viewHolder.getPaintViewHolderImageView());

        viewHolder.getPaintViewHolderTextView().setText(painting.getName());
        viewHolder.getPaintViewHolderTextView().setTypeface(customTypeFace);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
