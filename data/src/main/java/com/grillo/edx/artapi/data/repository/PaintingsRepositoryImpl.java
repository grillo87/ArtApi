package com.grillo.edx.artapi.data.repository;

import com.grillo.edx.artapi.data.exception.RepositoryErrorBundle;
import com.grillo.edx.artapi.data.repository.datasource.PaintingDataStore;
import com.grillo.edx.artapi.data.repository.datasource.PaintingDataStoreFactory;
import com.grillo.edx.artapi.domain.bean.Painting;
import com.grillo.edx.artapi.domain.callback.PaintingListCallback;
import com.grillo.edx.artapi.domain.repository.PaintingRepository;

import java.util.Collection;

import javax.inject.Inject;

public class PaintingsRepositoryImpl implements PaintingRepository {

    private final PaintingDataStoreFactory paintingDataStoreFactory;

    @Inject
    public PaintingsRepositoryImpl(PaintingDataStoreFactory paintingDataStoreFactory) {
        this.paintingDataStoreFactory = paintingDataStoreFactory;
    }

    @Override
    public void getPaintings(final PaintingListCallback paintingListCallback) {
        PaintingDataStore remotePaintingDataStore = paintingDataStoreFactory.create();
        remotePaintingDataStore.getPaintings(new PaintingDataStore.PaintingListCallback() {
            @Override
            public void onPaintingListLoaded(Collection<Painting> paintingCollection) {
                paintingListCallback.onPaintingsLoaded(paintingCollection);
            }

            @Override
            public void onError(Exception exception) {
                paintingListCallback.onError(new RepositoryErrorBundle(exception));
            }
        });
    }
}
