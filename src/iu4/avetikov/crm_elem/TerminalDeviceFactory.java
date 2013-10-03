package iu4.avetikov.crm_elem;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Mr. Avetik
 * Date: 28.09.13
 * Time: 14:54
 */
public class TerminalDeviceFactory extends AbstractFactory {
    public static String TYPE = "TerminalDevice";

    public CrmElemInt getCrmElem(Integer id, String Type) {
        return new TerminalDevice(id);
    }

    public class TerminalDevice extends AbstractCrmElem{
        private Date dateFrom;
        private Date dateTo;
        private Integer tariffPlanID;
        private String msisdn;

        public TerminalDevice(Integer id){
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
                    this.dateFrom = resultSet.getDate("dateFrom");
                    this.dateTo = resultSet.getDate("dateTo");
                    this.tariffPlanID = resultSet.getInt("tariffPlanID");
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

        public Integer getTerminalDeviceID() { return this.id; }
        public void setTerminalDeviceID(Integer terminalDeviceID) { this.id = terminalDeviceID; }

        public Date getDateFrom() { return this.dateFrom; }
        public void setDateFrom(Date dateFrom) { this.dateFrom = dateFrom; }

        public Date getDateTo() { return this.dateTo; }
        public void setDateTo(Date dateTo) { this.dateTo = dateTo; }

        public Integer getTariffPlanID() { return  this.tariffPlanID; }
        public void setTariffPlanID(Integer tariffPlanID) { this.tariffPlanID = tariffPlanID; }

        public String getMsisdn() { return this.msisdn; }
        public void setMsisdn(String msisdn) { this.msisdn = msisdn; }

    }
}
