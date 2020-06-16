package com.example.text;


import android.content.Intent;
import android.icu.util.Output;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class jizhang extends Fragment {
   EditText beizhu,year,month,day,price,shuliang,zname;
   RadioGroup plan2,plan3;
   int type=0,amount=0;
   String Mtype="",Beizhu="",Year="",Month="",Day="",Price="",Shuliang="",Zname="";
   Float danjia=0.0f;

    public jizhang() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jizhang2, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        beizhu = getActivity().findViewById(R.id.beizhu3);
        year = getActivity().findViewById(R.id.year2);
        month = getActivity().findViewById(R.id.month2);
        day = getActivity().findViewById(R.id.day2);
        price = getActivity().findViewById(R.id.price);
        shuliang = getActivity().findViewById(R.id.shuliang);
        zname = getActivity().findViewById(R.id.zname);
        plan3= (RadioGroup)getActivity(). findViewById(R.id.plan3);
        plan2= (RadioGroup)getActivity(). findViewById(R.id.plan2);
        Button button2 = (Button) getActivity().findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent config = new Intent(getActivity(), seezhangdan.class);
                startActivity(config);

            }
        });
        Button button = (Button) getActivity().findViewById(R.id.tijiao2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Beizhu=beizhu.getText().toString();
                        Year=year.getText().toString();
                        Month=month.getText().toString();
                        Day=day.getText().toString();
                        Price=price.getText().toString();
                        Shuliang=shuliang.getText().toString();
                        Zname=zname.getText().toString();
                for(int i = 0 ;i < plan2.getChildCount();i++){
                        RadioButton rb = (RadioButton)plan2.getChildAt(i);
                        String output;
                        if(rb.isChecked()){
                            output = rb.getText().toString();
                            Log.i("tag", output);
                            if (output.equals("进账")) {
                                type = 1;
                                Log.i("tag", +type+"写入据完毕");
                            } else if(output.equals("出账")){
                                type = 0;
                                Log.i("tag", +type+"写入数完毕");
                            }}}
                       for(int i = 0 ;i < plan3.getChildCount();i++){
                            RadioButton Rb = (RadioButton)plan3.getChildAt(i);
                            if(Rb.isChecked()) {
                                Mtype = Rb.getText().toString();
                            }}
                if (Year.length() <= 0 && Month.length() <= 0 && Day.length() <= 0&&Price.length() <= 0 &&Shuliang.length() <= 0 &&Zname.length() <= 0 ) {
                    Toast.makeText(getActivity(), "请输入完整", Toast.LENGTH_SHORT).show();
                }
                else{
                    danjia=Float.parseFloat(Price);
                    amount=Integer.parseInt(Shuliang);
                DBManger dbManager = new DBManger(getActivity());
                jizhangitem Zhua=new jizhangitem(Zname,Year+"_"+Month+"_"+Day,danjia,amount,Mtype,Beizhu,type);
                    Log.i("tag", +type+Zname+Year+danjia+amount+Mtype+Beizhu);
                dbManager.addC(Zhua);
                Toast.makeText(getActivity(), "提交完成", Toast.LENGTH_SHORT).show();}

            }


    });
}}
