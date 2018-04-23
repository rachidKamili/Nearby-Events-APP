package me.kamili.rachid.nearbyeventsapp.view.details;

import me.kamili.rachid.nearbyeventsapp.managers.EventManager;
import me.kamili.rachid.nearbyeventsapp.model.Event;
import me.kamili.rachid.nearbyeventsapp.model.Organizer;
import me.kamili.rachid.nearbyeventsapp.model.Venue;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPresenter implements DetailsContract.Presenter{

    private EventManager mEventManager;
    private DetailsContract.View view;

    public DetailsPresenter(EventManager mEventManager) {
        this.mEventManager = mEventManager;
    }

    @Override
    public void attachView(DetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadEvent(String eventId) {
        mEventManager.createAPI().getEventById(eventId)
                .enqueue(new Callback<Event>() {
                    @Override
                    public void onResponse(Call<Event> call, Response<Event> response) {
                        Event data = response.body();
                        if (data != null) {
                            if (view != null)
                                view.onLoadEvent(data);
                        }
                    }

                    @Override
                    public void onFailure(Call<Event> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadOrganizer(String organizerId) {
        mEventManager.createAPI().getOrganizerById(organizerId)
                .enqueue(new Callback<Organizer>() {
                    @Override
                    public void onResponse(Call<Organizer> call, Response<Organizer> response) {
                        Organizer data = response.body();
                        if (data != null) {
                            if (view != null)
                                view.onLoadOrganizer(data);
                        }
                    }

                    @Override
                    public void onFailure(Call<Organizer> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadVenue(String venueId) {
        mEventManager.createAPI().getVenueById(venueId)
                .enqueue(new Callback<Venue>() {
                    @Override
                    public void onResponse(Call<Venue> call, Response<Venue> response) {
                        Venue data = response.body();
                        if (data != null) {
                            if (view != null)
                                view.onLoadVenue(data);
                        }
                    }

                    @Override
                    public void onFailure(Call<Venue> call, Throwable t) {

                    }
                });
    }
}
