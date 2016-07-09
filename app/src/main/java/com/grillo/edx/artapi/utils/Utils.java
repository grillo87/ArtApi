package com.grillo.edx.artapi.utils;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grillo.edx.artapi.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jose on 09/07/16.
 */
public class Utils {

    public static final String BASE_URL = "http://private-618f4-artapi.apiary-mock.com";
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String CONTENT_TYPE_JSON = "application/json";

    public static Retrofit getRetrofitInstance() {

        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;

    }


    public static Dialog showLoadingDialog(Activity activity, String dialogText) {

        Dialog dialog = new Dialog(activity);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_loading);
        TextView dialogMessage = (TextView) dialog.findViewById(R.id.dialog_loading_text_message);
        dialogMessage.setText(dialogText);

        dialog.show();

        return dialog;


    }


}
