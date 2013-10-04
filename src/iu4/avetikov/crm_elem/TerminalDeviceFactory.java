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
public class TerminalDeviceFactory extends AbstractFactory {
    public static String TYPE = "TerminalDevice";

    public CrmElemInt getCrmElem(Long id, String Type) {
        return new TerminalDevice(id);
    }

    public class TerminalDevice extends AbstractCrmElem{
        private Timestamp dateFrom;
        private Timestamp dateTo;
        private Long tariffPlanID;
        private String msisdn;

        public TerminalDevice(Long id){
            super(id);
            this.dateFrom = null;
            this.dateTo = null;
            this.tariffPlanID = null;
            this.msisdn = null;
            System.out.println("TerminalDeivce class");
        }

        public void getRow() throws SQLException {
            super.getRow();

            try{
                if (this.query == null){
                    this.query = "SELECT * FROM TerminalDevice td WHERE td.terminalDeviceID = "+this.id+" and td.dateTo is null";
                }
                ResultSet resultSet = statement.executeQuery(this.query);
                while (resultSet.next()){
                    this.dateFrom = resultSet.getTimestamp("dateFrom");
                    this.dateTo = resultSet.getTimestamp("dateTo");
                    this.tariffPlanID = resultSet.getLong("tariffPlanID");
                    this.msisdn = resultSet.getString("msisdn");
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
                    " || "+this.tariffPlanID+" || "+this.msisdn;
        }

        public Long getTerminalDeviceID() { return this.id; }
        public void setTerminalDeviceID(Long terminalDeviceID) { this.id = terminalDeviceID; }

        public Timestamp getDateFrom() { return this.dateFrom; }
        public void setDateFrom(Timestamp dateFrom) { this.dateFrom = dateFrom; }

        public Timestamp getDateTo() { return this.dateTo; }
        public void setDateTo(Timestamp dateTo) { this.dateTo = dateTo; }

        public Long getTariffPlanID() { return  this.tariffPlanID; }
        public void setTariffPlanID(Long tariffPlanID) { this.tariffPlanID = tariffPlanID; }

        public String getMsisdn() { return this.msisdn; }
        public void setMsisdn(String msisdn) { this.msisdn = msisdn; }

    }
}
