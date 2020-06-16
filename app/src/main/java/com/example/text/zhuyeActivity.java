package com.example.text;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class zhuyeActivity extends AppCompatActivity {
    TabLayout tabLayout;
    MyPageAdapter pageAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuye);
         viewPager = findViewById(R.id.viewpager);
        pageAdapter = new MyPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
         tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.users,menu);
        return true;
    }
    @Override
    public void onResume(){
        int id = getIntent().getIntExtra("id", 0);
        if (id == 1 ) {
            pageAdapter.getItem(2);
            viewPager.setCurrentItem(id);
            tabLayout.setupWithViewPager(viewPager);
        }
        if (id == 2 ) {
            pageAdapter.getItem(3);
            viewPager.setCurrentItem(id);
            tabLayout.setupWithViewPager(viewPager);
        }
        super.onResume();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

      if(item.getItemId()==R.id.User) {
          Intent config = new Intent(this, user.class);
          startActivity(config);
      }
        return true;
    }
}
