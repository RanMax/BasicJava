package iu4.avetikov.crm_elem;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * User: Mr. Avetik
 * Date: 28.09.13
 * Time: 14:54
 */
public class PersonalAccountFactory extends AbstractFactory {
    public static String TYPE = "PersonalAccount";

    public CrmElemInt getCrmElem(Long id, String Type) {
        return new PersonalAccount(id);
    }

    public class PersonalAccount extends AbstractCrmElem{
        private Timestamp dateFrom;
        private Timestamp dateTo;
        private String personalAccountNumber;
        private Long calculationMethodID;

        public PersonalAccount(Long id) {
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
                    this.dateFrom = resultSet.getTimestamp("dateFrom");
                    this.dateTo = resultSet.getTimestamp("dateTo");
                    this.personalAccountNumber = resultSet.getString("personalAccountNumber");
                    this.calculationMethodID = resultSet.getLong("calculationMathodID");
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

        public Long getPersonalAccountID() { return this.id; }
        public void setPersonalAccountID(Long id) { this.id = id; }

        public Timestamp getDateFrom() { return this.dateFrom; }
        public void setDateFrom(Timestamp dateFrom) { this.dateFrom = dateFrom; }

        public Timestamp getDateTo() { return this.dateTo; }
        public void setDateTo(Timestamp dateTo) { this.dateTo = dateTo; }

        public String getPersonalAccountNumber() { return this.personalAccountNumber; }
        public void setPersonalAccountNumber(String personalAccountNumber) { this.personalAccountNumber = personalAccountNumber; }

        public Long getCalculationMethodID(){ return this.calculationMethodID; }
        public void setCalculationMethodID(Long calculationMethodID){ this.calculationMethodID = calculationMethodID; }
    }
}
