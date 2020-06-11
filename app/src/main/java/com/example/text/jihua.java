package com.example.text;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class jihua extends Fragment {


    public jihua() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jihua, container, false);
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.write);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent config = new Intent(getActivity(), addjihua.class);
                    startActivity(config);
                    Log.i("tag", "写入数据完毕");

            }
        });

    }
}
