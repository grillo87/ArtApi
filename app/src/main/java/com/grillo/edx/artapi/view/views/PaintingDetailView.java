package com.grillo.edx.artapi.view.views;

import com.grillo.edx.artapi.model.PaintingModel;

public interface PaintingDetailView extends View {

    void setUpPantingElements(PaintingModel paintingModel);

    void showGenericError();

    void setPaintingName(String paintingName);

    void setPaintingAuthorAndYear(String author, String year);

    void setPaintingDescription(String paintingDescription);

    void setPaintingPicture(String paintingPicture);

}
