package iu4.avetikov.factory;

import iu4.avetikov.Table;
import iu4.avetikov.tables.*;

/**
 * Created with IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 26.09.13
 * Time: 23:37
 * To change this template use File | Settings | File Templates.
 */
public class TableFactory {
    public Table getTable(String type){
        Table table = new Table();

        if (type == "TerminalDevice"){ table = new TerminalDevice(); }
        else if (type == "PersonalAccountTD"){ table = new PersonalAccountTD(); }
        else if (type == "PersonalAccount"){ table = new PersonalAccount(); }
        else if (type == "ContractPersonalAccount") {table = new ContractPersonalAccount(); }
        else if (type == "Contract") { table = new Contract(); }
        else if (type == "TariffPlan") { table = new TariffPlan(); }
        else if (type == "MarketingCategory") { table = new MarketingCategory(); }
        else if (type == "CalculationMethod") { table = new CalculationMethod(); }

        System.out.println("Производим Класс...");

        return table;
    }
}
