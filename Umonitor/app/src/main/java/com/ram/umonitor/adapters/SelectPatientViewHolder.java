package com.ram.umonitor.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ram.umonitor.R;

/**
 * Created by ASUS on 9/20/2017.
 */

public class SelectPatientViewHolder  extends RecyclerView.ViewHolder{
    public TextView title;
    public TextView shortDesc;

    Button mark;
    Button viewMore;
    public SelectPatientViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.tvLawTitle);
        shortDesc = (TextView) itemView.findViewById(R.id.tvShortDescr);

        mark = (Button) itemView.findViewById(R.id.btnMark);
        viewMore = (Button) itemView.findViewById(R.id.btnView);
    }
}
