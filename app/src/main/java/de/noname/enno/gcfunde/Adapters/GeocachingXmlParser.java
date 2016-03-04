package de.noname.enno.gcfunde.Adapters;

/*
 * @author Enno Gotthold
 * @version 0.1
 * This class should contain the XML reader/parser that stores the read data in the SQL database.
 * Because I am messing up with XML readers I won't comment this file out (-> I can't get them to work, when there is an interest to help, pls mail to SchoolGuy via Github. My Email is written down at README.md in {@docRoot})
 */

import android.app.Activity;
import android.os.Environment;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GeocachingXmlParser extends Activity {

    private String ExternalAppBasePath;
    private static final String TAG = GeocachingXmlParser.class.getSimpleName();

    public GeocachingXmlParser() {
        ExternalAppBasePath = Environment.getExternalStorageDirectory().getPath() + File.separator + "GCFunde/";
    }

    private static final String ns = null;

    public List parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readFeed(parser);
        } finally {
            in.close();
        }
    }


    private List readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        List entries = new ArrayList();

        parser.require(XmlPullParser.START_TAG, ns, "feed");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("entry")) {
                entries.add(readEntry(parser));
            } else {
                skip(parser);
            }
        }
        return entries;
    }

    public static class Cache {
        public final String time; // Placed date
        public final String name; // GC-Code
        public final String desc; // GC-Name with Short informations
        public final String url;
        public final String urlname;
        public final String sym;
        public final String type;
        public final String groundspeakName;
        public final String groundspeakPlacedBy;
        public final String groundspeakOwner;
        public final String groundspeakType;
        public final String groundspeakContainer;
        public final String groundspeakAttributes;
        public final String groundspeakDifficulty;
        public final String groundspeakTerrain;
        public final String groundspeakCountry;
        public final String groundspeakState;
        public final String groundspeakShortDescription;
        public final String groundspeakLongDescription;
        public final String groundspeakEncodedHints;
        public final String groundspeakLogsLog;

        private Cache(String time, String desc, String name, String url, String urlname, String sym, String type, String groundspeakName, String groundspeakPlacedBy,
                      String groundspeakOwner, String groundspeakType, String groundspeakContainer, String groundspeakAttributes, String groundspeakDifficulty,
                      String groundspeakTerrain, String groundspeakCountry, String groundspeakState, String groundspeakShortDescription, String groundspeakLongDescription,
                      String groundspeakEncodedHints, String groundspeakLogsLog) {
            this.time = time;
            this.desc = desc;
            this.name = name;
            this.url = url;
            this.urlname = urlname;
            this.sym = sym;
            this.type = type;
            this.groundspeakName = groundspeakName;
            this.groundspeakPlacedBy = groundspeakPlacedBy;
            this.groundspeakOwner = groundspeakOwner;
            this.groundspeakType = groundspeakType;
            this.groundspeakContainer = groundspeakContainer;
            this.groundspeakAttributes = groundspeakAttributes;
            this.groundspeakDifficulty = groundspeakDifficulty;
            this.groundspeakTerrain = groundspeakTerrain;
            this.groundspeakCountry = groundspeakCountry;
            this.groundspeakState = groundspeakState;
            this.groundspeakShortDescription = groundspeakShortDescription;
            this.groundspeakLongDescription = groundspeakLongDescription;
            this.groundspeakEncodedHints = groundspeakEncodedHints;
            this.groundspeakLogsLog = groundspeakLogsLog;
        }
    }

    // Parses the contents of an entry. If it encounters a time, desc, or name tag, hands them off
    // to their respective "read" methods for processing. Otherwise, skips the tag.
    private Cache readEntry(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "entry");
        String title = null;
        String summary = null;
        String link = null;
        String url = null;
        String urlname = null;
        String sym = null;
        String type = null;
        String groundspeakName = null;
        String groundspeakPlacedBy = null;
        String groundspeakOwner = null;
        String groundspeakType = null;
        String groundspeakContainer = null;
        String groundspeakAttributes = null;
        String groundspeakDifficulty = null;
        String groundspeakTerrain = null;
        String groundspeakCountry = null;
        String groundspeakState = null;
        String groundspeakShortDescription = null;
        String groundspeakLongDescription = null;
        String groundspeakEncodedHints = null;
        String groundspeakLogsLog = null;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("time")) {
                title = readTitle(parser);
            } else if (name.equals("desc")) {
                summary = readSummary(parser);
            } else if (name.equals("name")) {
                link = readLink(parser);
            } else if (name.equals("name")) {
                url = readLink(parser);
            } else if (name.equals("name")) {
                urlname = readLink(parser);
            } else if (name.equals("name")) {
                sym = readLink(parser);
            } else if (name.equals("name")) {
                type = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakName = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakPlacedBy = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakOwner = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakType = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakContainer = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakAttributes = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakDifficulty = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakTerrain = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakCountry = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakState = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakShortDescription = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakLongDescription = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakEncodedHints = readLink(parser);
            } else if (name.equals("name")) {
                groundspeakLogsLog = readLink(parser);
            } else {
                skip(parser);
            }
        }
        return new Cache(title, summary, link, url, urlname, sym, type, groundspeakName, groundspeakPlacedBy, groundspeakOwner, groundspeakType,
                groundspeakContainer, groundspeakAttributes, groundspeakDifficulty, groundspeakTerrain, groundspeakCountry, groundspeakState,
                groundspeakShortDescription, groundspeakLongDescription, groundspeakEncodedHints, groundspeakLogsLog);
    }

    // Processes time tags in the feed.
    private String readTitle(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "time");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "time");
        return title;
    }

    // Processes name tags in the feed.
    private String readLink(XmlPullParser parser) throws IOException, XmlPullParserException {
        String link = "";
        parser.require(XmlPullParser.START_TAG, ns, "name");
        String tag = parser.getName();
        String relType = parser.getAttributeValue(null, "rel");
        if (tag.equals("name")) {
            if (relType.equals("alternate")) {
                link = parser.getAttributeValue(null, "href");
                parser.nextTag();
            }
        }
        parser.require(XmlPullParser.END_TAG, ns, "name");
        return link;
    }

    // Processes desc tags in the feed.
    private String readSummary(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "desc");
        String summary = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "desc");
        return summary;
    }

    // For the tags time and desc, extracts their text values.
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}