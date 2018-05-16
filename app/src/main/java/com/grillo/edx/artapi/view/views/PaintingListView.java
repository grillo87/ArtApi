package com.grillo.edx.artapi.view.views;

import com.grillo.edx.artapi.model.PaintingModel;

import java.util.List;

public interface PaintingListView extends View {

    void showLoadingDialog();

    void hideLoadingDialog();

    void setListItems(List<PaintingModel> paintings);

    void showGenericErrorMessage();

    void showErrorMessage(String message);

}
