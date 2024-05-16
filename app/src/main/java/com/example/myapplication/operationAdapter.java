package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class operationAdapter extends ArrayAdapter<operation> {

final  Context ctx;
private int mResource;
    public operationAdapter(@NonNull Context context, int resource, @NonNull ArrayList<operation> objects) {
        super(context, resource, objects);
        this.ctx=context;
        this.mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        convertView = layoutInflater.inflate(mResource,parent,false);
        TextView textView2 =(TextView) convertView.findViewById(R.id.textView2);
        TextView textView3 =(TextView) convertView.findViewById(R.id.textView3);
        textView2.setText(""+getItem(position).getExpression());
        textView3.setText(""+getItem(position).getResultat());
        return convertView;
    }
}
