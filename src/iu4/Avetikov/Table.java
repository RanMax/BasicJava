package iu4.Avetikov;

/**
 * Created by IntelliJ IDEA.
 * User: Mr. Avetik
 * Date: 21.09.13
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 */
public class Table{
    private int id;
    private String gorod;
    private String region;

    public Table(){
        this.id = 0;
        this.gorod = "";
        this.region = "";
    }

    public Table(int id, String gorod, String region){
        this.id = id;
        this.gorod = gorod;
        this.region = region;
    }

    public int GetId(){
        return this.id;
    }

    public String GetGorod(){
        return this.gorod;
    }

    public String GetRegion(){
        return this.region;
    }

    public String toString(){
        return this.id+" "+this.gorod+" "+this.region;
    }
}
