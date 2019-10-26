package de.schoolguy.gcfunde.Adapters;

/**
 * @author Enno Gotthold
 * @version 0.1
 * This class should convert a string array into a string and backwards.
 * Source: {@see http://stackoverflow.com/questions/9053685/android-sqlite-saving-string-array}
 */
public class StringToArray {
    public static String strSeparator = "__,__";
    public String convertArrayToString(String[] array){
        String str = "";
        for (int i = 0;i<array.length; i++) {
            str = str+array[i];
            // Do not append comma at the end of last element
            if(i<array.length-1){
                str = str+strSeparator;
            }
        }
        return str;
    }
    public String[] convertStringToArray(String str){
        String[] arr = str.split(strSeparator);
        return arr;
    }
}
