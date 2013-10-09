package org.basicjava.collections;

import java.util.HashSet;

/**
 * User: Maxim
 * Date: 19.12.12
 * Time: 15:05
 */
/* Операции над множествами с использованием HashSet*/
public class SetOperationsExample {
    public static void main(String[] args){
        SetOperationsExample ex = new SetOperationsExample();
        ex.run();
    }

    public void run(){
        HashSet<MyObject> set1 = new HashSet<MyObject>();
        set1.add(new MyObject("Кошка"));
        set1.add(new MyObject("Собака"));
        set1.add(new MyObject("Обезьяна"));
        set1.add(new MyObject("Кошка"));

        System.out.println("Множество Set1:");
        PrintCollection.print(set1);

        HashSet<MyObject> set2 = new HashSet<MyObject>();
        set2.add(new MyObject("Собака"));
        set2.add(new MyObject("Обезьяна"));
        set2.add(new MyObject("Дельфин"));

        System.out.println("Множество Set2:");
        PrintCollection.print(set2);

        //Пересечение множеств
        HashSet<MyObject> copySet1 = new HashSet<MyObject>(set1);
        copySet1.retainAll(set2);
        System.out.println("Результат пересечения множеств Set1 и Set2:");
        PrintCollection.print(copySet1);

    }

    class MyObject{
        private String name;
        public MyObject(String name){
            this.name = name;
        }
        public String toString(){
            return name;
        }
        public int hashCode(){
            return name.hashCode();
        }
        public boolean equals(Object obj){
            return name.equals(((MyObject)obj).name);
        }

    }
}
