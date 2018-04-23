package me.kamili.rachid.nearbyeventsapp.managers;

import me.kamili.rachid.nearbyeventsapp.utils.TokenInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventManager {

    private static final String API_BASE_URL = "https://www.eventbriteapi.com";

    private OkHttpClient httpClient;

    public EventManager() {
        httpClient = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor())
                .build();
    }

    public EventAPI createAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(getAPIBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EventAPI.class);
    }

    public String getAPIBaseUrl() {
        return API_BASE_URL;
    }
}