package com.grillo.edx.artapi.presenter;

import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.domain.interactor.GetPaintingsUseCase;
import com.grillo.edx.artapi.injector.PerActivity;
import com.grillo.edx.artapi.model.PaintingModel;
import com.grillo.edx.artapi.model.mapper.PaintingModelMapper;
import com.grillo.edx.artapi.view.views.PaintingDetailView;
import com.grillo.edx.artapi.view.views.View;

import javax.inject.Inject;

@PerActivity
public class PaintingDetailPresenter implements Presenter {

    private PaintingDetailView paintingDetailView;

    @Inject
    public PaintingDetailPresenter() {
    }

    @Override
    public void setView(View view) {

        this.paintingDetailView = (PaintingDetailView) view;

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

    private boolean validateModelPainting(PaintingModel paintingModel) {

        boolean result = true;

        if ((paintingModel == null) || (paintingModel.getName() == null) || (paintingModel.getAuthor() == null) || (paintingModel.getYear() == null) || (paintingModel.getDescription() == null) || (paintingModel.getUrl() == null)) {

            result = false;

        }

        return result;

    }

    public void setPaintingElements(PaintingModel paintingModel) {

        if (validateModelPainting(paintingModel)) {

            paintingDetailView.setPaintingPicture(paintingModel.getUrl());
            paintingDetailView.setPaintingName(paintingModel.getName());
            paintingDetailView.setPaintingAuthorAndYear(paintingModel.getAuthor(), paintingModel.getYear());
            paintingDetailView.setPaintingDescription(paintingModel.getDescription());

        } else {

            paintingDetailView.showGenericError();

        }


    }

}
