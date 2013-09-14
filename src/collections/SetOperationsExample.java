package collections;

import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 19.12.12
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
/* Операции над множествами с использованием HashSet*/
public class SetOperationsExample {
    public static void main(String[] args){
        SetOperationsExample ex = new SetOperationsExample();
        ex.run();
    }

    public void run(){
        HashSet<MyObject> set1 = new HashSet<MyObject>();
        set1.add(new MyObject("Кошка"));
        set1.add(new MyObject("Собака"));
        set1.add(new MyObject("Обезбяна"));
        set1.add(new MyObject("Кошка"));

        PrintCollection.print(set1);
    }

    class MyObject{
        private String name;
        public MyObject(String name){
            this.name = name;
        }
        public String toString(){
            return name;
        }
        public int hashCode(){
            return name.hashCode();
        }
        public boolean equals(Object obj){
            return name.equals(((MyObject)obj).name);
        }

    }
}
