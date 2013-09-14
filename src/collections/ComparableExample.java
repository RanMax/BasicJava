package collections;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 18.12.12
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
/* Использование интерфейса Comparable для перебора элементов*/
public class ComparableExample {
    public static void main(String[] args){
        TreeSet<MyComparableObject> set = new TreeSet<MyComparableObject>();

        MyComparableObject obj1 = new MyComparableObject("Zebra");
        MyComparableObject obj2 = new MyComparableObject("Abstract");
        MyComparableObject obj3 = new MyComparableObject("Inheritance");

        set.add(obj1);
        set.add(obj2);
        set.add(obj3);

        for (MyComparableObject obj: set){
            System.out.println(obj.toString());
        }
    }
}
