package me.kamili.rachid.nearbyeventsapp.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {

    private static final String ACCESS_TOKEN = "BCJDG6MMZXTOEWE4AZLT";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest  = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .build();
        return chain.proceed(newRequest);
    }
}
