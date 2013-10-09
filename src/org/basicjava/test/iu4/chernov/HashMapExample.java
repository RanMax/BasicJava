package org.basicjava.test.iu4.chernov;

import java.util.HashMap;
import java.util.HashSet;

/**
 * User: Maxim
 * Date: 23.09.13
 * Time: 20:09
 */
public class HashMapExample {
    public static void main (String[] args){
        HashMap<MyInteger,Human> map = new HashMap<MyInteger, Human>();
        MyInteger int1 = new MyInteger(1);
        MyInteger int2 = new MyInteger(1);
        MyInteger int3 = new MyInteger(1);

        map.put(int1,new Human("Seva"));
        map.put(int2,new Human("Max"));
        map.put(int3,new Human("Vano"));

        for (Human h: map.values()){
            System.out.println(h.toString());
        }

        HashSet<Human> set = new HashSet<Human>();

    }

    static class MyInteger{
        private int num;
        public MyInteger(int num){
          this.num = num;
        }
        public int hashCode(){
            return 0;
        }

        public boolean equals(Object o){
            return this.num == ((MyInteger)o).num;
        }
    }

    static class Human{
        String name;

        public Human(String name){
            this.name = name;
        }
        public String toString(){
            return name;
        };

    }
}
