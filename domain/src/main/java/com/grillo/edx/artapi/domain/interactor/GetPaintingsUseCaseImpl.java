package com.grillo.edx.artapi.domain.interactor;

import com.grillo.edx.artapi.domain.bean.Painting;
import com.grillo.edx.artapi.domain.callback.PaintingListCallback;
import com.grillo.edx.artapi.domain.exception.ErrorBundle;
import com.grillo.edx.artapi.domain.executor.PostExecutionThread;
import com.grillo.edx.artapi.domain.executor.ThreadExecutor;
import com.grillo.edx.artapi.domain.repository.PaintingRepository;

import java.util.Collection;

import javax.inject.Inject;

public class GetPaintingsUseCaseImpl implements GetPaintingsUseCase {

    private final PaintingRepository paintingsRepository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    private Callback callback;


    @Inject
    public GetPaintingsUseCaseImpl(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                                   PaintingRepository paintingsRepository) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        this.paintingsRepository = paintingsRepository;
    }

    @Override
    public void execute(Callback callback) {

        this.callback = callback;
        this.threadExecutor.execute(this);

    }

    @Override
    public void run() {

        this.paintingsRepository.getPaintings(new PaintingListCallback() {
            @Override
            public void onPaintingsLoaded(Collection<Painting> paintingCollection) {
                notifyLoaded(paintingCollection);
            }

            @Override
            public void onError(ErrorBundle errorBundle) {
                notifyError(errorBundle);
            }
        });

    }


    private void notifyLoaded(final Collection<Painting> paintingsCollection) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onPaintingListLoaded(paintingsCollection);
            }
        });
    }

    private void notifyError(final ErrorBundle errorBundle) {
        this.postExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onError(errorBundle);
            }
        });
    }
}
