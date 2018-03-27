package com.ram.umonitor.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.ram.umonitor.R;

import java.util.List;

/**
 * Created by ASUS on 4/17/2017.
 */

public class AssessAdapter extends ArrayAdapter {
    Context context;
    public List<String> modelItems;
    @SuppressWarnings("unchecked")

    public AssessAdapter(Context context, List<String> resource)
    {
        super(context, R.layout.period_assessment_info,resource);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.modelItems = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.period_assessment_info, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.textView1);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);
        EditText et= (EditText) convertView.findViewById(R.id.editText1);
        name.setText(modelItems.get(position));

        return convertView;
    }
}
