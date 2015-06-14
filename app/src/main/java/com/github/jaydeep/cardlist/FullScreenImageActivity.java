package com.github.jaydeep.cardlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by jay on 14/6/15.
 */
public class FullScreenImageActivity extends AppCompatActivity {

    public static final String INTENT_EXTRAS_URL = "com.intouchapp.intent.extras.url";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_view_fullscreen);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.fab_background);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();

        if (intent != null) {
            String url = intent.getStringExtra(INTENT_EXTRAS_URL);
            ImageView imageView = (ImageView) findViewById(R.id.image);
            // TODO: use UIL library to show the image here.
            Toast.makeText(this, "URL: " + url, Toast.LENGTH_LONG).show();
        }
    }
}
