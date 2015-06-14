package com.github.jaydeep.cardlist;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.intouchapp.models.ScannedCard;
import com.malinskiy.superrecyclerview.SuperRecyclerView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ScannedCardsListFragment extends Fragment {

    private SuperRecyclerView mRecyclerView;
    private ScannedCardsAdapter mAdapter;

    public ScannedCardsListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<ScannedCard> list = new ArrayList<>();
        list.add(new ScannedCard("myid1", "http://motoroids.com/wp-content/uploads/2014/09/KTM-RC390-Review-Side-Profile-600x399.jpg"));
        list.add(new ScannedCard("myid2", "http://www.carblogindia.com/wp-content/uploads/2014/03/2014-KTM-RC-390-Front-Leaning-Right.jpg"));
        list.add(new ScannedCard("myid3", "http://motoroids.com/wp-content/uploads/2014/09/KTM-RC390-vs-Kawasaki-Ninja-300-vs-KTM-Duke-390-44-600x399.jpg"));
        list.add(new ScannedCard("myid4", "http://img4.wikia.nocookie.net/__cb20130325195536/fantasy-worlds/images/2/23/Emma_f11_-_other_hot_babes.jpg"));
        list.add(new ScannedCard("myid5", "http://www.theunlocker.co.uk/wallpapers/360x640/Babes_Hunks/27923.jpg"));
        list.add(new ScannedCard("myid6", "http://images5.fanpop.com/image/photos/31700000/HOT-BABE-KAWASAKI-Z1000-motorcycles-31778344-1920-1200.jpg"));
        mAdapter = new ScannedCardsAdapter(list, mCardClickListener, mConvertCardListener, mDeleteCardListener);

        if (true) {
            // TODO: is internet
            // getPendingRequests();
        }
    }

    private View.OnClickListener mCardClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Object possiblyScannedCard = v.getTag();

            if (possiblyScannedCard instanceof ScannedCard) {
                ScannedCard scannedCard = (ScannedCard) possiblyScannedCard;
                Intent intent = new Intent(getActivity(), FullScreenImageActivity.class);
                intent.putExtra(FullScreenImageActivity.INTENT_EXTRAS_URL, scannedCard.getUrl());
                startActivity(intent);
                Snackbar.make(v, "Open card ID: " + scannedCard.getId(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            } else {

            }

        }
    };

    private View.OnClickListener mConvertCardListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO: make an API call here.
            Snackbar.make(v, "Card will be converted", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    };

    private View.OnClickListener mDeleteCardListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO: make an API call here.
            Snackbar.make(v, "Card will be DELETED", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (SuperRecyclerView) view.findViewById(R.id.scanned_cards_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // TODO: make API call here.
            }
        });
    }
}
