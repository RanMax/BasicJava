package collections;

import java.util.TreeSet;

/**
 * User: Maxim
 * Date: 18.12.12
 * Time: 16:56
 */
/* Использование интерфейса Comparable для сортировки элементов*/
public class ComparableExample {
    public static void main(String[] args){
        ComparableExample ex = new ComparableExample();
        ex.run();
    }

    public void run(){
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
}
