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
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.DbManager;

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
public class beiwanglu extends Fragment  {

    public ListView listView;
    bAdapter adapter;
    List<Map<String, Object>> list;
    String today_sdr;
    public beiwanglu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_beiwanglu2, container, false);
        View view= inflater.inflate(R.layout.fragment_beiwanglu2 , container, false);
        List<Map<String, Object>> list=getData();
        listView = (ListView)view.findViewById(R.id.Blist);
        listView.setEmptyView(view.findViewById(R.id.nodata));
        adapter=new bAdapter(getActivity(),R.layout.fragment_beiwanglu2,list);
        listView.setAdapter(adapter);
        Date today= Calendar.getInstance().getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd");
        today_sdr=sdf.format(today);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        DBManger dbManager=new DBManger(getActivity());
        List<beiwangluitem> testlist=dbManager.listAllB();
        Log.i("tag",today_sdr);
        for(beiwangluitem i:testlist) {
            Log.i("tag",i.getBdate());
            if(i.getBdate().equals(today_sdr)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("提示").setMessage("您有一个备忘录待完成" + i.getBdate() + "-" + i.getBcontext()).setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("tag", "i.getBdate()");
                    }
                }).setNegativeButton(null, null);
                builder.create().show();

            }}
    }

    public List<Map<String, Object>> getData(){
        list=new ArrayList<Map<String,Object>>();
        DBManger dbManager=new DBManger(getActivity());
        List<beiwangluitem> testlist=dbManager.listAllB();
        for(beiwangluitem i:testlist){
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("id",i.getId());
            map.put("ItemBeizhu",i.getBcontext());
            map.put("ItemTime",i.getBdate());
            Log.i("tag", i.getBdate());
            list.add(map);}
        return list;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.write2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent config = new Intent(getActivity(), addbeiwanglu.class);
                startActivity(config);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, final int position, long l) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                builder.setTitle("提示").setMessage("请确认是否删除当前备忘录").setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        Map<String ,String> map= (Map<String, String>)listView.getItemAtPosition(position);
                        String B=map.get("ItemBeizhu");
                        TextView title = view.findViewById(R.id.beizhu);
                        String Bx=String.valueOf(title.getText());
                        adapter.notifyDataSetChanged();
                        DBManger dbManager=new DBManger(getActivity());
                        dbManager.deleteB(Bx);
                    }
                }).setNegativeButton("否",null);
                builder.create().show();
            }
        });
}
}
