package iu4.Avetikov.tables;

import iu4.Avetikov.Table;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 26.09.13
 * Time: 22:48
 * To change this template use File | Settings | File Templates.
 */
public class CalculationMethod extends Table {
    private Integer calculationMethodID;
    private String calculationMethodName;

    public CalculationMethod(){
        super();
        this.calculationMethodID = null;
        this.calculationMethodName = null;
        System.out.println("CalculationMethod class");
    }

    public CalculationMethod(Integer calculationMethodID, String calculationMethodName){
        super();
        this.calculationMethodID = calculationMethodID;
        this.calculationMethodName = calculationMethodName;
    }

    public void getRow() throws SQLException {
        super.getRow();

        try{
            if (this.query == null){
                this.query = "SELECT * FROM CalculationMethod WHERE ROWNUM = 1";
            }
            ResultSet resultSet = statement.executeQuery(this.query);
            while (resultSet.next()){
            this.calculationMethodID = resultSet.getInt("calculationMethodID");
            this.calculationMethodName = resultSet.getString("calculationMethodName");
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
        return this.calculationMethodID+" || "+this.calculationMethodName;
    }

    public Integer getCalculationMethodID(){ return this.calculationMethodID; }
    public void setCalculationMethodID(Integer calculationMethodID){ this.calculationMethodID = calculationMethodID; }

    public String getCalculationMethodName(){ return this.calculationMethodName; }
    public void setCalculationMethodName(String calculationMethodName){ this.calculationMethodName = calculationMethodName; }
}
