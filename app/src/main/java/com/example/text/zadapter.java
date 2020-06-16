package com.example.text;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.text.R;

import java.util.List;
import java.util.Map;

public class zadapter extends ArrayAdapter {
    public zadapter(@NonNull Context context, int resource, List<Map<String, Object>> list) {
        super(context, resource,list);
    }
    public View getView(int position, View contentView, ViewGroup parent){
        View itemView=contentView;
        if(itemView==null){
            itemView= LayoutInflater.from(getContext()).inflate(R.layout.activity_jizhanglist,parent,false);
        }
        Map<String,String> map= (Map<String, String>) getItem(position);
        TextView money=itemView.findViewById(R.id.money);
        TextView detail=itemView.findViewById(R.id.detail);
        TextView time=itemView.findViewById(R.id.time);
        money.setText(String.valueOf(map.get("ItemMoney")));
        time.setText(map.get("ItemTime"));
        detail.setText(map.get("ItemDetail"));
        return itemView;
    }

}

