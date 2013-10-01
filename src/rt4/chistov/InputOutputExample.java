package rt4.chistov;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: Din
 * Date: 01.10.13
 * Time: 10:28
 * To change this template use File | Settings | File Templates.
 */
public class InputOutputExample {
    public static void main(String[] args){
        int[] mas = {1,2,3,100,2000};
        for (int i = 0; i < mas.length; i++){
            System.out.println(mas[i]);
        }
        //for (int )

       File file=new File("E://Photo_Video") ;
        String[] str = file.list();
        for (int i = 0; i < str.length; i++){
            System.out.println(str[i]);
        }
        System.out.print("Hello world!");
    }
}
