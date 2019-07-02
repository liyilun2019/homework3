package com.example.chapter3.homework;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class myListAdapter extends BaseAdapter {
    String msgName = "Item ";
    Context context;

    public myListAdapter(Context context,String msg) {
        this.context=context;
        msgName=msg;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView v;
        if(convertView==null){
            v=new TextView(context);
        }else{
            v = (TextView) convertView;
        }
        v.setText(msgName+" "+position);
        v.setTextSize(24);
        return v;
    }
}
