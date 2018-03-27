package com.ram.umonitor.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ram.umonitor.R;

/**
 * Created by ASUS on 9/20/2017.
 */

public class PeriodAssessViewHolder extends RecyclerView.ViewHolder{
public TextView bedNo;
public TextView temp;
public TextView satu;
public TextView time;

public PeriodAssessViewHolder(View itemView){
        super(itemView);
        bedNo=(TextView)itemView.findViewById(R.id.bedNoText);
        temp=(TextView)itemView.findViewById(R.id.tempText);
        satu=(TextView)itemView.findViewById(R.id.satuText);
        time=(TextView)itemView.findViewById(R.id.timeText);


        }

        }