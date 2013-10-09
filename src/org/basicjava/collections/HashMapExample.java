package org.basicjava.collections;

import java.util.Collection;
import java.util.HashMap;

/**
 * User: Maxim
 * Date: 19.12.12
 * Time: 17:08
 */
/* Пример использования коллекции HashMap*/
public class HashMapExample {
    public static void main(String[] args){
        HashMapExample ex = new HashMapExample();
        ex.run();
    }

    public void run(){

        Person p1 = new Person(1,"Maxim Chernov");
        Person p2 = new Person(2,"Ivan Smuriegin");
        Person p3 = new Person(3,"Vsevolod Sayapin");
        Person p4 = new Person(3,"Alexander Bogdanov");

        HashMap<Person,Person> map = new HashMap<Person,Person>();
        map.put(p1,p1);
        map.put(p2,p2);
        map.put(p3,p3);
        map.put(p4,p4);

        System.out.println(map.get(3));
        System.out.println();

        Collection<Person> collect = map.values();
        for (Person p: collect){
            System.out.println(p);
        }
    }

    class Person{
        private Integer personId;
        private String personName;

        public Person(Integer personId, String personName){
            this.personId = personId;
            this.personName = personName;
        }

        public Integer getPersonId() {
            return personId;
        }

        /*public String toString(){
            return personName;
        }*/

        public int hashCode(){
            return personId;
        }

        public boolean equals(Object obj){
            return false; //personId.equals(((Person)obj).getPersonId());

        }
        Object o;

    }
}
