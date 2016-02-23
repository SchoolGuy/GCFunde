package de.noname.enno.gcfunde.Adapters;

/*
 * @author Enno Gotthold
 * @version 0.1
 * This class should contain the XML reader/parser that stores the read data in the SQL database.
 * Because I am messing up with XML readers I won't comment this file out (-> I can't get them to work, when there is an interest to help, pls mail to SchoolGuy via Github. My Email is written down at README.md in {@docRoot})
 */

import android.app.Activity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class GeocachingXmlParser extends Activity {

    private static final String TAG = GeocachingXmlParser.class.getSimpleName();

    public GeocachingXmlParser() {
    }

    public String load(File file) {
        String str = "";
        FileInputStream fileInputStream;
        InputStreamReader isr = null;
        BufferedReader bis = null;
        try {
            fileInputStream = new FileInputStream(file);
            isr = new InputStreamReader(fileInputStream);
            bis = new BufferedReader(isr);
            for (String s = "";
                 s != null;
                 s = bis.readLine())
                str += s;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bis != null)
                    bis.close();
                if (isr != null)
                    isr.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return str;
    }

    public Document getDomElement(String xml){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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