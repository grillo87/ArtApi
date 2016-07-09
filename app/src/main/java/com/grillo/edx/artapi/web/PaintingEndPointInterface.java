package com.grillo.edx.artapi.web;

import com.grillo.edx.artapi.models.EmptyRequest;
import com.grillo.edx.artapi.models.Painting;
import com.grillo.edx.artapi.utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jose on 09/07/16.
 */
public interface PaintingEndPointInterface {

    @POST("getPaintings")
    Call<ArrayList<Painting>> getPaintings(@Header(Utils.CONTENT_TYPE_HEADER) String contentType, @Body EmptyRequest emptyRequest);

}
