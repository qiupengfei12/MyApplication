package com.example.bx.myapplication.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.bx.myapplication.R;

public class Fragment1 extends BaseFragment {


    private TextView tesssww;

    @Override
    protected int setLayoutId() {
        return R.layout.fm_layout1;
    }

    //控件的部署
    @Override
    protected void init(View view, Bundle savedInstanceState) {
        tesssww = (TextView) view.findViewById(R.id.tesssww);
        tesssww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tesssww.setText("444141414");
            }
        });


    }

    //网络请求
    @Override
    public void fetchData() {
        Log.d("ssss","---------*********/////////");

    }
}
