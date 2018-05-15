package com.grillo.edx.artapi.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.grillo.edx.artapi.R;
import com.grillo.edx.artapi.base.BaseActivity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jose on 09/07/16.
 */
public class Utils {

    public static final String BASE_URL = "http://private-618f4-artapi.apiary-mock.com";
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CUSTOM_FONT_LOCATION = "fonts/Pacifico.ttf";

    public static Retrofit getRetrofitInstance() {

        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;

    }


    public static Dialog showLoadingDialog(Activity activity, String dialogText, Typeface customTypeFace) {

        Dialog dialog = new Dialog(activity);
        dialog.setCancelable(false);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_loading);
        TextView dialogMessage = (TextView) dialog.findViewById(R.id.dialog_loading_text_message);
        dialogMessage.setText(dialogText);
        dialogMessage.setTypeface(customTypeFace);

        dialog.show();

        return dialog;


    }

    public static void tintStatusBar(BaseActivity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(activity, R.color.bleu_de_france));

        }

    }


    public static void setPortaitOrientation(BaseActivity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

    }


}
