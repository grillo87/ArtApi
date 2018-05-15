package com.grillo.edx.artapi.data.bean;

import java.util.List;

public class ListResponseDto<T> {

    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }


}
