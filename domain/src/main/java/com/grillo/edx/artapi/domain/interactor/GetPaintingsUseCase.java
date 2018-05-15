package com.grillo.edx.artapi.domain.interactor;

import com.grillo.edx.artapi.domain.bean.Painting;
import com.grillo.edx.artapi.domain.exception.ErrorBundle;

import java.util.Collection;

public interface GetPaintingsUseCase extends Interactor {

    interface Callback {
        void onPaintingListLoaded(Collection<Painting> paintingsCollection);

        void onError(ErrorBundle errorBundle);
    }

    void execute(Callback callback);

}
