package com.github.jaydeep.cardlist;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

import com.malinskiy.superrecyclerview.SuperRecyclerView;

public class ScannedCardsListActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private FloatingActionButton mFabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanned_cards_list);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.fab_background);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        mFabButton = (FloatingActionButton) findViewById(R.id.fab);
        /*mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        SuperRecyclerView superRecyclerView = (SuperRecyclerView) findViewById(R.id.scanned_cards_list);
        superRecyclerView.getRecyclerView().setOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideViews();
            }

            @Override
            public void onShow() {
                showViews();
            }
        });
    }

    private void hideViews() {
        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));

        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) mFabButton.getLayoutParams();
        int fabBottomMargin = lp.bottomMargin;
        mFabButton.animate().translationY(mFabButton.getHeight()+fabBottomMargin).setInterpolator(new AccelerateInterpolator(2)).start();
    }

    private void showViews() {
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
        mFabButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public abstract class HidingScrollListener extends RecyclerView.OnScrollListener {
        private static final int HIDE_THRESHOLD = 20;
        private int scrolledDistance = 0;
        private boolean controlsVisible = true;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (scrolledDistance > HIDE_THRESHOLD && controlsVisible) {
                onHide();
                controlsVisible = false;
                scrolledDistance = 0;
            } else if (scrolledDistance < -HIDE_THRESHOLD && !controlsVisible) {
                onShow();
                controlsVisible = true;
                scrolledDistance = 0;
            }

            if((controlsVisible && dy>0) || (!controlsVisible && dy<0)) {
                scrolledDistance += dy;
            }
        }

        public abstract void onHide();
        public abstract void onShow();
    }
}
