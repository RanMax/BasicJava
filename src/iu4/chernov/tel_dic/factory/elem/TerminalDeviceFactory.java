package iu4.chernov.tel_dic.factory.elem;

import iu4.chernov.tel_dic.model.DBModel;

import java.sql.Timestamp;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 20:20
 */
public class TerminalDeviceFactory extends AbstractFactory {
    public static String TYPE = "TerminalDevice";

    public CrmElemInt getCrmElem(Long id, String Type) {
        return null;
    }

    public CrmElemInt getCrmElem(Long id, String Type, Timestamp date, DBModel model) {
        return null;
    }

    public CrmElemInt genCrmElem(Long id, String Type, Timestamp date) {
        return new TerminalDevice(id, date);
    }

    public class TerminalDevice extends AbstractCrmElem{
        Long personalAccount;

        public TerminalDevice(Long id, Timestamp date) {
            super(id,date);
        }

        public Long getPersonalAccount() {
            return personalAccount;
        }

        public void setPersonalAccount(Long personalAccount) {
            this.personalAccount = personalAccount;
        }
    }
}
