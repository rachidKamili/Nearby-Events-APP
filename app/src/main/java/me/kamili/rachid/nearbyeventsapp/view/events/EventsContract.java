package me.kamili.rachid.nearbyeventsapp.view.events;

import android.support.annotation.NonNull;

import java.util.List;

import me.kamili.rachid.nearbyeventsapp.model.Event;
import me.kamili.rachid.nearbyeventsapp.model.ResponseData;
import me.kamili.rachid.nearbyeventsapp.view.base.BasePresenter;
import me.kamili.rachid.nearbyeventsapp.view.base.BaseView;

public interface EventsContract {
    interface View extends BaseView {
        void onLoadData(ResponseData data, int page);
        void onLoadFavData(Event data);
    }

    interface Presenter extends BasePresenter<View> {
        void loadData(int page, String search);
        void loadFavData();
        List<String> handleFavEvent(Event event);
        List<String> getFavList();
        void setRadius(int radius, String search);
        void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);
    }
}
