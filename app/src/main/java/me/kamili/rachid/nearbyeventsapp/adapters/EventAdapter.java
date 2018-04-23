package me.kamili.rachid.nearbyeventsapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.kamili.rachid.nearbyeventsapp.R;
import me.kamili.rachid.nearbyeventsapp.model.Event;
import me.kamili.rachid.nearbyeventsapp.utils.DateConverter;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private Context mContext;
    private List<Event> mDataset;

    public EventAdapter(Context context, List<Event> myDataset) {
        this.mDataset = myDataset;
        this.mContext = context;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_event, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event data = mDataset.get(position);

        holder.tvDay.setText(DateConverter.toDay(data.getStart().getUtc()));
        holder.tvMonth.setText(DateConverter.toMonthName3L(data.getStart().getUtc()));
        holder.tvEventName.setText(data.getName().getText());
        holder.tvLocation.setText(data.getCurrency());
        holder.tvOn.setText("on EventBrite");

        Glide.with(mContext)
                .load(data.getLogo().getUrl())
                .apply(new RequestOptions().override(585,260))
                .into(holder.ivImage);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvDay)
        public TextView tvDay;
        @BindView(R.id.tvMonth)
        public TextView tvMonth;
        @BindView(R.id.tvEventName)
        public TextView tvEventName;
        @BindView(R.id.tvLocation)
        public TextView tvLocation;
        @BindView(R.id.tvOn)
        public TextView tvOn;
        @BindView(R.id.ivImage)
        public ImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}