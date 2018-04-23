package me.kamili.rachid.nearbyeventsapp.view.events;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.kamili.rachid.nearbyeventsapp.managers.EventManager;
import me.kamili.rachid.nearbyeventsapp.model.Event;
import me.kamili.rachid.nearbyeventsapp.model.ResponseData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsPresenter implements EventsContract.Presenter {

    private static final int FIRST_PAGE = -10;
    private List<String> favIds = new ArrayList<>();
    private EventManager mEventManager;

    private EventsContract.View view;
    private final String LIST_PREF_KEY = "me.kamili.rachid.favoritList";
    private SharedPreferences mSharedPref;

    public EventsPresenter(EventManager mEventManager, Context context) {
        this.mEventManager = mEventManager;
        mSharedPref = context.getSharedPreferences(LIST_PREF_KEY, Context.MODE_PRIVATE);
        favIds.addAll(getFavList());

    }

    @Override
    public void attachView(EventsContract.View view) {
        this.view = view;
        loadData(FIRST_PAGE);
    }

    @Override
    public List<String> getFavList() {
        String listString = mSharedPref.getString(LIST_PREF_KEY,"");
        return Arrays.asList(listString.trim().split(","));
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadData(final int page) {
        Map<String, String> resources = new HashMap<>();
        resources.put("q", "html+css+js");

        if (page != FIRST_PAGE) {
            resources.put("page", String.valueOf(page));
        }

        mEventManager.createAPI().getEvents(resources)
                .enqueue(new Callback<ResponseData>() {
                    @Override
                    public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                        ResponseData data = response.body();
                        if (data != null) {
                            if (view != null)
                                view.onLoadData(data, page);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseData> call, Throwable t) {

                    }
                });
    }

    public List<String> handleFavEvent(Event event) {
        if (favIds.contains(event.getId()) ){
            favIds.remove(event.getId());
        }else{
            favIds.add(event.getId());
        }
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(LIST_PREF_KEY, TextUtils.join(",", favIds));
        editor.apply();
        return favIds;
    }
}
