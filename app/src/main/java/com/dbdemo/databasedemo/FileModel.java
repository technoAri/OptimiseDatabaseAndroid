package com.dbdemo.databasedemo;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by HP PC on 5/7/2017.
 */

public class FileModel extends RealmObject {

    @PrimaryKey
    private int id;
    private String title;
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
