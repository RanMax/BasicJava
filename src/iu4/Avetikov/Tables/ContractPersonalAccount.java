package iu4.Avetikov.Tables;
import iu4.Avetikov.Table;

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
public class ContractPersonalAccount extends Table {
    private Integer contractPersonalAccountID;
    private Date dateFrom;
    private Date dateTo;
    private Integer contractID;
    private Integer personalAccountID;

    public ContractPersonalAccount(){
        super();
        this.contractPersonalAccountID = null;
        this.dateFrom = null;
        this.dateTo = null;
        this.contractID = null;
        this.personalAccountID = null;
        System.out.println("ContractPersonalAccount class");
    }

    public ContractPersonalAccount(Integer contractPersonalAccountID, Date dateFrom, Date dateTo,
                                   Integer contractID, Integer personalAccountID){
        super();
        this.contractPersonalAccountID = contractPersonalAccountID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.contractID = contractID;
        this.personalAccountID = personalAccountID;
    }

    public void getRow() throws SQLException {
        super.getRow();

        try{
            if (this.query == null){
                this.query = "SELECT * FROM ContractPersonalAccount WHERE ROWNUM = 1";
            }
            ResultSet resultSet = statement.executeQuery(this.query);
            while (resultSet.next()){
                this.contractPersonalAccountID = resultSet.getInt("contractPersonalAccountID");
                this.dateFrom = resultSet.getDate("dateFrom");
                this.dateTo = resultSet.getDate("dateTo");
                this.contractID = resultSet.getInt("contractID");
                this.personalAccountID = resultSet.getInt("personalAccountID");
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
        return this.contractPersonalAccountID+" || "+this.dateFrom+ " || "+this.dateTo+
                " || "+this.contractID+" || "+this.personalAccountID;
    }

    public Integer getContractPersonalAccountID() { return this.contractPersonalAccountID; }
    public void setContractPersonalAccountID(Integer contractPersonalAccountID) { this.contractPersonalAccountID = contractPersonalAccountID; }

    public Date getDateFrom() { return this.dateFrom; }
    public void setDateFrom(Date dateFrom) { this.dateFrom = dateFrom; }

    public Date getDateTo() { return this.dateTo; }
    public void setDateTo(Date dateTo) { this.dateTo = dateTo; }

    public Integer getContractID() { return this.contractID; }
    public void setContractID(Integer contractID) { this.contractID = contractID; }

    public Integer getPersonalAccountID() { return this.personalAccountID; }
    public void setPersonalAccountID(Integer personalAccountID) { this.personalAccountID = personalAccountID; }
}
