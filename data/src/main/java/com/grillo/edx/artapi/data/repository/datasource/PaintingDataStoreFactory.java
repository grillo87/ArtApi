package com.grillo.edx.artapi.data.repository.datasource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PaintingDataStoreFactory {

    private final PaintingDataStore retrofitPaintingDataStore;

    @Inject
    public PaintingDataStoreFactory(PaintingDataStore retrofitPaintingDataStore) {
        this.retrofitPaintingDataStore = retrofitPaintingDataStore;
    }

    public PaintingDataStore create() {
        PaintingDataStore paintingDataStore;
        paintingDataStore = createCloudDataStore();
        return paintingDataStore;
    }

    private PaintingDataStore createCloudDataStore() {
        return retrofitPaintingDataStore;
    }

}
