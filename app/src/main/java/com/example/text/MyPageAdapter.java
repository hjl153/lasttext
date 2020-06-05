package com.example.text;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPageAdapter extends FragmentPagerAdapter {

    public MyPageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new jizhang();
        }else if(position==1){
            return new jihua();
        }else{
            return new beiwanglu();
        }
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "我的记账";
        }else if(position==1){
            return "每日计划";
        }else{
            return "备忘录";
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
