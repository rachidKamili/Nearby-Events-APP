package me.kamili.rachid.nearbyeventsapp.view.events;

public class EventsPresenter implements EventsContract.Presenter {

    private EventsContract.View view;


    @Override
    public void attachView(EventsContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
