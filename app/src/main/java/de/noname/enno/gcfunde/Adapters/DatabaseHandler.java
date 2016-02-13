package de.noname.enno.gcfunde.Adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import de.noname.enno.gcfunde.MainActivity;

/*
 * @author Enno Gotthold
 * @version 0.1
 * This class represents the SQL Database that contains the caches.
 * This class was created with the help of the Google Android Tutorial, specifically {@link http://developer.android.com/training/basics/data-storage/databases.html}
 */

public final class DatabaseHandler extends MainActivity {

    MainActivity mainActivity = new MainActivity();

    public DatabaseHandler() {}

    /*
     * This inner class defines the layout of the SQL Database
     */
    public static abstract class PQColumns implements BaseColumns {
        public static final String TABLE_NAME = "Founds";
        public static final String COLUMN_GC_CACHE_ID = "Cache ID";
        public static final String COLUMN_GC_NUMBER = "Number";
        public static final String COLUMN_GC_NAME = "Name";
        public static final String COLUMN_GC_TERRAIN = "Terrain";
        public static final String COLUMN_GC_DIFFICULTY = "Difficulty";
        public static final String COLUMN_GC_URL = "Url";
        public static final String COLUMN_GC_AVAILABLE = "Available";
        public static final String COLUMN_GC_ARCHIVED = "Archived";
        public static final String COLUMN_GC_OWNER = "Owner";
        public static final String COLUMN_GC_CONTAINER = "Container";
        public static final String COLUMN_GC_TYPE = "Type";
        public static final String COLUMN_GC_ATTRIBUTES = "Attributes";
        public static final String COLUMN_GC_SHORT_DESCRIPTION = "Short Description";
        public static final String COLUMN_GC_LONG_DESCRIPTION = "Long Description";
        public static final String COLUMN_GC_HINT = "Hint";
        public static final String COLUMN_GC_OWN_FOUND_STATUS = "Found Type";
        public static final String COLUMN_GC_OWN_FOUND_DATE = "Found Date";
        public static final String COLUMN_GC_OWN_LOG = "Own Log";
        public static final String COLUMN_GC_NORTH_COORDS = "North Coords";
        public static final String COLUMN_GC_EAST_COORDS = "East Coords";
        public static final String COLUMN_DATABASENAME = "Database Name";
    }

    public class PoketQueryDBHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Founds.db";

