package com.example.sdfnash.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by sdfnash on 2017/3/13.
 */

public abstract class BaseAdapter<T, V extends BaseViewHolder> extends RecyclerView.Adapter<V> {
    List<T> list;
    Context context;
    LayoutInflater inflater;

    public BaseAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(V holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public abstract V getViewHolder(ViewGroup parent, int viewType);


}
