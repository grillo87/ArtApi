package com.grillo.edx.artapi.base;

import android.os.Handler;
import android.os.Looper;

import com.grillo.edx.artapi.domain.executor.PostExecutionThread;

import javax.inject.Inject;

public class UIThread implements PostExecutionThread {

    private final Handler handler;

    @Inject
    public UIThread() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}