package org.basicjava.test.iu4.shevchik;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Shevchik
 * Date: 07.10.13
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
public class NMSortMy {
    private int[] mas = {1,2,3,4,5,6,7,8,9,2,4,6,8,1,3,5,6,2,3,4,8,9,10,10};
    private int m = 10;
    private int[] masFreq = new int[m+1];
    private int[] masSort = new int[mas.length];
    private int num = 0;

    public void frequency(int[] mas){
        for (int i = 0; i < mas.length; i++){
            //int freq = mas[i] % m;
            masFreq[mas[i]] = masFreq[mas[i]]+1;
        }
        System.out.println("Frequency array: " + Arrays.toString(masFreq));
    }

    public void sort(){
        for (int i = 1; i <= m; i++){
            if (masFreq[i] != 0){
                for (int k = 0; k < masFreq[i]; k++){
                    masSort[num] = i;
                    num++;
                }
            }
        }
        System.out.println("Num: " + num);
        System.out.println("Sorted array: " + Arrays.toString(masSort));
    }

    public static void main(String[] args){
        NMSortMy example = new NMSortMy();
        System.out.println("mas.length: " + example.mas.length);
        System.out.println("Started array: " + Arrays.toString(example.mas));
        example.frequency(example.mas);
        System.out.println("masSort.length: " + example.masSort.length);
        System.out.println("masSort array on start: " + Arrays.toString(example.masSort));
        example.sort();
    }
}