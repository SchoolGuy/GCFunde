package de.schoolguy.gcfunde.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import de.schoolguy.gcfunde.Adapters.GeocacheListAdapter;
import de.schoolguy.gcfunde.Adapters.GeocachingXmlParser;
import de.schoolguy.gcfunde.R;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.*;
import java.util.ArrayList;

/*
 * @author Enno Gotthold
 * @version 0.1
 * This class is the Main Acitivity for this Android App.
 * It contains a List View
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ListView l;
    String ExternalAppBasePath;
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This presents the action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Navigatition View
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Create folder for PoketQuerys at sdcard. I know I am using a hardcoded String at the end, but I tried several
        // other solutions and this is the only working one, sry :/
        File Directory = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "GCFunde/");
        ExternalAppBasePath = Environment.getExternalStorageDirectory().getPath() + File.separator + "GCFunde/";
        Directory.mkdirs();

        // Read Pocket Query
        GeocachingXmlParser parser = new GeocachingXmlParser();
        String xml = parser.load();
        Document document = parser.getDomElement (xml);
        NodeList nl = document.getElementsByTagName("name");

        ArrayList<String> gcCodeAL = new ArrayList<String>();
        // looping through all item nodes <item>
        for (int i = 0; i < nl.getLength(); i++) {
            Element e = (Element) nl.item(i);
            gcCodeAL.add(parser.getValue(e,"name")); // name child value
        }

        // List View
        l = (ListView) findViewById(R.id.list);
        // Parameter days is currently just here to guarantee that the app can be tested.
        String gcCode[] = new String[0];
        gcCodeAL.toArray(gcCode);
        GeocacheListAdapter adapter1 = new GeocacheListAdapter(days, gcCode, days, days, days, days, this);
        l.setAdapter(adapter1);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement
        if (id == R.id.nav_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_search) {
            // Do nothing
        } else if (id == R.id.nav_create) {
            Intent intent = new Intent(this, CreateGeocacheEntry.class);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_deatails) {
            Intent intent = new Intent(this, GeocacheDetails.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }
}