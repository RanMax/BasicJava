package iu4.chernov.tel_dic.factory.elem;

import iu4.chernov.tel_dic.model.DBModel;

import java.sql.Timestamp;
import java.util.HashSet;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 17:37
 */
public class ContractFactory extends AbstractFactory {
    public static String TYPE = "Contract";

    public CrmElemInt getCrmElem(Long id, String Type, Timestamp date, DBModel model) {
        return null;
    }

    public CrmElemInt genCrmElem(Long id, String Type, Timestamp date) {
        return new Contract(id, date);
    }

    public class Contract extends AbstractFactory.AbstractCrmElem{
        public Contract(Long id, Timestamp date) {
            super(id,date);
        }
    }
}
