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
    JAdapter Learnadapter,Lifeadapter;
    List<Map<String, Object>> learnlist,lifelist;
    String today_sdr;
    int jm=0;
    public jihua() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_beiwanglu2, container, false);
        View view= inflater.inflate(R.layout.fragment_jihua , container, false);
        List<Map<String, Object>> Lifelist=getLifeData(1);
        List<Map<String, Object>> Learnlist=getLearnData(0);
        listViewLearn = (ListView)view.findViewById(R.id.Learn);
        listViewLife= (ListView)view.findViewById(R.id.Life);
        listViewLearn.setEmptyView(view.findViewById(R.id.nodata));
        listViewLife.setEmptyView(view.findViewById(R.id.nodata2));
        Learnadapter=new JAdapter(getActivity(),R.layout.fragment_jihua,Learnlist);
        Lifeadapter=new JAdapter(getActivity(),R.layout.fragment_jihua,Lifelist);
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

    public List<Map<String, Object>> getLearnData(int i) {
        learnlist = new ArrayList<Map<String, Object>>();
        Log.i("tag", "getJdate()");
        DBManger dbManager = new DBManger(getActivity());
        if (i == 0) {
            Log.i("tag", "m.getJdate()");
            List<jihuaitem> testlist = dbManager.listAllJ();
            for (jihuaitem m : testlist) {
                Map<String, Object> map = new HashMap<String, Object>();
                if (m.getJdate().equals(today_sdr) || m.getJleibie() == 0) {
                    map.put("id", m.getId());
                    map.put("Jleibie", m.getJleibie());
                    if(m.getJzhuangtai()==0){
                        map.put("ItemZhuangtai","未完成");}
                    else if(m.getJzhuangtai()==1){
                        map.put("ItemZhuangtai","已完成");}
                    map.put("ItemContext", m.getJcontext());
                    Log.i("tag", m.getJcontext());
                    Log.i("tag", m.getJdate());
                    Log.i("tag", +m.getJleibie() + "");
                    learnlist.add(map);
                }
            }
        }
        return learnlist;
    }
    public List<Map<String, Object>> getLifeData(int i) {
        lifelist = new ArrayList<Map<String, Object>>();
        Log.i("tag", "getJdate()");
        DBManger dbManager = new DBManger(getActivity());
        if (i == 1) {
            Log.i("tag", "m.getJdate()");
            List<jihuaitem> Yestlist = dbManager.listAllJ();
            for (jihuaitem n : Yestlist) {
                Map<String, Object> Map = new HashMap<String, Object>();
                if(n.getJdate().equals(today_sdr)||n.getJleibie()==1){

                    Map.put("id", n.getId());
                    Map.put("Jleibie", n.getJleibie());
                    if(n.getJzhuangtai()==0){
                    Map.put("ItemZhuangtai","未完成");}
                    else if(n.getJzhuangtai()==1){
                        Map.put("ItemZhuangtai","已完成");
                    }
                    Map.put("ItemContext", n.getJcontext());
                    Log.i("tag", n.getJcontext());
                    Log.i("tg", ""+n.getJzhuangtai());
                lifelist.add(Map);}

        }}

        return lifelist;}


    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.write);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent config = new Intent(getActivity(), addjihua.class);
                startActivity(config);
                getActivity().finish();

            }
        });

       listViewLearn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
                if (jm != 1) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setTitle("提示").setMessage("请确认是否设置已完成计划").setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DBManger dbManager=new DBManger(getActivity());


                        if(position==listViewLearn.getCount()-1){
                            jm=jm+1;
                            Map<String ,String> map= (Map<String, String>)listViewLearn.getItemAtPosition(listViewLearn.getCount()-1);
                            dbManager.updateJ(jm,map.get("ItemContext"));
                            Log.i("tag",""+map.get("ItemContext"));
                        }
                        else{
                            Map<String ,String> map= (Map<String, String>)listViewLearn.getItemAtPosition(position);
                            String M=map.get("ItemContext").toString();
                            jm=jm+1;
                            Log.i("jxjncag",""+M);
                            if(M.equals("8尊")){
                                Log.i("ncag",""+M);
                            }
                        dbManager.updateJ(jm,M);
                            Log.i("tag",""+M);}
                    }
                }).setNegativeButton("否",null);
                builder.create().show();
            }}
        });
        listViewLife.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
                if (jm != 1) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setTitle("提示").setMessage("请确认是否设置已完成计划").setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DBManger dbManager=new DBManger(getActivity());
                        if(position==listViewLife.getCount()-1){
                            jm=jm+1;
                            Map<String ,String> map= (Map<String, String>)listViewLife.getItemAtPosition(listViewLife.getCount()-1);
                            dbManager.updateJ(jm,map.get("ItemContext"));
                            Log.i("tag",""+position);
                        }
                        else{
                            jm=jm+1;
                            Map<String ,String> map= (Map<String, String>)listViewLife.getItemAtPosition(position);
                            String M=map.get("ItemContext").toString();
                            dbManager.updateJ(jm,M);
                            Log.i("tag",""+M);}
                        Intent intent=new Intent(getActivity(),zhuyeActivity.class);
                        intent.putExtra("id",1);
                        startActivityForResult(intent,0);
                        getActivity().finish();
                    }

                }).setNegativeButton("否",null);
                builder.create().show();
            }


            }
        });


    }
}
