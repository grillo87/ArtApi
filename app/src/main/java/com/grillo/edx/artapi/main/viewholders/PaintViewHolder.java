package com.grillo.edx.artapi.main.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.main.interfaces.AdapterInterface;

/**
 * Created by jose on 09/07/16.
 */
public class PaintViewHolder extends RecyclerView.ViewHolder {

    private ImageView paintViewHolderImageView;
    private TextView paintViewHolderTextView;


    public PaintViewHolder(View itemView, final AdapterInterface adapterInterface) {
        super(itemView);

        paintViewHolderImageView = (ImageView) itemView.findViewById(R.id.paint_view_holder_image_view);
        paintViewHolderTextView = (TextView) itemView.findViewById(R.id.paint_view_holder_text_view);

        paintViewHolderImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adapterInterface.onItemClick(v, getAdapterPosition());

            }
        });

    }

    public ImageView getPaintViewHolderImageView() {
        return paintViewHolderImageView;
    }

    public void setPaintViewHolderImageView(ImageView paintViewHolderImageView) {
        this.paintViewHolderImageView = paintViewHolderImageView;
    }

    public TextView getPaintViewHolderTextView() {
        return paintViewHolderTextView;
    }

    public void setPaintViewHolderTextView(TextView paintViewHolderTextView) {
        this.paintViewHolderTextView = paintViewHolderTextView;
    }
}
