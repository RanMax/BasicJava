package org.basicjava.test.iu4.avetikov.tables;

import org.basicjava.test.iu4.avetikov.Table;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 26.09.13
 * Time: 22:29
 * To change this template use File | Settings | File Templates.
 */
public class MarketingCategory extends Table {
    private Integer marketingCategoryID;
    private String marketingCategoryName;

    public MarketingCategory(){
        super();
        this.marketingCategoryID = null;
        this.marketingCategoryName = null;
        System.out.println("MarketingCategory class");
    }

    public void getRow() throws SQLException {
        super.getRow();

        try{
            if (this.query == null){
                this.query = "SELECT * FROM MarketingCategory WHERE ROWNUM = 1";
            }
            ResultSet resultSet = statement.executeQuery(this.query);
            while (resultSet.next()){
                this.marketingCategoryID = resultSet.getInt("marketingCategoryID");
                this.marketingCategoryName = resultSet.getString("marketingCategoryName");
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

    public MarketingCategory(Integer marketingCategoryID, String marketingCategoryName){
        super();
        this.marketingCategoryID = marketingCategoryID;
        this.marketingCategoryName = marketingCategoryName;
    }

    public String toString(){
        return  this.marketingCategoryID+" || "+this.marketingCategoryName;
    }

    public Integer getMarketingCategoryID() { return this.marketingCategoryID; }
    public void setMarketingCategoryID(Integer marketingCategoryID) { this.marketingCategoryID = marketingCategoryID; }

    public String getMarketingCategoryName() { return this.marketingCategoryName; }
    public void setMarketingCategoryName(String marketingCategoryName) { this.marketingCategoryName = marketingCategoryName; }
}
