package com.grillo.edx.artapi.view.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.model.PaintingModel;
import com.grillo.edx.artapi.view.listener.PaintingListClickInterface;
import com.grillo.edx.artapi.view.holder.PaintViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jose on 09/07/16.
 */
public class PaintingListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<PaintingModel> items;
    private PaintingListClickInterface paintingListClickInterface;
    private Typeface customTypeFace;

    public PaintingListAdapter(Context context, List<PaintingModel> items, PaintingListClickInterface paintingListClickInterface, Typeface customTypeFace) {

        this.items = new ArrayList<PaintingModel>();
        this.items.addAll(items);
        this.context = context;
        this.layoutInflater = LayoutInflater.from(this.context);
        this.paintingListClickInterface = paintingListClickInterface;
        this.customTypeFace = customTypeFace;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.paint_view_holder, parent, false);
        PaintViewHolder holder = new PaintViewHolder(view, this.paintingListClickInterface);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final PaintingModel painting = this.items.get(position);
        PaintViewHolder viewHolder = (PaintViewHolder) holder;

        Glide.with(context).load(painting.getUrl()).asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(viewHolder.getPaintViewHolderImageView());

        viewHolder.getPaintViewHolderTextView().setText(painting.getName());
        viewHolder.getPaintViewHolderTextView().setTypeface(customTypeFace);

    }

    public PaintingModel getElementAtIndex(int position) {

        return this.items.get(position);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
