package exeption_ex;

import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 17.12.12
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class JavaExeptionsExample {
    public static void main(String[] args){
        try{
            Integer i = 0;
            //Integer b = 2/i;
            String a = null;
            a.toString();
        } catch (ArithmeticException ex){
            System.out.println("Произошло ArithmeticException");
        } catch (Exception ex){
            System.out.println("Произошло не ArithmeticException");
        } finally {
            System.out.println("Этот блок выполниться всегда");
        }
    }


}
