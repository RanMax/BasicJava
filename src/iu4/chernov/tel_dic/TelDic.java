package iu4.chernov.tel_dic;

import iu4.chernov.tel_dic.contr.TelDicController;
import iu4.chernov.tel_dic.model.DBModel;
import iu4.chernov.tel_dic.prop.GP;

import javax.swing.*;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 17:38
 */
public class TelDic {
    public static final String PROP_LANG = "PROP_LANG";
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {System.out.println("Не удалось применить системный стиль для компонентов Swing");}

        TelDicController controller = new TelDicController();
        controller.start();
    }
}
