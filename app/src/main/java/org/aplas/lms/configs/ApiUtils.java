package org.aplas.lms.configs;

import android.content.Context;

import org.aplas.lms.interfaces.ApiService;

public class ApiUtils {
    private ApiUtils(){
    };

    public static ApiService getApiService(Context context){
        return ApiClient.getClient(context).create(ApiService.class);
    }
}
