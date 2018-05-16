package com.grillo.edx.artapi.presenter;

import android.util.Log;

import com.grillo.edx.artapi.domain.bean.Painting;
import com.grillo.edx.artapi.domain.exception.ErrorBundle;
import com.grillo.edx.artapi.domain.interactor.GetPaintingsUseCase;
import com.grillo.edx.artapi.injector.PerActivity;
import com.grillo.edx.artapi.model.PaintingModel;
import com.grillo.edx.artapi.model.mapper.PaintingModelMapper;
import com.grillo.edx.artapi.view.views.PaintingListView;
import com.grillo.edx.artapi.view.views.View;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

@PerActivity
public class PaintingListPresenter implements Presenter {

    private PaintingListView paintingListView;
    private final GetPaintingsUseCase getPaintingsUseCase;
    private final PaintingModelMapper paintingModelMapper;
    private List<PaintingModel> models;

    @Inject
    public PaintingListPresenter(GetPaintingsUseCase getPaintingsUseCase, PaintingModelMapper paintingModelMapper) {
        this.getPaintingsUseCase = getPaintingsUseCase;
        this.paintingModelMapper = paintingModelMapper;
    }

    @Override
    public void setView(View view) {

        this.paintingListView = (PaintingListView) view;

    }

    public void loadPaintings() {

        paintingListView.showLoadingDialog();
        getPaintingsUseCase.execute(new GetPaintingsUseCase.Callback() {
            @Override
            public void onPaintingListLoaded(Collection<Painting> paintingsCollection) {

                models = paintingModelMapper.toModel(paintingsCollection);
                setModels();
            }

            @Override
            public void onError(ErrorBundle errorBundle) {

                if (errorBundle != null) {

                    if (errorBundle.getErrorMessage() != null) {

                        showMessage(errorBundle.getErrorMessage());

                    } else {

                        showMessage();

                    }

                } else {

                    showMessage();

                }
            }
        });
    }

    private void setModels() {
        paintingListView.setListItems(models);
        paintingListView.hideLoadingDialog();
    }

    private void showMessage(String message) {
        paintingListView.hideLoadingDialog();
        paintingListView.showErrorMessage(message);
    }

    private void showMessage() {
        paintingListView.hideLoadingDialog();
        paintingListView.showGenericErrorMessage();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
