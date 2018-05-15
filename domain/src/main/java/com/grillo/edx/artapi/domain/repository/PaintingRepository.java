package com.grillo.edx.artapi.domain.repository;

import com.grillo.edx.artapi.domain.callback.PaintingListCallback;

public interface PaintingRepository {

    void getPaintings(PaintingListCallback paintingListCallback);

}
