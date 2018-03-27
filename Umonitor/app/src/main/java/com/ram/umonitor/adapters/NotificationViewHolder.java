package com.ram.umonitor.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ram.umonitor.R;

/**
 * Created by ASUS on 9/20/2017.
 */

public class NotificationViewHolder extends RecyclerView.ViewHolder{
public TextView title;
public TextView shortDesc;



public NotificationViewHolder(View itemView){
        super(itemView);
        title=(TextView)itemView.findViewById(R.id.bedNonoText);
        shortDesc=(TextView)itemView.findViewById(R.id.shortDescnoText);




        }

        }