package virtual_filesystem.prop;

import virtual_filesystem.containers.LangTag;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 25.12.12
 * Time: 23:38
 * To change this template use File | Settings | File Templates.
 */
public class TL {
    public static String OPEN = "OPEN";
    public static String LOAD_FILE_CATALOGS = "LOAD_FILE_CATALOGS";
    public static String CATALOG_NAME = "CATALOG_NAME";
    public static String CATALOG_ID = "CATALOG_ID";
    public static String CATALOG_SEQ = "CATALOG_SEQ";
    public static String CATALOG_STATUS = "CATALOG_STATUS";
    public static String LOAD_FILE_CATALOGS_FIN = "LOAD_FILE_CATALOGS_FIN";
    public static String LOAD_FILE_LOCATIONS = "LOAD_FILE_LOCATIONS";
    public static String FILE = "FILE";
    public static String LANG = "LANG";
    public static String OPTIONS = "OPTIONS";
    public static String FILE_INSPECTOR = "FILE_INSPECTOR";
    public static String FILE_MANAGER = "FILE_MANAGER";


    private static Properties currLang;
    private static ArrayList<LangTag> listLang;

    public static String getTW(String str){
        if (currLang != null) return currLang.getProperty(str);
        else return str;
    }

    public static void load(String lang){
        listLang = new ArrayList<LangTag>();
        currLang = new Properties();
        try{
            FileReader reader = new FileReader("lang/" + lang + ".properties");
		    currLang.load(reader);
		    reader.close();
            File file = new File("lang");
            String[] list = file.list();
            for (int i = 0; i < list.length; i++){
                String tag = list[i].substring(0,list[i].length() - 11);
                LangTag langTag = new LangTag(tag);
                langTag.setName(currLang.getProperty(tag));
                listLang.add(langTag);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static ArrayList<LangTag> getListLang() {
        return listLang;
    }
}
