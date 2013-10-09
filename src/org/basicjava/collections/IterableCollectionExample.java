package org.basicjava.collections;

import java.util.HashSet;

/**
 * User: Maxim
 * Date: 17.12.12
 * Time: 17:45
 */
/* Пример класса, реализующего интерфейс Iterable*/
public class IterableCollectionExample {
    public static void main(String[] args){
        HashSet<String> stringSet = new HashSet<String>();
        for (String str: stringSet){
            System.out.println(str);
        }

        IterableClassExample it = new IterableClassExample();
        for (String str: it){
            System.out.println(str);
        }
    }
}
