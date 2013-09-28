package iu4.Avetikov.crm_elem;

/**
 * User: Mr. Avetik
 * Date: 28.09.13
 * Time: 14:54
 */
public class PersonalAccountFactory extends AbstractFactory {
    public static String TYPE = "PersonalAccount";

    public CrmElemInt getCrmElem(Integer id, String Type) {
        return new PersonalAccount(id);
    }

    public class PersonalAccount extends AbstractCrmElem{
        public PersonalAccount(Integer id) {
            super(id);
        }
    }
}
