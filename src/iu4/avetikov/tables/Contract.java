package iu4.avetikov.tables;

import iu4.avetikov.Table;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 26.09.13
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class Contract extends Table {
    private Integer contractID;
    private Date dateFrom;
    private Date dateTo;
    private String contractNumber;
    private Integer marketingCategoryID;

    public Contract(){
        super();
        this.contractID = null;
        this.dateFrom = null;
        this.dateTo = null;
        this.contractNumber = null;
        this.marketingCategoryID = null;
        System.out.println("Contract class");
    }

    public Contract(Integer contractID, Date dateFrom, Date dateTo,
                    String contractNumber, Integer marketingCategoryID){
        super();
        this.contractID = contractID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.contractNumber = contractNumber;
        this.marketingCategoryID = marketingCategoryID;
    }

    public void getRow() throws SQLException {
        super.getRow();

        try{
            if (this.query == null){
                this.query = "SELECT * FROM Contract WHERE ROWNUM = 1";
            }
            ResultSet resultSet = statement.executeQuery(this.query);
            while (resultSet.next()){
                this.contractID = resultSet.getInt("contractID");
                this.dateFrom = resultSet.getDate("dateFrom");
                this.dateTo = resultSet.getDate("dateTo");
                this.contractNumber = resultSet.getString("contractNumber");
                this.marketingCategoryID = resultSet.getInt("marketingCategoryID");
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
        return this.contractID+" || "+this.dateFrom+" || "+this.dateTo+
                " || "+this.contractNumber+" || "+this.marketingCategoryID;
    }

    public Integer getContractID() { return this.contractID; }
    public void setContractID(Integer contractID){ this.contractID = contractID; }

    public Date getDateFrom() { return this.dateFrom; }
    public void setDateFrom(Date dateFrom) { this.dateFrom = dateFrom; }

    public Date getDateTo() { return this.dateTo; }
    public void setDateTo(Date dateTo) { this.dateTo = dateTo; }

    public String getContractNumber() { return  this.contractNumber; }
    public  void  setContractNumber(String contractNumber) { this.contractNumber = contractNumber; }

    public Integer getMarketingCategoryID() { return this.marketingCategoryID; }
    public void setMarketingCategoryID(Integer marketingCategoryID) { this.marketingCategoryID = marketingCategoryID; }
}
