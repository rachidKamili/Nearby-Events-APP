package me.kamili.rachid.nearbyeventsapp.view.events;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.kamili.rachid.nearbyeventsapp.managers.EventManager;
import me.kamili.rachid.nearbyeventsapp.managers.LocationManager;
import me.kamili.rachid.nearbyeventsapp.managers.PermissionManager;
import me.kamili.rachid.nearbyeventsapp.model.Event;
import me.kamili.rachid.nearbyeventsapp.model.ResponseData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsPresenter implements EventsContract.Presenter, PermissionManager.IPermissionManager, LocationManager.IOnLocationChangesListener {

    private static final int FIRST_PAGE = -10;
    private final String LIST_PREF_KEY = "me.kamili.rachid.favoritList";
    private Context mContext;
    private List<String> favIds = new ArrayList<>();
    private EventManager mEventManager;
    private EventsContract.View view;
    private SharedPreferences mSharedPref;
    private Integer mRadius = 100;

    private PermissionManager permissionManager;
    private LocationManager mLocationManager;
    private Location mLocation;


    public EventsPresenter(EventManager eventManager, Context context) {
        mContext = context;
        mEventManager = eventManager;
        mSharedPref = context.getSharedPreferences(LIST_PREF_KEY, Context.MODE_PRIVATE);
        favIds.addAll(getFavList());
        permissionManager = new PermissionManager(context, this);
        permissionManager.checkPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionManager.checkResult(requestCode, permissions, grantResults);
    }

    @Override
    public void attachView(EventsContract.View view) {
        this.view = view;
    }

    @Override
    public List<String> getFavList() {
        String listString = mSharedPref.getString(LIST_PREF_KEY, "");
        return Arrays.asList(listString.trim().split(","));
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadData(final int page, String search) {
        Map<String, String> resources = new HashMap<>();
        resources.put("q", search);
        resources.put("location.latitude", mLocation.getLatitude()+"");
        resources.put("location.longitude", mLocation.getLongitude()+"");
        resources.put("location.within", mRadius+"mi");

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

    @Override
    public void loadFavData() {

        for (String id : favIds) {
            if (!id.trim().isEmpty()) {
                mEventManager.createAPI().getEventById(id)
                        .enqueue(new Callback<Event>() {
                            @Override
                            public void onResponse(Call<Event> call, Response<Event> response) {
                                Event data = response.body();
                                if (data != null) {
                                    if (view != null)
                                        view.onLoadFavData(data);
                                }
                            }

                            @Override
                            public void onFailure(Call<Event> call, Throwable t) {

                            }
                        });
            }
        }
    }

    public List<String> handleFavEvent(Event event) {
        if (favIds.contains(event.getId())) {
            favIds.remove(event.getId());
        } else {
            favIds.add(event.getId());
        }
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(LIST_PREF_KEY, TextUtils.join(",", favIds));
        editor.apply();
        return favIds;
    }

    @Override
    public void onLocationChanged(Location location) {
        mLocation = location;
        loadData(FIRST_PAGE,"");
    }

    @Override
    public void onPermissionResult(boolean isGranted) {
        if (isGranted) {
            mLocationManager = LocationManager.getInstance(mContext, this);
            mLocationManager.getLocation();
        }
    }

    @Override
    public void setRadius(int radius, String search) {
        mRadius = radius;
        loadData(FIRST_PAGE, search);
    }
}
