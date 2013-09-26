package io;

import java.io.File;

/**
 * User: Maxim
 * Date: 19.12.12
 * Time: 15:28
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
