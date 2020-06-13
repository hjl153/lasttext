package com.example.text;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class jihua extends Fragment  {

    public ListView listViewLearn,listViewLife;
    bAdapter Learnadapter,Lifeadapter;
    List<Map<String, Object>> list;
    String today_sdr;
    public jihua() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_beiwanglu2, container, false);
        View view= inflater.inflate(R.layout.fragment_jihua , container, false);
        List<Map<String, Object>> Lifelist=getData(1);
        List<Map<String, Object>> Learnlist=getData(0);
        listViewLearn = (ListView)view.findViewById(R.id.Learn);
        listViewLife= (ListView)view.findViewById(R.id.Life);
        listViewLearn.setEmptyView(view.findViewById(R.id.nodata));
        listViewLife.setEmptyView(view.findViewById(R.id.nodata2));
        Learnadapter=new bAdapter(getActivity(),R.layout.fragment_jihua,Learnlist);
        Lifeadapter=new bAdapter(getActivity(),R.layout.fragment_jihua,Lifelist);
        listViewLearn.setAdapter(Learnadapter);
        listViewLife.setAdapter(Lifeadapter);
        Date today= Calendar.getInstance().getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd");
        today_sdr=sdf.format(today);
        Log.i("tag", today_sdr);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Learnadapter.notifyDataSetChanged();
        Lifeadapter.notifyDataSetChanged();
    }

    public List<Map<String, Object>> getData(int i) {
        list = new ArrayList<Map<String, Object>>();
        list = new ArrayList<Map<String, Object>>();
        DBManger dbManager = new DBManger(getActivity());
        if (i == 0) {
            List<jihuaitem> testlist = dbManager.listAllJSear(i,today_sdr);
            for (jihuaitem m : testlist) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", m.getId());
                map.put("ItemContext", m.getJcontext());
                Log.i("tag", m.getJcontext());
                Log.i("tag", m.getJdate());
                list.add(map);
            }
        } else if (i == 1) {
            List<jihuaitem> testlist = dbManager.listAllJSear(i,today_sdr);
            for (jihuaitem m : testlist) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", m.getId());
                map.put("ItemContext", m.getJcontext());
                Log.i("tag", m.getJcontext());
                list.add(map);
            }
        }
        return list;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.write);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent config = new Intent(getActivity(), addjihua.class);
                startActivity(config);

            }
        });

        listViewLearn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setTitle("提示").setMessage("请确认是否删除当前计划").setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        Map<String, Object> map=list.get(position-1);
                        int M=Integer.parseInt(map.get("id").toString());
                        Learnadapter.notifyDataSetChanged();
                        DBManger dbManager=new DBManger(getActivity());
                        dbManager.deleteJ(M);
                    }
                }).setNegativeButton("否",null);
                builder.create().show();
            }
        });
        listViewLife.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setTitle("提示").setMessage("请确认是否删除当前计划").setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        Map<String, Object> map=list.get(position-1);
                        int M=Integer.parseInt(map.get("id").toString());
                        Learnadapter.notifyDataSetChanged();
                        DBManger dbManager=new DBManger(getActivity());
                        dbManager.deleteJ(M);
                    }
                }).setNegativeButton("否",null);
                builder.create().show();
            }
        });
    }
}
