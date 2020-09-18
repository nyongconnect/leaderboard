package com.nyongconnect.leaderboard.services;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicesBuilder {
    private static final String URL = "https://gadsapi.herokuapp.com/api/";
    private static final String URL2 = "https://docs.google.com/forms/d/e/";
    private static HttpLoggingInterceptor logger = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder okBuilder = new OkHttpClient.Builder().addInterceptor(logger);
    private static Retrofit.Builder sBuilder =new Retrofit.Builder()
            .baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
            .client(okBuilder.build());
    private static Retrofit.Builder myBuilder =new Retrofit.Builder()
            .baseUrl(URL2).addConverterFactory(GsonConverterFactory.create())
            .client(okBuilder.build());

    private static Retrofit sRetrofit = sBuilder.build();
    private static Retrofit myRetrofit =myBuilder.build();
    public static <S> S buildService(Class<S> serviceType){
        return sRetrofit.create(serviceType);
    }
    public static <S> S buildMyService(Class<S> serviceType){
        return myRetrofit.create(serviceType);
    }
}
