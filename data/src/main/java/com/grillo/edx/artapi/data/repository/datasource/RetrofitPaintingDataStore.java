package com.grillo.edx.artapi.data.repository.datasource;

import com.grillo.edx.artapi.data.bean.PaintingsResponseDto;
import com.grillo.edx.artapi.data.bean.mapper.PaintingsResponseDtoMapper;
import com.grillo.edx.artapi.data.exception.PaintingsNotFoundException;
import com.grillo.edx.artapi.data.net.PaintingApiService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitPaintingDataStore implements PaintingDataStore {

    private PaintingApiService paintingApiService;
    private PaintingsResponseDtoMapper paintingsResponseDtoMapper;

    @Inject
    public RetrofitPaintingDataStore(PaintingApiService paintingApiService, PaintingsResponseDtoMapper paintingsResponseDtoMapper) {
        this.paintingApiService = paintingApiService;
        this.paintingsResponseDtoMapper = paintingsResponseDtoMapper;
    }

    @Override
    public void getPaintings(final PaintingListCallback paintingListCallback) {

        Call<PaintingsResponseDto> call = paintingApiService.getPaintings();
        call.enqueue(new Callback<PaintingsResponseDto>() {
            @Override
            public void onResponse(Call<PaintingsResponseDto> call, Response<PaintingsResponseDto> response) {
                if (response != null) {
                    paintingListCallback.onPaintingListLoaded(paintingsResponseDtoMapper.toBusinessObjects(response.body()));
                } else {
                    paintingListCallback.onError(new PaintingsNotFoundException());
                }
            }

            @Override
            public void onFailure(Call<PaintingsResponseDto> call, Throwable t) {
                paintingListCallback.onError(new PaintingsNotFoundException(t.getMessage()));
            }
        });
    }

}

