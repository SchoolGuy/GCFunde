package de.schoolguy.gcfunde.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import de.schoolguy.gcfunde.R;

/*
 * @author Enno Gotthold
 * @version 0.1
 * This class contains functions that are needed for the related XML file
 */

public class fragment_geocache_details_waypoints extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_geocache_details_waypoints, container, false);

        return rootView;
    }

}
