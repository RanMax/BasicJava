package org.basicjava.collections;

import java.util.Collection;

/**
 * User: Maxim
 * Date: 19.12.12
 * Time: 15:13
 */
public class PrintCollection {
    public static void print(Collection col){
        for (Object obj: col){
            System.out.println(obj.toString());
        }
    };
}
