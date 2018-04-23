package me.kamili.rachid.nearbyeventsapp.view.events;

import java.util.HashMap;
import java.util.Map;

import me.kamili.rachid.nearbyeventsapp.managers.EventManager;
import me.kamili.rachid.nearbyeventsapp.model.ResponseData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsPresenter implements EventsContract.Presenter {

    private static final int FIRST_PAGE = -10;

    private EventManager mEventManager;

    private EventsContract.View view;

    public EventsPresenter(EventManager mEventManager) {
        this.mEventManager = mEventManager;
    }

    @Override
    public void attachView(EventsContract.View view) {
        this.view = view;

        loadData(FIRST_PAGE);
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
}
