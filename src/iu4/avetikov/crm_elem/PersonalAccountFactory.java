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
        private Long personalAccountNumber;
        private Long calculationMethodID;

        public PersonalAccount(Long id) {
            super(id);
            this.dateFrom = null;
            this.dateTo = null;
            this.personalAccountNumber = null;
            this.calculationMethodID = null;
        }

        public void getRow() throws SQLException {
            super.getRow();
            this.connection = super.connection;
            this.statement = super.statement;

            try{
                if (this.query == null){
                    this.query = "SELECT * FROM PersonalAccount pa WHERE pa.personalAccountID = "+this.id+" and pa.dateTo is null";
                }
                ResultSet resultSet = statement.executeQuery(this.query);
                while (resultSet.next()){
                    this.dateFrom = resultSet.getTimestamp("dateFrom");
                    this.dateTo = resultSet.getTimestamp("dateTo");
                    this.personalAccountNumber = resultSet.getLong("personalAccountNumber");
                    this.calculationMethodID = resultSet.getLong("calculationMathodID");
                }
            }catch (SQLException e) {
                System.err.println("Не получилось...");
                e.printStackTrace();
                System.exit(1);
            }
        }

        public void getRow(Timestamp date) throws SQLException {
            super.getRow();
            this.query = "SELECT pa.* " +
                         "  FROM PersonalAccount pa " +
                         " WHERE pa.personalAccountID = "+this.id+" " +
                         "   and pa.dateFrom < '"+date+"' " +
                         "   and COALESCE(pa.dateTo, CURRENT_DATE) > '"+date+"';";
            this.getRow();
        }

        public String toString(){
            return "PA: "+this.id+" | "+this.dateFrom+" | "+this.dateTo+
                    " | "+this.personalAccountNumber+" | "+this.calculationMethodID;
        }

        public Long getPersonalAccountID() { return this.id; }
        public void setPersonalAccountID(Long id) { this.id = id; }

        public Timestamp getDateFrom() { return this.dateFrom; }
        public void setDateFrom(Timestamp dateFrom) { this.dateFrom = dateFrom; }

        public Timestamp getDateTo() { return this.dateTo; }
        public void setDateTo(Timestamp dateTo) { this.dateTo = dateTo; }

        public Long getPersonalAccountNumber() { return this.personalAccountNumber; }
        public void setPersonalAccountNumber(Long personalAccountNumber) { this.personalAccountNumber = personalAccountNumber; }

        public Long getCalculationMethodID(){ return this.calculationMethodID; }
        public void setCalculationMethodID(Long calculationMethodID){ this.calculationMethodID = calculationMethodID; }
    }
}
