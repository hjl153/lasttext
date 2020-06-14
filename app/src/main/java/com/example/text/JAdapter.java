package com.example.text;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JAdapter extends ArrayAdapter {
    public JAdapter(@NonNull Context context, int resource, List<Map<String, Object>>  list) {
        super(context, resource,list);
    }
    public View getView(int position, View contentView, ViewGroup parent){
        View itemView=contentView;
        if(itemView==null){
            itemView= LayoutInflater.from(getContext()).inflate(R.layout.activity_jihualist,parent,false);
        }
        Map<String,String> map= (Map<String, String>) getItem(position);
        TextView beizhu=itemView.findViewById(R.id.context);
        beizhu.setText(map.get("ItemContext"));
        return itemView;
    }

}
