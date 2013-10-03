package iu4.avetikov.crm_elem;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        private Date dateFrom;
        private Date dateTo;
        private String personalAccountNumber;
        private Integer calculationMethodID;

        public PersonalAccount(Integer id) {
            super(id);
            this.dateFrom = null;
            this.dateTo = null;
            this.personalAccountNumber = null;
            this.calculationMethodID = null;
            System.out.println("PersonalAccount class");
        }

        public void getRow() throws SQLException {
            super.getRow();

            try{
                if (this.query == null){
                    this.query = "SELECT * FROM PersonalAccount pa WHERE pa.personalAccountID = "+this.id+" and pa.dateTo is null";
                }
                ResultSet resultSet = statement.executeQuery(this.query);
                while (resultSet.next()){
                    this.dateFrom = resultSet.getDate("dateFrom");
                    this.dateTo = resultSet.getDate("dateTo");
                    this.personalAccountNumber = resultSet.getString("personalAccountNumber");
                    this.calculationMethodID = resultSet.getInt("calculationMethodID");
                }
            }catch (SQLException e) {
                System.err.println("Не получилось...");
                e.printStackTrace();
                System.exit(1);
            }finally {
                statement.close();
                connection.close();
            }
        }

        public String toString(){
            return this.id+" || "+this.dateFrom+" || "+this.dateTo+
                    " || "+this.personalAccountNumber+" || "+this.calculationMethodID;
        }

        public Integer getPersonalAccountID() { return this.id; }
        public void setPersonalAccountID(Integer id) { this.id = id; }

        public Date getDateFrom() { return this.dateFrom; }
        public void setDateFrom(Date dateFrom) { this.dateFrom = dateFrom; }

        public Date getDateTo() { return this.dateTo; }
        public void setDateTo(Date dateTo) { this.dateTo = dateTo; }

        public String getPersonalAccountNumber() { return this.personalAccountNumber; }
        public void setPersonalAccountNumber(String personalAccountNumber) { this.personalAccountNumber = personalAccountNumber; }

        public Integer getCalculationMethodID(){ return this.calculationMethodID; }
        public void setCalculationMethodID(Integer calculationMethodID){ this.calculationMethodID = calculationMethodID; }
    }
}
