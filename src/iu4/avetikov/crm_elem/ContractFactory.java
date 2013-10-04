package iu4.avetikov.crm_elem;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Mr. Avetik
 * Date: 28.09.13
 * Time: 14:53
 */
public class ContractFactory extends AbstractFactory {
    public static String TYPE = "Contract";

    public CrmElemInt getCrmElem(Long id, String Type) {
        return new Contract(id);
    }

    public class Contract extends AbstractCrmElem {
        private Timestamp dateFrom;
        private Timestamp dateTo;
        private String contractNumber;
        private Long marketingCategoryID;

        public Contract(Long id){
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
                    this.dateFrom = resultSet.getTimestamp("dateFrom");
                    this.dateTo = resultSet.getTimestamp("dateTo");
                    this.contractNumber = resultSet.getString("contractNumber");
                    this.marketingCategoryID = resultSet.getLong("marketingCategoryID");
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

        public Long getContractID() { return this.id; }
        public void setContractID(Long id){ this.id = id; }

        public Timestamp getDateFrom() { return this.dateFrom; }
        public void setDateFrom(Timestamp dateFrom) { this.dateFrom = dateFrom; }

        public Timestamp getDateTo() { return this.dateTo; }
        public void setDateTo(Timestamp dateTo) { this.dateTo = dateTo; }

        public String getContractNumber() { return  this.contractNumber; }
        public  void  setContractNumber(String contractNumber) { this.contractNumber = contractNumber; }

        public Long getMarketingCategoryID() { return this.marketingCategoryID; }
        public void setMarketingCategoryID(Long marketingCategoryID) { this.marketingCategoryID = marketingCategoryID; }
    }
}
