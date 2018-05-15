package com.grillo.edx.artapi.data.net;

import com.grillo.edx.artapi.data.bean.PaintingsResponseDto;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jose on 09/07/16.
 */
public interface PaintingApiService {

    @GET("paintings")
    Call<PaintingsResponseDto> getPaintings();

}
