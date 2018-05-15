package com.grillo.edx.artapi.domain.executor;

public interface ThreadExecutor {

    void execute(final Runnable runnable);

}
