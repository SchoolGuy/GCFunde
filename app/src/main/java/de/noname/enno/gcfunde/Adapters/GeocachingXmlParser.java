package de.noname.enno.gcfunde.Adapters;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * @author Enno Gotthold
 * @version 0.1
 * This class should contain the XML reader/parser that stores the read data in the SQL database.
 * Because I am messing up with XML readers I won't comment this file out (-> I can't get them to work, when there is an interest to help, pls mail to SchoolGuy via Github. My Email is written down at README.md in {@docRoot})
 */

public class GeocachingXmlParser {
    private String country = "county";
    private String temperature = "temperature";
    private String humidity = "humidity";
    private String pressure = "pressure";
    private String urlString = null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;

    public GeocachingXmlParser(String url){
        this.urlString = url;
    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        String text=null;

        try {
            event = myParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT) {
                String name = myParser.getName();
                switch (event){
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(name.equals("country")){
                            country = text;
                        }
                        else if(name.equals("humidity")){
                            humidity = myParser.getAttributeValue(null,"value");
                        }
                        else if(name.equals("pressure")){
                            pressure = myParser.getAttributeValue(null,"value");
                        }
                        else if(name.equals("temperature")){
                            temperature = myParser.getAttributeValue(null,"value");
                        }
                        else{
                        }
                        break;
                } event = myParser.next();
            } parsingComplete = false;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fetchXML(){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();

                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream stream = conn.getInputStream();
                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myparser = xmlFactoryObject.newPullParser();

                    myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myparser.setInput(stream, null);

                    parseXMLAndStoreIt(myparser);
                    stream.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}