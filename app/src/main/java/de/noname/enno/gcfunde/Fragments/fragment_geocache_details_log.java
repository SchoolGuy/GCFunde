package de.noname.enno.gcfunde.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.noname.enno.gcfunde.R;

public class fragment_geocache_details_log extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_geocache_details_waypoints, container, false);

        return rootView;
    }

}