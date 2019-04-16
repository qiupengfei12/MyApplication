package com.example.bx.myapplication.activity;

import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.example.bx.myapplication.BaseActivity;

import com.example.bx.myapplication.R;
import com.example.bx.myapplication.fragment.Fragment1;
import com.example.bx.myapplication.fragment.Fragment2;
import com.example.bx.myapplication.fragment.Fragment3;
import com.example.bx.myapplication.fragment.Fragment4;
import com.example.bx.myapplication.fragment.Fragment5;
import com.example.bx.myapplication.utils.StatusBarUtil;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private RadioGroup rg;
    private ViewPager vp;
    private void assignViews() {
        rg = (RadioGroup) findViewById(R.id.rg);
        vp = (ViewPager) findViewById(R.id.vp);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //用来设置整体下移，状态栏沉浸
        //
        StatusBarUtil.getStatusBarHeight(MainActivity.this);
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        StatusBarUtil.setTranslucentStatus(MainActivity.this);//透明状态栏
        StatusBarUtil.setStatusBarColor(MainActivity.this, Color.parseColor("#00AEFF"));//设置背景颜色
        assignViews();
        initData();
    }
    private void initData() {
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        fragments.add(new Fragment5());
        vp.setOffscreenPageLimit(0);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                vp.setCurrentItem(radioGroup.indexOfChild(radioGroup.findViewById(i)));
            }
        });
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                //实现滑动页面下方按钮的联动
                rg.check(rg.getChildAt(position).getId());
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
