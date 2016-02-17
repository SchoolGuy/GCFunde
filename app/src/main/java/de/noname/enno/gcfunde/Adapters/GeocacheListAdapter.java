package de.noname.enno.gcfunde.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import de.noname.enno.gcfunde.R;

/*
 * @author Enno Gotthold
 * @version 0.1
 * This class should describe the listView in the Main Activity.
 * Later it should be extended that when the user is changing his GPS coordinates, only the distance and the direction is changing, afterwards the listView should sort itself after distance.
 */

public class GeocacheListAdapter extends BaseAdapter {

    String [] GCTitles;
    String [] GCNames;
    String [] DifficultysTerrains;
    String [] DistancesToCaches;
    String [] FavPoints;
    String [] Symboles;
    Context context;
    LayoutInflater layoutInflater; //This inflates the XML row_layout to a listView

    /*
     * @param gcTitles String array that is containing all GC-Numbers (sort of id) of the caches.
     * @param gcNames String array that is containing all the names of the caches.
     * @param difficultysTerrains String array that is containing all of the difficulty's and terrains of the caches.
     * @param distancesToCaches String array that is containing all distances to the caches.
     * @param favPoints String array that is containing the count of favourite points of all caches.
     * @param symboles String array that is containing the cache type and so the name of the symbol that should be shown (also for all caches).
     * @param ctxt This should contain where the listView is displayed, in most cases it is {@code this}.
     */
    public GeocacheListAdapter(String [] gcTitles,String [] gcNames,String [] difficultysTerrains,String [] distancesToCaches,String [] favPoints,String [] symboles,Context ctxt) {
        GCTitles = gcTitles;
        GCNames = gcNames;
        DifficultysTerrains = difficultysTerrains;
        DistancesToCaches = distancesToCaches;
        FavPoints = favPoints;
        Symboles = symboles;
        context = ctxt;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return GCTitles.length;
    }

    @Override
    public Object getItem(int position) {
        return new String [] {GCTitles [position],GCNames [position],DifficultysTerrains [position], DistancesToCaches [position], FavPoints [position],Symboles [position]};
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    /*
     * This class should contain the parts that one element should have. Why? Don't know. Source: {@link http://stackoverflow.com/questions/35240906/using-an-external-xml-file-for-custom-list-view-adapter}
     */
    public class Holder {
        TextView GCTitles,GCNames,DifficultysTerrains,DistancesToCaches,FavPoints;
        ImageView Symbol,Direction,FavSymbol;
    }

    /*
     * @param position This is the position that the item that will be created is having.
     * @param convertView Sry no idea, just look into the tutorial I used {@link http://www.vogella.com/tutorials/AndroidListView/article.html}
     * @param parent Sry no idea, just look into the tutorial I used {@link http://www.vogella.com/tutorials/AndroidListView/article.html}
     */
    public View getView (int position, View convertView, ViewGroup parent) {
        if (convertView != null) {
            Holder holder = new Holder();
            convertView = layoutInflater.inflate(R.layout.row_layout, null);
            holder.GCTitles = (TextView) convertView.findViewById(R.id.txtFGCTitle);
            holder.GCNames = (TextView) convertView.findViewById(R.id.txtFGCNumber);
            holder.DifficultysTerrains = (TextView) convertView.findViewById(R.id.txtFDifficultyTerrain);
            holder.DistancesToCaches = (TextView) convertView.findViewById(R.id.txtFDistanceToCache);
            holder.FavPoints = (TextView) convertView.findViewById(R.id.txtFFavoritePoints);
            holder.Symbol = (ImageView) convertView.findViewById(R.id.imgVType);
            holder.FavSymbol = (ImageView) convertView.findViewById(R.id.imgVFavSymbol);
            holder.Direction = (ImageView) convertView.findViewById(R.id.imgVDirection);
            //set Befehle fehlen noch!
        }
        return convertView;
    }
}