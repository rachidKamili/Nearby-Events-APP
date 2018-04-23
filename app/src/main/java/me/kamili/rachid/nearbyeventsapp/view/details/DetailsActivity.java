package me.kamili.rachid.nearbyeventsapp.view.details;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.kamili.rachid.nearbyeventsapp.R;
import me.kamili.rachid.nearbyeventsapp.managers.EventManager;
import me.kamili.rachid.nearbyeventsapp.model.Event;
import me.kamili.rachid.nearbyeventsapp.model.Organizer;
import me.kamili.rachid.nearbyeventsapp.model.Venue;

public class DetailsActivity extends AppCompatActivity implements DetailsContract.View {

    @BindView(R.id.ivPhoto)
    ImageView ivPhoto;
    @BindView(R.id.ivMap)
    ImageView ivMap;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvOrganizerName)
    TextView tvOrganizerName;
    @BindView(R.id.tvStartDate)
    TextView tvStartDate;
    @BindView(R.id.tvEndDate)
    TextView tvEndDate;
    @BindView(R.id.tvVenueName)
    TextView tvVenueName;
    @BindView(R.id.tvAddress)
    TextView tvAddress;
    @BindView(R.id.tvEventDesc)
    TextView tvEventDesc;
    @BindView(R.id.tvOrganizerName2)
    TextView tvOrganizerName2;
    @BindView(R.id.tvOrganizerDesc)
    TextView tvOrganizerDesc;

    private DetailsPresenter presenter;
    private String eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        eventId = getIntent().getStringExtra("event_id");
        ButterKnife.bind(this);
        presenter = new DetailsPresenter(new EventManager());
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
        if (eventId != null) {
            presenter.loadEvent(eventId);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadEvent(Event data) {

        Glide.with(this).load(data.getLogo().getOriginal().getUrl()).into(ivPhoto);
        tvName.setText(data.getName().getText());
        tvStartDate.setText(data.getStart().getLocal());
        tvEndDate.setText(data.getEnd().getLocal());
        tvEventDesc.setText(data.getDescription().getText());

        presenter.loadOrganizer(data.getOrganizerId());
        presenter.loadVenue(data.getVenueId());
    }

    @Override
    public void onLoadOrganizer(Organizer data) {
        tvOrganizerName.setText(data.getName());
        tvOrganizerName2.setText(data.getName());
        tvOrganizerDesc.setText(data.getDescription().getText().trim());
    }

    @Override
    public void onLoadVenue(final Venue data) {
        tvVenueName.setText(data.getName());
        tvAddress.setText(data.getAddress().getLocalizedAddressDisplay());

        final String location = data.getLatitude()+","+data.getLongitude();
        String mapUrl = "https://maps.googleapis.com/maps/api/staticmap?center="+location+"&zoom=13&size=1200x500&maptype=roadmap&markers=color:red%7Clabel:%7C"+location;
        Glide.with(this)
                .load(mapUrl)
                .into(ivMap);
        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:"+location+"?q="+data.getAddress().getAddress1());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
