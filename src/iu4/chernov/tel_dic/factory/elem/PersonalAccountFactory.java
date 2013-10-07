package iu4.chernov.tel_dic.factory.elem;

import iu4.chernov.tel_dic.model.DBModel;

import java.sql.Timestamp;
import java.util.HashSet;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 20:20
 */
public class PersonalAccountFactory extends AbstractFactory {
    public static String TYPE = "PersonalAccount";


    public CrmElemInt getCrmElem(Long id, String Type, Timestamp date, DBModel model) {
        return null;
    }

    public CrmElemInt genCrmElem(Long id, String type, Timestamp date) {
        return new PersonalAccount(id,date);
    }

    public class PersonalAccount extends AbstractCrmElem{
        Long contractId;

        public PersonalAccount(Long id, Timestamp date) {
            super(id,date);
        }

        public Long getContractId() {
            return contractId;
        }

        public void setContractId(Long contractId) {
            this.contractId = contractId;
        }
    }
}
