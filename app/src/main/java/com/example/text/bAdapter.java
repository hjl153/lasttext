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

public class bAdapter extends ArrayAdapter {
    public bAdapter(@NonNull Context context, int resource, List<Map<String, Object>>  list) {
        super(context, resource,list);
    }
    public View getView(int position, View contentView, ViewGroup parent){
        View itemView=contentView;
        if(itemView==null){
            itemView= LayoutInflater.from(getContext()).inflate(R.layout.activity_beiwanglist,parent,false);
        }
        Map<String,String> map= (Map<String, String>) getItem(position);
        TextView beizhu=itemView.findViewById(R.id.beizhu);
        TextView time=itemView.findViewById(R.id.time);
        beizhu.setText(map.get("ItemBeizhu"));
        time.setText(map.get("ItemTime"));
        return itemView;
    }

}
