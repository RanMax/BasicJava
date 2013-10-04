package iu4.avetikov.crm_elem;

import java.sql.SQLException;

/**
 * User: Mr. Avetik
 * Date: 28.09.13
 * Time: 14:52
 */
public interface CrmElemFactory {

    public CrmElemInt getCrmElem(Long id, String Type);

    public interface CrmElemInt{
        Long getId();
        void getRow() throws SQLException;
    }
}
