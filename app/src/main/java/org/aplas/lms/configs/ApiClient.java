package org.aplas.lms.configs;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public static Retrofit getClient(Context context){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okhttpClient(context))
                    .build();
        }

        return retrofit;
    }

    private static OkHttpClient okhttpClient(Context context){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new org.aplas.lms.configs.AuthInterceptor(context)).build();
        return client;
    }
}
