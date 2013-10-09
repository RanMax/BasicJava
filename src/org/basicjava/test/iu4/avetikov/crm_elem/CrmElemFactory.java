package org.basicjava.test.iu4.avetikov.crm_elem;

import javax.swing.tree.TreeModel;
import java.sql.SQLException;
import java.sql.Timestamp;

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
        void getRow(Timestamp date) throws SQLException;
        TreeModel getTree(Timestamp date) throws SQLException;
    }
}
