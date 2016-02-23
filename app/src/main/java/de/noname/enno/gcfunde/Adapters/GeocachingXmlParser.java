package de.noname.enno.gcfunde.Adapters;

/*
 * @author Enno Gotthold
 * @version 0.1
 * This class should contain the XML reader/parser that stores the read data in the SQL database.
 * Because I am messing up with XML readers I won't comment this file out (-> I can't get them to work, when there is an interest to help, pls mail to SchoolGuy via Github. My Email is written down at README.md in {@docRoot})
 */

import android.app.Activity;
import android.os.Environment;
import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class GeocachingXmlParser extends Activity {

    private String ExternalAppBasePath;
    private static final String TAG = GeocachingXmlParser.class.getSimpleName();

    public GeocachingXmlParser(){
        ExternalAppBasePath = Environment.getExternalStorageDirectory().getPath() + File.separator + "GCFunde/";
    }

    public String load () {
        StringBuilder stringBuilder = new StringBuilder();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = openFileInput (ExternalAppBasePath + "3211604.gpx");
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append('\n');
                }
                stringBuilder.append(s);
            }
        } catch (IOException t) {
            Log.e(TAG, "load()",t);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    Log.e(TAG,"br.close()",e);
                }
            }
        }
        return  stringBuilder.toString();
    }

    public Document getDomElement(String xml){
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is);
        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (IOException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        }
        // return DOM
        return doc;
    }

    public String getValue(Element item, String str) {
        NodeList n = item.getElementsByTagName(str);
        return this.getElementValue(n.item(0));
    }

    public final String getElementValue( Node elem ) {
        Node child;
        if( elem != null){
            if (elem.hasChildNodes()){
                for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
                    if( child.getNodeType() == Node.TEXT_NODE  ){
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }
}