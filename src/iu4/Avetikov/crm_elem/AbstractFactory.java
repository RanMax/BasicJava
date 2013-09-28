package iu4.Avetikov.crm_elem;

import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 * User: Mr. Avetik
 * Date: 28.09.13
 * Time: 15:27
 */
public abstract class AbstractFactory implements CrmElemFactory {


    public abstract class AbstractCrmElem implements CrmElemInt{
        protected Integer id;

        public AbstractCrmElem(Integer id){
            this.id = id;
        }
        public Integer getId(){
            return id;
        }
    }
}
