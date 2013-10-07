package iu4.chernov.tel_dic.prop;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 18:23
 */
public class TL {
    private static Properties currLang;

    public static String getTW(String str){
        if (currLang != null) {
            String res = currLang.getProperty(str);
            if (res != null) return res;
            else return str;
        }
        else return str;
    }

    public static void load(String lang){
        currLang = new Properties();
        try{
            InputStreamReader reader = new InputStreamReader(new FileInputStream("lang/" + lang + ".properties"),"UTF8");

            System.out.println(reader.getEncoding());
            currLang.load(reader);
            reader.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
