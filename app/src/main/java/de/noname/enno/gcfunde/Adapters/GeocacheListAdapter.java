package de.noname.enno.gcfunde.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.noname.enno.gcfunde.R;

/*
 * @author Enno Gotthold
 * @version 0.1
 * This class should describe the listView in the Main Activity.
 * Later it should be extended that when the user is changing his GPS coordinates, only the distance and the direction is changing, afterwards the listView should sort itself after distance.
 */

public class GeocacheListAdapter extends ArrayAdapter<Geocache> {

    public GeocacheListAdapter(Context c, ArrayList<Geocache> geocaches) {
        super(c, 0, geocaches);
    }

    /*
     * @param position This is the position that the item that will be created is having.
     * @param convertView Sry no idea, just look into the tutorial I used {@link http://www.vogella.com/tutorials/AndroidListView/article.html}
     * @param parent Sry no idea, just look into the tutorial I used {@link http://www.vogella.com/tutorials/AndroidListView/article.html}
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout,
                    parent,
                    false);

        Geocache gc = getItem(position);

        TextView GCTitles = (TextView) convertView.findViewById(R.id.txtFGCTitle);
        TextView GCNames = (TextView) convertView.findViewById(R.id.txtFGCNumber);
        TextView DifficultysTerrains = (TextView) convertView.findViewById(R.id.txtFDifficultyTerrain);
        TextView DistancesToCaches = (TextView) convertView.findViewById(R.id.txtFDistanceToCache);
        TextView FavPoints = (TextView) convertView.findViewById(R.id.txtFFavoritePoints);
        ImageView Symbol = (ImageView) convertView.findViewById(R.id.imgVType);
        ImageView FavSymbol = (ImageView) convertView.findViewById(R.id.imgVFavSymbol);
        ImageView Direction = (ImageView) convertView.findViewById(R.id.imgVDirection);

        // GCTitles.setText(gc.getTitle?);
        GCNames.setText(gc.getGcName());
        DifficultysTerrains.setText(gc.getGcDifficulty());
        // DistancesToCaches.setText(gc.getDistance?);
        // FavPoints.setText(gc.getFavPoints?);
        // TODO: setup ImageViews

        return convertView;
    }

}