package com.example.sdfnash.myapplication.manager;

import java.util.ArrayList;

/**
 * Created by sdfnash on 2017/3/13.
 */

public class DataManager {
    private static DataManager instance = null;

    private DataManager() {
    }

    public static DataManager getInstance() {
        synchronized (DataManager.class) {
            if (instance == null) {
                instance = new DataManager();
            }
        }

        return instance;
    }

    public ArrayList<String> initData() {
        ArrayList<String> mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
        return mDatas;
    }
}
