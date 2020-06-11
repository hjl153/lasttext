package com.example.text;


import android.content.Intent;
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
        Button button = (Button) getActivity().findViewById(R.id.tijiao2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plan2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int id = group.getCheckedRadioButtonId();
                        Beizhu=beizhu.getText().toString();
                        Year=year.getText().toString();
                        Month=month.getText().toString();
                        Day=day.getText().toString();
                        Price=price.getText().toString();
                        Shuliang=shuliang.getText().toString();
                        Zname=zname.getText().toString();

                        RadioButton choise = (RadioButton) getActivity().findViewById(id);
                        String output = choise.getText().toString();
                        if (output.equals("jin")) {
                            type = 0;

                        } else if(output.equals("chu")){
                            type = 1;

                        }
                    }		});
                plan3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int id = group.getCheckedRadioButtonId();
                        RadioButton choise = (RadioButton) getActivity().findViewById(id);
                        Mtype = choise.getText().toString();
                    }		});
                if (Year.length() <= 0 && Month.length() <= 0 && Day.length() <= 0&&Price.length() <= 0 &&Shuliang.length() <= 0 &&Zname.length() <= 0 ) {
                    Toast.makeText(getActivity(), "请输入完整", Toast.LENGTH_SHORT).show();
                }
                else{
                    danjia=Float.parseFloat(Price);
                    amount=Integer.parseInt(Shuliang);
                DBManger dbManager = new DBManger(getActivity());
                jizhangitem Zhua=new jizhangitem(Zname,Year+"-"+Month+"-"+Day,danjia,amount,Mtype,Beizhu,type);
                dbManager.addC(Zhua);
                Toast.makeText(getActivity(), "提交完成", Toast.LENGTH_SHORT).show();}

            }
        });

    }
}
