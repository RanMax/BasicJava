package org.basicjava.test.iu4.chernov.tel_dic.factory;

import org.basicjava.test.iu4.chernov.tel_dic.factory.elem.ContractFactory;
import org.basicjava.test.iu4.chernov.tel_dic.factory.elem.CrmElemFactory;
import org.basicjava.test.iu4.chernov.tel_dic.factory.elem.PersonalAccountFactory;
import org.basicjava.test.iu4.chernov.tel_dic.factory.elem.TerminalDeviceFactory;
import org.basicjava.test.iu4.chernov.tel_dic.model.DBModel;

import java.sql.Timestamp;
import java.util.HashMap;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 17:50
 */
public class Factory {
    private static DBModel defModel;
    private static Factory factory;

    private HashMap<String,CrmElemFactory> factories = new HashMap<String, CrmElemFactory>();

    public static CrmElemFactory.CrmElemInt getCrmElem(Long id, String type, Timestamp date){
        return getCrmElem(id,type,date,defModel);
    }

    public static CrmElemFactory.CrmElemInt getCrmElem(Long id, String type, Timestamp date, DBModel model){
        if (factory == null) factory = new Factory();
        return factory.getIntObject(id, type, date, model);
    }

    public static CrmElemFactory.CrmElemInt genCrmElem(Long id, String type, Timestamp date){
        if (factory == null) factory = new Factory();
        return factory.genIntObject(id, type, date);
    }

    public static void setDefaultModel(DBModel model){
        defModel = model;
    }

    private Factory(){
        factories.put(ContractFactory.TYPE, new ContractFactory());
        factories.put(PersonalAccountFactory.TYPE, new PersonalAccountFactory());
        factories.put(TerminalDeviceFactory.TYPE, new TerminalDeviceFactory());
    }

    private CrmElemFactory.CrmElemInt getIntObject(Long id, String type, Timestamp date, DBModel model){
        return factories.get(type).getCrmElem(id,type,date,model);
    }

    private CrmElemFactory.CrmElemInt genIntObject(Long id, String type, Timestamp date){
        return factories.get(type).genCrmElem(id, type, date);
    }


}
