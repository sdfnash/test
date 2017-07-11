package com.example.sdfnash.myapplication.ui.activity;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.IntRange;
import android.support.annotation.StringRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sdfnash.myapplication.R;
import com.example.sdfnash.myapplication.adapter.TestAdapter;
import com.example.sdfnash.myapplication.manager.DataManager;
import com.example.sdfnash.myapplication.utils.StatusBarUtil;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Main2Activity extends AppCompatActivity {

    RecyclerView listView;
    TestAdapter mAdapter;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = findView(android.R.id.list);
        mAdapter = new TestAdapter(DataManager.getInstance().initData(),this);
        mAdapter.addHeader(new View(Main2Activity.this));
        mAdapter.addBottom(new View(Main2Activity.this));
        listView.setLayoutManager(new LinearLayoutManager(Main2Activity.this));
        listView.setAdapter(mAdapter);
        drawerLayout=findView(R.id.activity_main2);
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(this,drawerLayout,getResources().getColor(R.color.colorAccent));
        setDuration(1);
        setText(R.string.app_name);
    }

    public <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }


    public void setDuration(@Duration(getDuration = 1) int w){
//        Duration duration=(Duration) Main2Activity.class.getAnnotation(Duration.class);
//        duration.getDuration();
    }

    public void setText(@StringRes int a){

    }

    @IntDef({LENGTH_INDEFINITE, LENGTH_SHORT, LENGTH_LONG})
    @IntRange(from = 1,to = 10)
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {
        int getDuration();
    }

    public static final int LENGTH_INDEFINITE = -2;

    public static final int LENGTH_SHORT = -1;

    public static final int LENGTH_LONG = 0;

    public static final int TEST=-2;
}
