package com.ram.umonitor.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ram.umonitor.R;

/**
 * Created by ASUS on 9/20/2017.
 */

public class TreatmentManagementNurseViewHolder extends RecyclerView.ViewHolder{
public TextView bedNo;
public TextView shortDesc;
    public Button btnDone;



public TreatmentManagementNurseViewHolder(View itemView){
        super(itemView);
        bedNo=(TextView)itemView.findViewById(R.id.bedNonText);
        shortDesc=(TextView)itemView.findViewById(R.id.shortDescnText);
        btnDone=(Button)itemView.findViewById(R.id.btnDone);




        }

        }