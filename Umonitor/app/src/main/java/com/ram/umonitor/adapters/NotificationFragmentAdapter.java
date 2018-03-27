package com.ram.umonitor.adapters;

import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.ram.umonitor.model.Notification;
import com.ram.umonitor.model.PeriodAssess;

import java.util.List;

/**
 * Created by Ahmed on 6/10/2017.
 */

public class NotificationFragmentAdapter extends FirebaseRecyclerAdapter<Notification,NotificationViewHolder> {
    private List<PeriodAssess> periodAssessList;
    private Context context;

    public NotificationFragmentAdapter(Class<Notification> modelClass, int modelLayout, DatabaseReference ref, Context context) {
        super(modelClass, modelLayout, NotificationViewHolder.class, ref);
        this.context = context;
    }

    @Override
    protected void populateViewHolder(NotificationViewHolder viewHolder, Notification model, int position) {
        viewHolder.title.setText("Bed No:9 :" + model.getTitle());
        viewHolder.shortDesc.setText("Description :" + model.getDesc());


    }

    private Context getContext() {
        return context;
    }

}