package me.kamili.rachid.nearbyeventsapp.view.events;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.kamili.rachid.nearbyeventsapp.adapters.EventAdapter;
import me.kamili.rachid.nearbyeventsapp.R;
import me.kamili.rachid.nearbyeventsapp.managers.EventManager;
import me.kamili.rachid.nearbyeventsapp.model.Event;
import me.kamili.rachid.nearbyeventsapp.model.Pagination;
import me.kamili.rachid.nearbyeventsapp.model.ResponseData;

public class EventsActivity extends AppCompatActivity implements EventsContract.View {

    private static final int FIRST_PAGE = -10;
    @BindView(R.id.btnLoadMore)
    Button btnLoadMore;
    @BindView(R.id.rvEvents)
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Event> myDataset = new ArrayList<>();
    private Pagination mPagination;

    private EventsPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        ButterKnife.bind(this);
        initRecycler();
        presenter = new EventsPresenter(new EventManager());
    }

    private void initRecycler() {

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }
        else{
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        }

        mAdapter = new EventAdapter(this,myDataset);
        mRecyclerView.setAdapter(mAdapter);
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

    public void onLoadMoreEvents(View view) {
        presenter.loadData(mPagination.getPageNumber()+1);
    }

    @Override
    public void onLoadData(ResponseData data, int page) {
            mPagination = data.getPagination();
            if (mPagination.isHasMoreItems())
                btnLoadMore.setVisibility(View.VISIBLE);
            else
                btnLoadMore.setVisibility(View.GONE);

            if (page == FIRST_PAGE)
                myDataset.clear();

            myDataset.addAll(data.getEvents());
            mAdapter.notifyDataSetChanged();
    }
}