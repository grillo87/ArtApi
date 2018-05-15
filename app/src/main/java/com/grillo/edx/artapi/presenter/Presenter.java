package com.grillo.edx.artapi.presenter;

import com.grillo.edx.artapi.view.views.View;

public interface Presenter {

    void setView(View view);

    void resume();

    void pause();

    void destroy();


}
