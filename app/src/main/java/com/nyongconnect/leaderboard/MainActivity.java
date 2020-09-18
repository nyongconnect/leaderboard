package com.nyongconnect.leaderboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.nyongconnect.leaderboard.adapter.PageAdapter;
import com.nyongconnect.leaderboard.fragment.LeadershipFragment;
import com.nyongconnect.leaderboard.fragment.SkillIqFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fragment> mFragments;
    ViewPager2 mViewPager2;
    TabLayout tbLayout;
    TextView tvSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tbLayout = findViewById(R.id.tb_pager);

        tvSubmit =findViewById(R.id.menu_submit);
        mFragments =  new ArrayList<>();
        mViewPager2 = findViewById(R.id.vp_leader_board);
        mFragments.add(new LeadershipFragment());
        mFragments.add(SkillIqFragment.newInstance());

        PageAdapter pageAdapter = new PageAdapter(this, mFragments);
        mViewPager2.setAdapter(pageAdapter);
        new TabLayoutMediator(tbLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                    tab.setText("Learning Leaders");
                }
                else {
                    tab.setText("Skill IQ Leaders");
                }


            }
        }).attach();


        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}