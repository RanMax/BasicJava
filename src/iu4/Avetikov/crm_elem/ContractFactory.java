package iu4.Avetikov.crm_elem;

/**
 * User: Mr. Avetik
 * Date: 28.09.13
 * Time: 14:53
 */
public class ContractFactory extends AbstractFactory {
    public static String TYPE = "Contract";

    public CrmElemInt getCrmElem(Integer id, String Type) {
        return new Contract(id);
    }

    public class Contract extends AbstractCrmElem {
        public Contract(Integer id){
            super(id);
        }

    }
}
