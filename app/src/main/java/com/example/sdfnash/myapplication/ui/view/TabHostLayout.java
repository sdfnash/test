package com.example.sdfnash.myapplication.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sdfnash.myapplication.R;
import com.example.sdfnash.myapplication.utils.DipPixUtil;

import java.util.ArrayList;

/**
 * Created by sdfnash on 2017/7/7.
 */

public class TabHostLayout extends LinearLayout {

ArrayList<TabHostItem> list=new ArrayList<>();

    public TabHostLayout(Context context) {
        super(context);
        init();
    }

    public TabHostLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TabHostLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        setGravity(Gravity.CENTER);
        setOrientation(HORIZONTAL);
    }

    int offsetLeft;
    int offsetRight;
    int offsetTop;
    int offsetBottom;

    public void setImageOffset(int left, int top, int right, int bottom) {
        offsetLeft = left;
        offsetTop = top;
        offsetRight = right;
        offsetBottom = bottom;
    }

    public boolean single = false;

public void buildTabHost(){
    this.removeAllViews();
    for(TabHostItem item:list){
        LinearLayout layout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_tab_host, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        layout.setLayoutParams(params);
        addView(layout);
        layout.setOnClickListener(onClickListener);
        layout.setTag(item);



        ImageView img = (ImageView) layout.findViewById(R.id.layout_tabhost_item_icon);
//            RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, DipPixUtil.dip2px(getContext(), 48));
        RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(DipPixUtil.dip2px(getContext(),42), DipPixUtil.dip2px(getContext(),42));
        imageParams.setMargins(offsetLeft, offsetTop, offsetRight, offsetBottom);
        imageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        img.setLayoutParams(imageParams);

        TextView text = (TextView) layout.findViewById(R.id.layout_tabhost_item_text);

        img.setImageResource(item.resId);
        if (TextUtils.isEmpty(item.text)){
            text.setVisibility(View.GONE);
        }else {
            text.setText(item.text);

            if(!single) {
//                    if (i == index) {
//                        img.setImageResource(item.selectResId);
//                        text.setTextColor(getResources().getColor(R.color.color_main));
//                        text.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(com.common.lib.R.dimen.text_size_16));
//                    } else {
                img.setImageResource(item.resId);
//                    }
            } else {
                img.setImageResource(item.resId);
            }
        }

    }
}


    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int index, int tabId);

        boolean onItemLongClick(int index, int tabId);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public View.OnClickListener onClickListener=new OnClickListener() {
        @Override
        public void onClick(View v) {
            TabHostItem item=(TabHostItem) v.getTag();
        }
    };

    public class TabHostItem{
       public int id;
        public String text;
        public int resId;
        public int selectedId;
    }
}
