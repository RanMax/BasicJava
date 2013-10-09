package org.basicjava.olymp;

import org.basicjava.arrays.ArraySortExample;

/**
 * User: mchernov
 * Date: 26.09.13
 * Time: 11:55
 */

/*
Дан массив размера n в котором содержатся положительные элементы
не больше m. Нужно отсортировать массив со сложностью O(n+m)
 */
public class NMSort {
    Integer[] mas = {9,8,3,4,5,6,100};
    int n = 7;
    int m = 101;

    public static void main(String[] args){
        NMSort ex = new NMSort();
        ex.run();
    }

    public void run(){
        System.out.println("Исходный массив:");
        ArraySortExample.printArray(mas);

        int[] sort = new int[m];
        for (int i = 0; i < n; i++){
            sort[mas[i]]++;
        }

        int counter = 0;
        for (int i = 0; i < m; i++){
            while (sort[i] != 0){
                mas[counter] = i;
                sort[i]--;
                counter++;
            }
        }

        System.out.println("Отсортированный массив:");
        ArraySortExample.printArray(mas);

        System.out.println("Число операцмй: " + counter);
    }

}
