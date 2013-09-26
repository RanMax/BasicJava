package collections;

import java.util.Iterator;

/**
 * User: Maxim
 * Date: 17.12.12
 * Time: 17:48
 */
public class IterableClassExample implements Iterable<String>{
    public Iterator<String> iterator() {
        String[] mas = {"A","B","C","D"};
        return new StringIterator(mas);
    }

class StringIterator implements Iterator<String>{
    private String[] arr;
    private int currEl = 0;

    StringIterator(String[] arr){
        this.arr = arr;
    }

    public boolean hasNext() {
        if (currEl < arr.length) return true;
        else return false;
    }

    public String next() {
        return arr[currEl++];
    }

    public void remove() {}
}

}
