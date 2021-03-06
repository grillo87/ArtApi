package com.grillo.edx.artapi.data.exception;

import android.util.Log;

import com.grillo.edx.artapi.domain.exception.ErrorBundle;

public class RepositoryErrorBundle implements ErrorBundle {

    private final Exception exception;

    public RepositoryErrorBundle(Exception exception) {

        this.exception = exception;

    }

    @Override
    public Exception getException() {
        return this.exception;
    }

    @Override
    public String getErrorMessage() {

        String message = "";

        if (this.exception != null) {

            message = this.exception.getMessage();

        }

        return message;
    }
}
