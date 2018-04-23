package me.kamili.rachid.nearbyeventsapp.view.events;

import java.util.List;

import me.kamili.rachid.nearbyeventsapp.model.Event;
import me.kamili.rachid.nearbyeventsapp.model.ResponseData;
import me.kamili.rachid.nearbyeventsapp.view.base.BasePresenter;
import me.kamili.rachid.nearbyeventsapp.view.base.BaseView;

public interface EventsContract {
    interface View extends BaseView {
        void onLoadData(ResponseData data, int page);
    }

    interface Presenter extends BasePresenter<View> {
        void loadData(int page);
        List<String> handleFavEvent(Event event);
        List<String> getFavList();
    }
}
