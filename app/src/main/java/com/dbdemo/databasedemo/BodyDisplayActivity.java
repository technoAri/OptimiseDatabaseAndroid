package com.dbdemo.databasedemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class BodyDisplayActivity extends AppCompatActivity {

    Bundle extras;
    TextView body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_display);

        body = (TextView) findViewById(R.id.tv_details_body);

        extras = getIntent().getExtras();
        if(extras != null) {
            String textBody = extras.getString("body");
            body.setText(textBody);
        }

    }
}
