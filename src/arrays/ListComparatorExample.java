package arrays;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 19.12.12
 * Time: 13:45
 * To change this template use File | Settings | File Templates.
 */
public class ListComparatorExample {
    public static void main(String[] args){
        ListComparatorExample example = new ListComparatorExample();
        example.run();
    }

    public void run(){
        ArrayList<MyObject> list = new ArrayList<MyObject>();
        MyObject obj1 = new MyObject("Ivan","Smuriegin",23);
        MyObject obj2 = new MyObject("Vsevolod","Sayapin",24);
        MyObject obj3 = new MyObject("Maxim","Chernov", 22);

        list.add(obj1);
        list.add(obj2);
        list.add(obj3);

        print(list);

        Collections.sort(list);
        print(list);

        Collections.sort(list, new MyComparator1());
        print(list);

        Collections.sort(list, new MyComparator2());
        print(list);
    }

    public void print(List<MyObject> list){
        for (MyObject obj: list){
            System.out.println(obj.toString());
        }
        System.out.println();
    }

public class MyObject implements Comparable<MyObject>{
    private String firstName;
    private String secondName;
    private Integer age;

    public MyObject(String firstName, String secondName, Integer age){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String toString(){
        return firstName + " " + secondName + " age:" + age;
    }

    public int compareTo(MyObject o) {
        return age.compareTo(o.age);
    }
}

public class MyComparator1 implements Comparator<MyObject> {

    public int compare(MyObject o1, MyObject o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}

public class MyComparator2 implements Comparator<MyObject> {

    public int compare(MyObject o1, MyObject o2) {
        return o1.getSecondName().compareTo(o2.getSecondName());
    }
}
}
