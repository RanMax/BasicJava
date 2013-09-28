package iu4.Avetikov.Tables;

import iu4.Avetikov.Table;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 26.09.13
 * Time: 22:29
 * To change this template use File | Settings | File Templates.
 */
public class TariffPlan extends Table {
    private Integer tariffPlanID;
    private String tariffPlanName;

    public TariffPlan(){
        super();
        this.tariffPlanID = null;
        this.tariffPlanName = null;
        System.out.println("TariffPlan class");
    }

    public TariffPlan(Integer tariffPlanID, String tariffPlanName){
        super();
        this.tariffPlanID = tariffPlanID;
        this.tariffPlanName = tariffPlanName;
    }

    public void getRow() throws SQLException {
        super.getRow();

        try{
            if (this.query == null){
                this.query = "SELECT * FROM TariffPlan WHERE ROWNUM = 1";
            }
            ResultSet resultSet = statement.executeQuery(this.query);
            while (resultSet.next()){
                this.tariffPlanID = resultSet.getInt("tariffPlanID");
                this.tariffPlanName = resultSet.getString("tariffPlanName");
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
        return this.tariffPlanID+" || "+this.tariffPlanName;
    }

    public Integer getTariffPlanID() {return this.tariffPlanID; }
    public void setTariffPlanID(Integer tariffPlanID) { this.tariffPlanID = tariffPlanID; }

    public String getTariffPlanName() { return this.tariffPlanName; }
    public void setTariffPlanName(String tariffPlanName) { this.tariffPlanName = tariffPlanName; }
}
