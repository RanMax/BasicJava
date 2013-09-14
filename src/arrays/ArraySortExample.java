package arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 19.12.12
 * Time: 12:41
 * To change this template use File | Settings | File Templates.
 */
/* Сортировка массива с помощью Arrays*/
public class ArraySortExample {
    public static void main(String[] args){
        String[] mas = {"Abstract","Zebra", "inheritance","Polymorphism","Dimension"};
        ArraySortExample ex = new ArraySortExample();
        ex.printArray(mas);

        Arrays.sort(mas, String.CASE_INSENSITIVE_ORDER);
        ex.printArray(mas);

        Arrays.sort(mas, Collections.reverseOrder());
        ex.printArray(mas);
    }

    public void printArray(String[] mas){
        for (int i = 0; i < mas.length; i++){
            System.out.println(i + ":" + mas[i]);
        }
        System.out.println();
    }
}
