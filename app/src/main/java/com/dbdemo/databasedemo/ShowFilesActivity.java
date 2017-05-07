package com.dbdemo.databasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ShowFilesActivity extends AppCompatActivity {

    List<String> list = new ArrayList<>();
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_files);

        realm = Realm.getDefaultInstance();
        final RealmResults<FileModel> results = realm.where(FileModel.class).findAll();
        int size = results.size();

        for(int i=0; i<size; i++) {
            results.get(i).getTitle();
            list.add(String.valueOf(results.get(i).getTitle()));
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_list_view, list);

        ListView listView = (ListView) findViewById(R.id.listViewShow);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ShowFilesActivity.this, BodyDisplayActivity.class);
                intent.putExtra("body", results.get(i).getBody());
                startActivity(intent);
            }
        });

    }
}
