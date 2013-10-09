package org.basicjava.test.iu4.avetikov.tables;

import org.basicjava.test.iu4.avetikov.Table;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 26.09.13
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class PersonalAccount extends Table {
    private Integer personalAccountID;
    private Date dateFrom;
    private Date dateTo;
    private String personalAccountNumber;
    private Integer calculationMethodID;

    public PersonalAccount(){
        super();
        this.personalAccountID = null;
        this.dateFrom = null;
        this.dateTo = null;
        this.personalAccountNumber = null;
        this.calculationMethodID = null;
        System.out.println("PersonalAccount class");
    }

    public PersonalAccount(Integer personalAccountID, Date dateFrom, Date dateTo,
                           String personalAccountNumber, Integer calculationMethodID){
        super();
        this.personalAccountID = personalAccountID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.personalAccountNumber = personalAccountNumber;
        this.calculationMethodID = calculationMethodID;
    }

    public String toString(){
        return this.personalAccountID+" || "+this.dateFrom+" || "+this.dateTo+
                " || "+this.personalAccountNumber+" || "+this.calculationMethodID;
    }

    public Integer getPersonalAccountID() { return this.personalAccountID; }
    public void setPersonalAccountID(Integer personalAccountID) { this.personalAccountID = personalAccountID; }

    public Date getDateFrom() { return this.dateFrom; }
    public void setDateFrom(Date dateFrom) { this.dateFrom = dateFrom; }

    public Date getDateTo() { return this.dateTo; }
    public void setDateTo(Date dateTo) { this.dateTo = dateTo; }

    public String getPersonalAccountNumber() { return this.personalAccountNumber; }
    public void setPersonalAccountNumber(String personalAccountNumber) { this.personalAccountNumber = personalAccountNumber; }

    public Integer getCalculationMethodID(){ return this.calculationMethodID; }
    public void setCalculationMethodID(Integer calculationMethodID){ this.calculationMethodID = calculationMethodID; }
}
