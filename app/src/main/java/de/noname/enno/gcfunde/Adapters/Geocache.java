package de.noname.enno.gcfunde.Adapters;

import android.content.Context;

/**
 * @author Enno Gotthold
 * @version 0.1
 * This class should describe a model for a Geocache
 */

public class Geocache {

    DatabaseHandler databaseHandler;
    Context context;
    String cacheID, gcNumber, gcName, gcOwner, gcType, gcTerrain, gcDifficulty, gcContainer, gcUrl, gcNorthCoords, gcEastCoords, gcAvailable, gcArchived;
    String gcShortDescription, gcLongDescription, gcHint, gcOwnFoundStatus, gcOwnFoundDate, gcOwnLog, database;
    String[] gcAttributes;

    public Geocache(Context context) {
        this.context = context;
        databaseHandler = new DatabaseHandler(context);
        setCacheID("");
        setGcNumber("");
        setGcName("");
        setGcOwner("");
        setGcType("");
        setGcTerrain("");
        setGcDifficulty("");
        setGcContainer("");
        setGcUrl("");
        setGcNorthCoords("");
        setGcEastCoords("");
        setGcAvailable("");
        setGcArchived("");
        setGcAttributes(new String[]{""});
        setGcShortDescription("");
        setGcLongDescription("");
        setGcHint("");
        setGcOwnFoundStatus("");
        setGcOwnFoundDate("");
        setGcOwnLog("");
        setDatabase("");
        // databaseHandler.writeIntoDB(this);
    }

    public Geocache(Context context, String ID, String Number, String Name, String Owner, String Type, String Terrain, String Difficulty, String Container, String Url, String NorthCoords,
                     String EastCoords, String Available, String Archived, String[] Attributes, String ShortDescription, String LongDescription, String Hint, String OwnFoundStatus,
                     String OwnFoundDate, String OwnLog, String Database) {
        this.context = context;
        databaseHandler = new DatabaseHandler(context);
        setCacheID(ID);
        setGcNumber(Number);
        setGcName(Name);
        setGcOwner(Owner);
        setGcType(Type);
        setGcTerrain(Terrain);
        setGcDifficulty(Difficulty);
        setGcContainer(Container);
        setGcUrl(Url);
        setGcNorthCoords(NorthCoords);
        setGcEastCoords(EastCoords);
        setGcAvailable(Available);
        setGcArchived(Archived);
        setGcAttributes(Attributes);
        setGcShortDescription(ShortDescription);
        setGcLongDescription(LongDescription);
        setGcHint(Hint);
        setGcOwnFoundStatus(OwnFoundStatus);
        setGcOwnFoundDate(OwnFoundDate);
        setGcOwnLog(OwnLog);
        setDatabase(Database);
        databaseHandler.writeIntoDB(this);
    }

    public String getCacheID() {
        return cacheID;
    }

    public void setCacheID(String cacheID) {
        this.cacheID = cacheID;
    }

    public String getGcNumber() {
        return gcNumber;
    }

    public void setGcNumber(String gcNumber) {
        this.gcNumber = gcNumber;
    }

    public String getGcName() {
        return gcName;
    }

    public void setGcName(String gcName) {
        this.gcName = gcName;
    }

    public String getGcOwner() {
        return gcOwner;
    }

    public void setGcOwner(String gcOwner) {
        this.gcOwner = gcOwner;
    }

    public String getGcType() {
        return gcType;
    }

    public void setGcType(String gcType) {
        this.gcType = gcType;
    }

    public String getGcTerrain() {
        return gcTerrain;
    }

    public void setGcTerrain(String gcTerrain) {
        this.gcTerrain = gcTerrain;
    }

    public String getGcDifficulty() {
        return gcDifficulty;
    }

    public void setGcDifficulty(String gcDifficulty) {
        this.gcDifficulty = gcDifficulty;
    }

    public String getGcContainer() {
        return gcContainer;
    }

    public void setGcContainer(String gcContainer) {
        this.gcContainer = gcContainer;
    }

    public String getGcUrl() {
        return gcUrl;
    }

    public void setGcUrl(String gcUrl) {
        this.gcUrl = gcUrl;
    }

    public String getGcNorthCoords() {
        return gcNorthCoords;
    }

    public void setGcNorthCoords(String gcNorthCoords) {
        this.gcNorthCoords = gcNorthCoords;
    }

    public String getGcEastCoords() {
        return gcEastCoords;
    }

    public void setGcEastCoords(String gcEastCoords) {
        this.gcEastCoords = gcEastCoords;
    }

    public String getGcAvailable() {
        return gcAvailable;
    }

    public void setGcAvailable(String gcAvailable) {
        this.gcAvailable = gcAvailable;
    }

    public String getGcArchived() {
        return gcArchived;
    }

    public void setGcArchived(String gcArchived) {
        this.gcArchived = gcArchived;
    }

    public String[] getGcAttributes() {
        return gcAttributes;
    }

    public void setGcAttributes(String[] gcAttributes) {
        this.gcAttributes = gcAttributes;
    }

    public String getGcShortDescription() {
        return gcShortDescription;
    }

    public void setGcShortDescription(String gcShortDescription) {
        this.gcShortDescription = gcShortDescription;
    }

    public String getGcLongDescription() {
        return gcLongDescription;
    }

    public void setGcLongDescription(String gcLongDescription) {
        this.gcLongDescription = gcLongDescription;
    }

    public String getGcHint() {
        return gcHint;
    }

    public void setGcHint(String gcHint) {
        this.gcHint = gcHint;
    }

    public String getGcOwnFoundStatus() {
        return gcOwnFoundStatus;
    }

    public void setGcOwnFoundStatus(String gcOwnFoundStatus) {
        this.gcOwnFoundStatus = gcOwnFoundStatus;
    }

    public String getGcOwnFoundDate() {
        return gcOwnFoundDate;
    }

    public void setGcOwnFoundDate(String gcOwnFoundDate) {
        this.gcOwnFoundDate = gcOwnFoundDate;
    }

    public String getGcOwnLog() {
        return gcOwnLog;
    }

    public void setGcOwnLog(String gcOwnLog) {
        this.gcOwnLog = gcOwnLog;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
