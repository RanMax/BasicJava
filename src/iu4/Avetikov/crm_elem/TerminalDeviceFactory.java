package iu4.Avetikov.crm_elem;

/**
 * User: Mr. Avetik
 * Date: 28.09.13
 * Time: 14:54
 */
public class TerminalDeviceFactory extends AbstractFactory {
    public static String TYPE = "TerminalDevice";

    public CrmElemInt getCrmElem(Integer id, String Type) {
        return null;
    }

    public class TerminalDevice extends AbstractCrmElem{
        public TerminalDevice(Integer id){
            super(id);
        }

    }
}
