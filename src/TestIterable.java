import java.util.HashSet;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Maxim
 * Date: 11.07.13
 * Time: 15:56
 * To change this template use File | Settings | File Templates.
 */
public class TestIterable<T> implements Iterable<T> {
    private HashSet<T> innerSet;

    public TestIterable(HashSet<T> set) {
        innerSet = set;
    }

    public static void main(String[] args){
        HashSet<String> set = new HashSet<String>();
        String s1 = "Maxim";
        set.add(s1);
        set.add("Misha");
        /*for (String str : set){
            System.out.println(str);
        }*/

        TestIterable<String> i = new TestIterable<String>(set);
        boolean flag = true;
        for (String str: i){
            if (flag) set.remove(s1);
            flag = false;
            System.out.println(str);

        }

    }

    public Iterator<T> iterator() {
        final Iterator<T> it = innerSet.iterator();

        return new Iterator<T>() {
            public boolean hasNext() {
                return it.hasNext();  //To change body of implemented methods use File | Settings | File Templates.
            }

            public T next() {
                return it.next();  //To change body of implemented methods use File | Settings | File Templates.
            }

            public void remove() {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

    }
}
