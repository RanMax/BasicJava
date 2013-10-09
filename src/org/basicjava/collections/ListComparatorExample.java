package org.basicjava.collections;

import java.util.*;

/**
 * User: Maxim
 * Date: 19.12.12
 * Time: 13:45
 */

public class ListComparatorExample {
    public static void main(String[] args){
        ListComparatorExample example = new ListComparatorExample();
        example.run();
    }

    public void run(){
        ArrayList<Human> list = new ArrayList<Human>();
        Human obj1 = new Human("Ivan","Smuriegin",23);
        Human obj2 = new Human("Vsevolod","Sayapin",24);
        Human obj3 = new Human("Maxim","Chernov", 22);

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

    public void print(List<Human> list){
        for (Human obj: list){
            System.out.println(obj.toString());
        }
        System.out.println();
    }

public class Human implements Comparable<Human>{
    private String firstName;
    private String secondName;
    private Integer age;

    public Human(String firstName, String secondName, Integer age){
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

    public int compareTo(Human o) {
        return age.compareTo(o.age);
    }
}

public class MyComparator1 implements Comparator<Human> {

    public int compare(Human o1, Human o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}

public class MyComparator2 implements Comparator<Human> {

    public int compare(Human o1, Human o2) {
        return o1.getSecondName().compareTo(o2.getSecondName());
    }
}
}
