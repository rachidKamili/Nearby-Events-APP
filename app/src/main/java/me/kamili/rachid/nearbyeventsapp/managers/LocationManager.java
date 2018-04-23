package me.kamili.rachid.nearbyeventsapp.managers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class LocationManager {
    private static LocationManager instance;
    private Context mContext;
    private IOnLocationChangesListener listener;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;

    @SuppressLint("MissingPermission")
    private LocationManager(Context context, Object obj) {
        this.mContext = context;
        this.listener = (IOnLocationChangesListener) obj;
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(mContext);

        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    // Update UI with location data
                    // ...
                    listener.onLocationChanged(location);
                    Log.d("onSuccess", "onSuccess: " + location.toString());
                }
            }
        };
    }
    @SuppressLint("MissingPermission")
    public void getLocation() {
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener((Activity) mContext, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            listener.onLocationChanged(location);
                            Log.d("onSuccess", "onSuccess: " + location.toString());
                        }
                    }
                });
    }

    public static LocationManager getInstance(Context context,Object object) {
        if (instance == null)
            instance = new LocationManager(context, object);
        return instance;
    }

    public interface IOnLocationChangesListener {
        void onLocationChanged(Location location);
    }
}
