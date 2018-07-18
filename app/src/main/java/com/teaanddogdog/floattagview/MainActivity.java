package com.teaanddogdog.floattagview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.teaanddogdog.floattagview.adapter.TagAdapter;
import com.teaanddogdog.floattagview.bean.Demo;
import com.teaanddogdog.floattagviewlib.FloatTagRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.right_tag)
    FloatTagRecyclerView mRightTag;
    @Bind(R.id.left_tag)
    FloatTagRecyclerView mLeftTag;
    @Bind(R.id.top_tag)
    FloatTagRecyclerView mToptag;
    @Bind(R.id.bottom_tag)
    FloatTagRecyclerView mBottomtag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        List<Demo> demos = new ArrayList<>();
        Demo demo;
        for (int i = 0; i < 20; i++) {
            demo = new Demo();
            demo.setNick("TAG_" + i);
            demo.setImage("http://p0.qhimgs4.com/t010e67f277fcb88c4b.jpg");
            demos.add(demo);
        }

        mBottomtag.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mBottomtag.setMode(FloatTagRecyclerView.Mode_H);
        mBottomtag.setAdapter(new TagAdapter(demos,R.layout.item_layout_bottom_indicator));

        mToptag.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mToptag.setAdapter(new TagAdapter(demos,R.layout.item_layout_top_indicator));

        mLeftTag.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mLeftTag.setMode(FloatTagRecyclerView.Mode_V);
        mLeftTag.setAdapter(new TagAdapter(demos,R.layout.item_layout_left_indicator));

        mRightTag.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRightTag.setAdapter(new TagAdapter(demos,R.layout.item_layout_right_indicator));
    }
}
