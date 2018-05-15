package com.grillo.edx.artapi.data.bean;

public class BaseResponseDto<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
