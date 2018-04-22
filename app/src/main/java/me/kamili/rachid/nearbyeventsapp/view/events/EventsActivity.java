package me.kamili.rachid.nearbyeventsapp.view.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import me.kamili.rachid.nearbyeventsapp.R;

public class EventsActivity extends AppCompatActivity implements EventsContract.View{

    private EventsPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
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
}