        public PoketQueryDBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    }

    /*
     * This variables are defining the SQL statement for creating the database.
     */
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PQColumns.TABLE_NAME + " (" +
                    PQColumns._ID + " INTEGER PRIMARY KEY," +
                    PQColumns.COLUMN_GC_CACHE_ID + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_NUMBER + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_NAME + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_OWNER + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_TYPE + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_TERRAIN + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_DIFFICULTY + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_CONTAINER + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_URL + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_NORTH_COORDS + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_EAST_COORDS + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_AVAILABLE + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_ARCHIVED + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_ATTRIBUTES + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_SHORT_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_LONG_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_HINT + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_OWN_FOUND_STATUS + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_OWN_FOUND_DATE + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_GC_OWN_LOG + TEXT_TYPE + COMMA_SEP +
                    PQColumns.COLUMN_DATABASENAME + TEXT_TYPE + COMMA_SEP +
            " )";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PQColumns.TABLE_NAME;
    PoketQueryDBHelper mDbHelper = new PoketQueryDBHelper(mainActivity.getApplicationContext());


    public long writeIntoDB (String cacheID,String gcNumber,String gcName,String gcOwner,String gcType,String gcTerrain,String gcDifficulty,String gcContainer, String gcUrl,String gcNorthCoords,String gcEastCoords,String gcAvailable, String gcArchived,String gcAttributes,String gcShortDescription,String gcLongDescription,String gcHint,String gcOwnFoundStatus,String gcOwnFoundDate,String gcOwnLog,String database) {
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(PQColumns.COLUMN_GC_CACHE_ID, cacheID);
        values.put(PQColumns.COLUMN_GC_NUMBER, gcNumber);
        values.put(PQColumns.COLUMN_GC_NAME, gcName);
        values.put(PQColumns.COLUMN_GC_OWNER, gcOwner);
        values.put(PQColumns.COLUMN_GC_TYPE, gcType);
        values.put(PQColumns.COLUMN_GC_TERRAIN, gcTerrain);
        values.put(PQColumns.COLUMN_GC_DIFFICULTY, gcDifficulty);
        values.put(PQColumns.COLUMN_GC_CONTAINER, gcContainer);
        values.put(PQColumns.COLUMN_GC_URL, gcUrl);
        values.put(PQColumns.COLUMN_GC_NORTH_COORDS, gcNorthCoords);
        values.put(PQColumns.COLUMN_GC_EAST_COORDS, gcEastCoords);
        values.put(PQColumns.COLUMN_GC_AVAILABLE, gcAvailable);
        values.put(PQColumns.COLUMN_GC_ARCHIVED, gcArchived);
        values.put(PQColumns.COLUMN_GC_ATTRIBUTES, gcAttributes);
        values.put(PQColumns.COLUMN_GC_SHORT_DESCRIPTION, gcShortDescription);
        values.put(PQColumns.COLUMN_GC_LONG_DESCRIPTION, gcLongDescription);
        values.put(PQColumns.COLUMN_GC_HINT, gcHint);
        values.put(PQColumns.COLUMN_GC_OWN_FOUND_STATUS, gcOwnFoundStatus);
        values.put(PQColumns.COLUMN_GC_OWN_FOUND_DATE, gcOwnFoundDate);
        values.put(PQColumns.COLUMN_GC_OWN_LOG, gcOwnLog);
        values.put(PQColumns.COLUMN_DATABASENAME,database);

        return db.insert(
                PQColumns.TABLE_NAME,
                null,
                values);

    }

    public void readFromDB (String [] searchItem) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                PQColumns.COLUMN_GC_CACHE_ID,
                PQColumns.COLUMN_GC_NUMBER,
                PQColumns.COLUMN_GC_NAME,
                PQColumns.COLUMN_GC_TERRAIN,
                PQColumns.COLUMN_GC_DIFFICULTY,
                PQColumns.COLUMN_GC_URL,
                PQColumns.COLUMN_GC_AVAILABLE,
                PQColumns.COLUMN_GC_ARCHIVED,
                PQColumns.COLUMN_GC_OWNER,
                PQColumns.COLUMN_GC_CONTAINER,
                PQColumns.COLUMN_GC_TYPE,
                PQColumns.COLUMN_GC_ATTRIBUTES,
                PQColumns.COLUMN_GC_SHORT_DESCRIPTION,
                PQColumns.COLUMN_GC_LONG_DESCRIPTION,
                PQColumns.COLUMN_GC_HINT,
                PQColumns.COLUMN_GC_OWN_FOUND_STATUS,
                PQColumns.COLUMN_GC_OWN_FOUND_DATE,
                PQColumns.COLUMN_GC_OWN_LOG,
                PQColumns.COLUMN_GC_NORTH_COORDS,
                PQColumns.COLUMN_GC_EAST_COORDS,
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                PQColumns.COLUMN_GC_NUMBER + " DESC";

        Cursor c = db.query(
                PQColumns.TABLE_NAME,         // The table to query
                projection,                   // The columns to return
                PQColumns.COLUMN_GC_NAME,     // The columns for the WHERE clause
                searchItem,                   // The values for the WHERE clause
                null,                         // don't group the rows
                null,                         // don't filter by row groups
                sortOrder                     // The sort order
        );

        c.moveToFirst();
        long itemID = c.getLong(c.getColumnIndexOrThrow(PQColumns._ID));
    }

    public void deleteFromDB () {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        // Define 'where' part of query.
        String selection = PQColumns._ID + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { String.valueOf(PQColumns._ID) };
        // Issue SQL statement.
        db.delete(PQColumns.TABLE_NAME, selection, selectionArgs);
    }

    public void updateRow (String updatedData) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(PQColumns.COLUMN_GC_NAME, updatedData);

        // Which row to update, based on the ID
        String selection = PQColumns.COLUMN_GC_NAME + " LIKE ?";
        String[] selectionArgs = { String.valueOf(PQColumns._ID) };

        int count = db.update(
                PQColumns.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }
}