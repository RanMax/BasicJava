package org.basicjava.test.iu4.chernov.tel_dic.prop;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 17:47
 */
public class GP {
    private static Properties property;

    public static String getProp(String prop){
        if (property == null) load();
        return (String) property.get(prop);
    }

    private static void load(){
        property = new Properties();
        try{
            InputStreamReader reader = new InputStreamReader(new FileInputStream(".//prop//tel_dic//property.properties"),"UTF8");

            System.out.println(reader.getEncoding());
            property.load(reader);
            reader.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
