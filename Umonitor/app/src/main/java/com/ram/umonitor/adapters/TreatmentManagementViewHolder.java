package com.ram.umonitor.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ram.umonitor.R;

/**
 * Created by ASUS on 9/20/2017.
 */

public class TreatmentManagementViewHolder extends RecyclerView.ViewHolder{
public TextView bedNo;
public TextView shortDesc;



public TreatmentManagementViewHolder(View itemView){
        super(itemView);
        bedNo=(TextView)itemView.findViewById(R.id.bedNoText);
        shortDesc=(TextView)itemView.findViewById(R.id.shortDescText);




        }

        }