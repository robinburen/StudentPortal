package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText mTitlePortal;
    private EditText mUrlPortal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mTitlePortal = findViewById(R.id.portalTitle);
        mUrlPortal = findViewById(R.id.portalURL);

        View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPortal();
            }
        });
//
//        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void addPortal() {
        Portal portal = new Portal(mTitlePortal.getText().toString(), mUrlPortal.getText().toString());
        Intent intent = new Intent();
        intent.putExtra(MainActivity.NEW_PORTAL, portal);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
