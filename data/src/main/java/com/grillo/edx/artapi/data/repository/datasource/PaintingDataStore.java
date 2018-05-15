package com.grillo.edx.artapi.data.repository.datasource;

import com.grillo.edx.artapi.domain.bean.Painting;

import java.util.Collection;

public interface PaintingDataStore {

    interface PaintingListCallback {
        void onPaintingListLoaded(Collection<Painting> paintingCollection);

        void onError(Exception exception);
    }

    void getPaintings(PaintingListCallback paintingListCallback);

}
