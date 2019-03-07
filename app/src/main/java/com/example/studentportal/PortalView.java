package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PortalView extends AppCompatActivity {

    WebView mPortalView;
    public static final String URL_PORTAL = "Reminder";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal_view);

        Intent getIntent = getIntent();
        String urlName = getIntent.getStringExtra(MainActivity.PORTAL_VIEW);

        mPortalView = findViewById(R.id.portalView);
        mPortalView.setWebViewClient(new WebViewClient());
        mPortalView.loadUrl(urlName);
    }
}
