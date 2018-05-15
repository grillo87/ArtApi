package com.grillo.edx.artapi.domain.executor;

public interface PostExecutionThread {

    void post(Runnable runnable);

}
