package org.basicjava.test.iu4.avetikov.tables;

import org.basicjava.test.iu4.avetikov.Table;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 26.09.13
 * Time: 22:29
 * To change this template use File | Settings | File Templates.
 */
public class PersonalAccountTD extends Table {
    private Integer personalAccountTDID;
    private Date dateFrom;
    private Date dateTo;
    private Integer personalAccountID;
    private Integer terminalDeviceID;

    public PersonalAccountTD() {
        super();
        this.personalAccountTDID = null;
        this.dateFrom = null;
        this.dateTo = null;
        this.personalAccountID = null;
        this.terminalDeviceID = null;
        System.out.println("PersonalAccountTD class");
    }

    public PersonalAccountTD(Integer personalAccountTDID, Date dateFrom, Date dateTo,
                             Integer personalAccountID, Integer terminalDeviceID){
        super();
        this.personalAccountTDID = personalAccountTDID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.personalAccountID = personalAccountID;
        this.terminalDeviceID = terminalDeviceID;
    }

    public void getRow() throws SQLException {
        super.getRow();

        try{
            if (this.query == null){
                this.query = "SELECT * FROM ContractPersonalAccount WHERE ROWNUM = 1";
            }
            ResultSet resultSet = statement.executeQuery(this.query);
            while (resultSet.next()){
                this.personalAccountTDID = resultSet.getInt("personalAccountTDID");
                this.dateFrom = resultSet.getDate("dateFrom");
                this.dateTo = resultSet.getDate("dateTo");
                this.personalAccountID = resultSet.getInt("personalAccountID");
                this.terminalDeviceID = resultSet.getInt("terminalDeviceID");
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
        return this.personalAccountTDID+" || "+this.dateFrom+" || "+this.dateTo+
                " || "+this.personalAccountID+" || "+this.terminalDeviceID;
    }

    public Integer getPersonalAccountTDID() { return this.personalAccountTDID; }
    public void setPersonalAccountTDID(Integer personalAccountTDID) { this.personalAccountTDID = personalAccountTDID; }

    public Date getDateFrom() { return this.dateFrom; }
    public void setDateFrom(Date dateFrom) { this.dateFrom = dateFrom; }

    public Date getDateTo() { return this.dateTo; }
    public void setDateTo(Date dateTo) { this.dateTo = dateTo; }

    public Integer getPersonalAccountID() { return this.personalAccountID; }
    public void setPersonalAccountID(Integer personalAccountID) { this.personalAccountID = personalAccountID; }

    public Integer getTerminalDeviceID() { return this.terminalDeviceID; }
    public void setTerminalDeviceID(Integer terminalDeviceID) { this.terminalDeviceID = terminalDeviceID; }
}
