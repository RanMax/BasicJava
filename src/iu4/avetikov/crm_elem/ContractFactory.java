package iu4.avetikov.crm_elem;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Mr. Avetik
 * Date: 28.09.13
 * Time: 14:53
 */
public class ContractFactory extends AbstractFactory {
    public static String TYPE = "Contract";

    public CrmElemInt getCrmElem(Integer id, String Type) {
        return new Contract(id);
    }

    public class Contract extends AbstractCrmElem {
        private Date dateFrom;
        private Date dateTo;
        private String contractNumber;
        private Integer marketingCategoryID;

        public Contract(Integer id){
            super(id);
            this.dateFrom = null;
            this.dateTo = null;
            this.contractNumber = null;
            this.marketingCategoryID = null;
            System.out.println("Contract class");
        }

        public void getRow() throws SQLException {
            super.getRow();

            try{
                if (this.query == null){
                    this.query = "SELECT * FROM Contract c WHERE c.contractID = "+this.id+" and c.dateTo is null";
                }
                ResultSet resultSet = statement.executeQuery(this.query);
                while (resultSet.next()){
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
            return this.id+" || "+this.dateFrom+" || "+this.dateTo+
                    " || "+this.contractNumber+" || "+this.marketingCategoryID;
        }

        public Integer getContractID() { return this.id; }
        public void setContractID(Integer id){ this.id = id; }

        public Date getDateFrom() { return this.dateFrom; }
        public void setDateFrom(Date dateFrom) { this.dateFrom = dateFrom; }

        public Date getDateTo() { return this.dateTo; }
        public void setDateTo(Date dateTo) { this.dateTo = dateTo; }

        public String getContractNumber() { return  this.contractNumber; }
        public  void  setContractNumber(String contractNumber) { this.contractNumber = contractNumber; }

        public Integer getMarketingCategoryID() { return this.marketingCategoryID; }
        public void setMarketingCategoryID(Integer marketingCategoryID) { this.marketingCategoryID = marketingCategoryID; }
    }
}
