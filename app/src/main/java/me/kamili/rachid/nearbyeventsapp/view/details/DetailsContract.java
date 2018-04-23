package me.kamili.rachid.nearbyeventsapp.view.details;

import me.kamili.rachid.nearbyeventsapp.model.Event;
import me.kamili.rachid.nearbyeventsapp.model.Organizer;
import me.kamili.rachid.nearbyeventsapp.model.Venue;
import me.kamili.rachid.nearbyeventsapp.view.base.BasePresenter;
import me.kamili.rachid.nearbyeventsapp.view.base.BaseView;

public class DetailsContract {
    interface View extends BaseView {
        void onLoadEvent(Event data);
        void onLoadOrganizer(Organizer data);
        void onLoadVenue(Venue data);
    }

    interface Presenter extends BasePresenter<View> {
        void loadEvent(String eventId);
        void loadOrganizer(String organizerId);
        void loadVenue(String venueId);
    }

}
