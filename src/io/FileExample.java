package io;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 19.12.12
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */
/* Пример использования класса File*/
public class FileExample {
    public static void main(String[] args){
        File file = new File(".");

        String[] list = file.list();
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i] + " " + new File(list[i]).isDirectory());
            System.out.println(new File(list[i]).getAbsolutePath());
        }
    }
}
