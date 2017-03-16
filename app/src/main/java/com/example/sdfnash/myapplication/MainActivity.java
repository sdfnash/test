package com.example.sdfnash.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listView;
    TestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (RecyclerView) findViewById(R.id.list);
        mAdapter = new TestAdapter(DataManager.getInstance().initData());
        mAdapter.addHeader(new View(MainActivity.this));
        mAdapter.addBottom(new View(MainActivity.this));
        listView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        listView.setAdapter(mAdapter);

    }


    public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        public static final int TYPE_HEADER = 0;  //说明是带有Header的
        public static final int TYPE_FOOTER = 1;  //说明是带有Footer的
        public static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的
        ArrayList<String> list;
        View headerView, bottomView;

        public void addHeader(View header) {
            headerView = header;
            notifyItemInserted(0);
        }

        public void addBottom(View bottom) {
            bottomView = bottom;
            notifyItemInserted(getItemCount() - 1);
        }

        public TestAdapter(ArrayList<String> list) {
            this.list = list;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (headerView != null && viewType == TYPE_HEADER) {
                return new HeaderViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_header, parent, false));
            }
            if (bottomView != null && viewType == TYPE_FOOTER) {
                return new BottomViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_bottom, parent, false));
            }
            View layout = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_test_viewholder, parent, false);
            return new TestViewHolder(layout);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (getItemViewType(position) == TYPE_NORMAL) {
                if (holder instanceof TestViewHolder) {
                    TestViewHolder holder1 = (TestViewHolder) holder;
                    //这里加载数据的时候要注意，是从position-1开始，因为position==0已经被header占用了
                    holder1.tv.setText(list.get(position - 1));
                    return;
                }
                return;
            } else if (getItemViewType(position) == TYPE_HEADER) {
                return;
            } else {
                return;
            }
        }

        @Override
        public int getItemCount() {
            return DataManager.getInstance().initData().size();
        }


        @Override
        public int getItemViewType(int position) {
            if (headerView == null && bottomView == null) {
                return TYPE_NORMAL;
            }
            if (position == 0) {
                //第一个item应该加载Header
                return TYPE_HEADER;
            }
            if (position == getItemCount() - 1) {
                //最后一个,应该加载Footer
                return TYPE_FOOTER;
            }
            return TYPE_NORMAL;
        }
    }


    public <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    public class TestViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;

        public TestViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_test);
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public HeaderViewHolder(View itemView) {
            super(itemView);
//            tv = findView(R.id.tv_test);
        }
    }

    public class BottomViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public BottomViewHolder(View itemView) {
            super(itemView);
//            tv = findView(R.id.tv_test);
        }
    }
}
