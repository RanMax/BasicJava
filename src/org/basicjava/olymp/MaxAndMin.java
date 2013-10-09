package org.basicjava.olymp;

/**
 * User: mchernov
 * Date: 26.09.13
 * Time: 11:48
 */

/*
Дан массив размера n. Нужно произведя не более 3n/2-1 сравнения
найти максимальный и минимальный элемент в данном массиве
 */

public class MaxAndMin {
    int[] mas = {1,2,10,20,-1,10,13};
    int counter = 0;

    public static void main(String[] args){
        MaxAndMin ex = new MaxAndMin();
        ex.run();

    }

    public void run(){
        MyContainer result = check(0,6);
        System.out.println("Max = " + result.getMaxNum() + " Min = " + result.getMinNum());
        System.out.println("Число сравнений = " + counter);
    }

    private MyContainer check(int startElem, int endElem){
        if (startElem == endElem) return new MyContainer(mas[startElem],mas[startElem]);
        else if (endElem - startElem > 1){
            int newEndElem;
            newEndElem = startElem + (endElem - startElem)/2;
            MyContainer f1 = check(startElem, newEndElem);
            MyContainer f2 = check(newEndElem + 1,endElem);
            counter = counter + 2;
            return new MyContainer(Math.min(f1.getMinNum(),f2.getMinNum()),Math.max(f1.getMaxNum(),f2.getMaxNum()));
        }
        else if ((endElem - startElem) == 1){
            int minElem,maxElem;
            if (mas[startElem] > mas[endElem]) {
                minElem = mas[endElem];
                maxElem = mas[startElem];
            } else {
                minElem =  mas[startElem];
                maxElem =  mas[endElem];
            }
            counter++;
            return new MyContainer(minElem,maxElem);
        }
        else return null;
    }

    public class MyContainer{
        int minNum;
        int maxNum;

        public MyContainer(Integer minNum, Integer maxNum){
            this.minNum = minNum;
            this.maxNum = maxNum;
        }

        public int getMinNum() {
            return minNum;
        }

        public void setMinNum(int minNum) {
            this.minNum = minNum;
        }

        public int getMaxNum() {
            return maxNum;
        }

        public void setMaxNum(int maxNum) {
            this.maxNum = maxNum;
        }
    }
}
