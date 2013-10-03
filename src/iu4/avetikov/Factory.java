package iu4.Avetikov;

import iu4.Avetikov.crm_elem.ContractFactory;
import iu4.Avetikov.crm_elem.CrmElemFactory;
import iu4.Avetikov.crm_elem.PersonalAccountFactory;
import iu4.Avetikov.crm_elem.TerminalDeviceFactory;

import java.util.HashMap;

/**
 * User: Mr. Avetik
 * Date: 28.09.13
 * Time: 16:19
 */
public class Factory {
    static private Factory factory;

    HashMap<String,CrmElemFactory> factories = new HashMap<String, CrmElemFactory>();


    public static CrmElemFactory.CrmElemInt getObject(Integer id, String type){
        if (factory == null) factory = new Factory();
        return factory.getIntObject(id,type);
    }

    private Factory(){
        factories.put(ContractFactory.TYPE, new ContractFactory());
        factories.put(PersonalAccountFactory.TYPE, new PersonalAccountFactory());
        factories.put(TerminalDeviceFactory.TYPE, new TerminalDeviceFactory());

    }

   private CrmElemFactory.CrmElemInt getIntObject(Integer id, String type){
        return factories.get(type).getCrmElem(id,type);
    }
}