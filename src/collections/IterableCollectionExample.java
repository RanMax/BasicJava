package collections;

import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 17.12.12
 * Time: 17:45
 * To change this template use File | Settings | File Templates.
 */
/* Примерр класса, реализующего интерфейс Iterable*/
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
