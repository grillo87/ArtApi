package com.grillo.edx.artapi.domain.callback;

import com.grillo.edx.artapi.domain.bean.Painting;
import com.grillo.edx.artapi.domain.exception.ErrorBundle;

import java.util.Collection;

public interface PaintingListCallback {

    void onPaintingsLoaded(Collection<Painting> paintingCollection);

    void onError(ErrorBundle errorBundle);

}
