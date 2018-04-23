package me.kamili.rachid.nearbyeventsapp.view.events;

import me.kamili.rachid.nearbyeventsapp.model.ResponseData;
import me.kamili.rachid.nearbyeventsapp.view.base.BasePresenter;
import me.kamili.rachid.nearbyeventsapp.view.base.BaseView;

public interface EventsContract {
    interface View extends BaseView {
        void onLoadData(ResponseData data, int page);
    }

    interface Presenter extends BasePresenter<View> {
        void loadData(int page);
    }
}
