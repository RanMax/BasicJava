package collections;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 19.12.12
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
public class PrintCollection {
    public static void print(Collection col){
        for (Object obj: col){
            System.out.println(obj.toString());
        }
    };
}
