package iu4.chernov.tel_dic.factory.elem;

import java.sql.Timestamp;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 17:34
 */
abstract public class AbstractFactory implements CrmElemFactory {
    public abstract class AbstractCrmElem implements CrmElemFactory.CrmElemInt {
        protected Long id;
        protected Long number;
        protected Timestamp date;
        protected Timestamp dateFrom;
        protected Timestamp dateTo;

        public AbstractCrmElem(Long id, Timestamp date){
            this.id = id;
            this.date = date;
        }

        public Long getId(){
            return id;
        }

        public Long getNumber() {
            return number;
        }

        public void setNumber(Long number) {
            this.number = number;
        }

        public Timestamp getDateFrom() {
            return dateFrom;
        }

        public void setDateFrom(Timestamp dateFrom) {
            this.dateFrom = dateFrom;
        }

        public Timestamp getDateTo() {
            return dateTo;
        }

        public void setDateTo(Timestamp dateTo) {
            this.dateTo = dateTo;
        }
    }
}
