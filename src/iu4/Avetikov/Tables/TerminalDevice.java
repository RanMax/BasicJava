package iu4.Avetikov.tables;

import iu4.Avetikov.Table;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 26.09.13
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 */
public class TerminalDevice extends Table {
    private Integer terminalDeviceID;
    private Date dateFrom;
    private Date dateTo;
    private Integer tariffPlanID;
    private String msisdn;

    public TerminalDevice(){
        super();
        this.terminalDeviceID = null;
        this.dateFrom = null;
        this.dateTo = null;
        this.tariffPlanID = null;
        this.msisdn = null;
        System.out.println("TerminalDeivce class");
    }

    public TerminalDevice(int terminalDeviceID, Date dateFrom, Date dateTo, int tariffPlanID, String msisdn){
        super();
        this.terminalDeviceID = terminalDeviceID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.tariffPlanID = tariffPlanID;
        this.msisdn = msisdn;
    }

    public void getRow() throws SQLException {
        super.getRow();

        try{
            if (this.query == null){
                this.query = "SELECT * FROM TerminalDevice WHERE ROWNUM = 1";
            }
            ResultSet resultSet = statement.executeQuery(this.query);
            while (resultSet.next()){
                this.terminalDeviceID = resultSet.getInt("terminalDeviceID");
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
        return this.terminalDeviceID+" || "+this.dateFrom+" || "+this.dateTo+
                " || "+this.tariffPlanID+" || "+this.msisdn;
    }

    public Integer getTerminalDeviceID() { return this.terminalDeviceID; }
    public void setTerminalDeviceID(Integer terminalDeviceID) { this.terminalDeviceID = terminalDeviceID; }

    public Date getDateFrom() { return this.dateFrom; }
    public void setDateFrom(Date dateFrom) { this.dateFrom = dateFrom; }

    public Date getDateTo() { return this.dateTo; }
    public void setDateTo(Date dateTo) { this.dateTo = dateTo; }

    public Integer getTariffPlanID() { return  this.tariffPlanID; }
    public void setTariffPlanID(Integer tariffPlanID) { this.tariffPlanID = tariffPlanID; }

    public String getMsisdn() { return this.msisdn; }
    public void setMsisdn(String msisdn) { this.msisdn = msisdn; }
}
