package me.kamili.rachid.nearbyeventsapp.managers;

import java.util.Map;

import me.kamili.rachid.nearbyeventsapp.model.ResponseData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface EventAPI {

    @GET("/v3/events/search")
    Call<ResponseData> getEvents(@QueryMap Map<String, String> options);
}
