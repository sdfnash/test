package com.example.sdfnash.myapplication;

import java.io.Serializable;

/**
 * Created by sdfnash on 2017/3/13.
 */

public class BaseModel implements Serializable{
    String title;
    String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
