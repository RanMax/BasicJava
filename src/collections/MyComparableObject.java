package collections;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 18.12.12
 * Time: 16:54
 * To change this template use File | Settings | File Templates.
 */
public class MyComparableObject implements Comparable<MyComparableObject>{
    private String str;

    public MyComparableObject(String str){
        this.str = str;
    }

    public int compareTo(MyComparableObject o) {
        return str.compareTo(o.str);
    }

    public String toString(){
        return this.str;
    }
}
