package org.basicjava.test.iu4.chernov.tel_dic.factory.elem;

import org.basicjava.test.iu4.chernov.tel_dic.model.DBModel;

import java.sql.Timestamp;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 17:32
 */
public interface CrmElemFactory {
    public CrmElemInt getCrmElem(Long id, String Type, Timestamp date, DBModel model);
    public CrmElemInt genCrmElem(Long id, String Type, Timestamp date);

    public interface CrmElemInt{
        public Long getId();
        public Long getNumber();

        public void setNumber(Long number);
        public Timestamp getDateFrom();

        public void setDateFrom(Timestamp dateFrom);
        public Timestamp getDateTo();

        public void setDateTo(Timestamp dateTo);
    }
}
