package de.noname.enno.gcfunde;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GeocacheListAdapter extends BaseAdapter {

    String [] GCTitles;
    String [] GCNames;
    String [] DifficultysTerrains;
    String [] DistancesToCaches;
    String [] FavPoints;
    String [] Symboles;
    Context context;
    LayoutInflater layoutInflater;

    public GeocacheListAdapter(String [] gcTitles,String [] gcNames,String [] difficultysTerrains,String [] distancesToCaches,String [] favPoints,String [] symboles,Context ctxt) {
        GCTitles = gcTitles;
        GCNames = gcNames;
        DifficultysTerrains = difficultysTerrains;
        DistancesToCaches = distancesToCaches;
        FavPoints = favPoints;
        Symboles = symboles;
        ctxt = context;
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

    public class Holder {
        TextView GCTitles,GCNames,DifficultysTerrains,DistancesToCaches,FavPoints;
        ImageView Symbol,Direction,FavSymbol;
    }

    public View getView (int position, View convertView, ViewGroup parent) {
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
        return convertView;
    }
}