package com.example.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {

    //instance variables
    RecyclerView mRecyclerView;
    private List<Portal> mPortal;
    private PortalAdapter mAdapter;

    //Constants used when calling the update activity
    public static final String NEW_PORTAL = "Reminder";
    public static final String PORTAL_VIEW = "Reminder2";
    public static final int REQUESTCODE = 1234;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        //Initialize the instance variables
        mRecyclerView = findViewById(R.id.recyclerView);
        mPortal = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        // Third parameter: reverse order data model to view: true or false.

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });

        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });

        mRecyclerView.addOnItemTouchListener(this);
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        int mAdapterPosition = recyclerView.getChildAdapterPosition(child);
        if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
            Intent intent = new Intent(MainActivity.this, PortalView.class);
            intent.putExtra(PORTAL_VIEW,  mPortal.get(mAdapterPosition).getmPortalUrl());
            startActivityForResult(intent, REQUESTCODE);
        }

        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new PortalAdapter(mPortal);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUESTCODE) {
            if (resultCode == RESULT_OK) {
                Portal portal = data.getParcelableExtra(MainActivity.NEW_PORTAL);
                // New timestamp: timestamp of update

                mPortal.add(portal);
                updateUI();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
