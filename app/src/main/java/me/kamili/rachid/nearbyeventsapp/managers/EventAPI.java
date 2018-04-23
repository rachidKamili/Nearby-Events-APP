package me.kamili.rachid.nearbyeventsapp.managers;

import java.util.Map;

import me.kamili.rachid.nearbyeventsapp.model.Event;
import me.kamili.rachid.nearbyeventsapp.model.Organizer;
import me.kamili.rachid.nearbyeventsapp.model.ResponseData;
import me.kamili.rachid.nearbyeventsapp.model.Venue;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface EventAPI {

    @GET("/v3/events/search")
    Call<ResponseData> getEvents(@QueryMap Map<String, String> options);

    @GET("/v3/events/{id}")
    Call<Event> getEventById(@Path("id") String id);

    @GET("/v3/organizers/{id}")
    Call<Organizer> getOrganizerById(@Path("id") String id);

    @GET("/v3/venues/{id}")
    Call<Venue> getVenueById(@Path("id") String id);
}
