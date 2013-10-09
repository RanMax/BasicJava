package org.basicjava.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * User: Maxim
 * Date: 19.12.12
 * Time: 11:16
 */
/* Копирование файла с использованием FileInput/OutputStream, FileChannel*/
public class CopyFileExample {
    public static void main(String[] args) throws Exception{
        FileChannel source = null;
        FileChannel target = null;
        try{
            File sourceFile = new File("D:/test1.jpg");

            FileInputStream i1 = new FileInputStream(sourceFile);
            FileOutputStream o1 = new FileOutputStream("D:/test2.jpg");

            source = i1.getChannel();
            target = o1.getChannel();

            target.transferFrom(source,0,source.size());
        } finally {
            if (source != null) source.close();
            if (target != null) target.close();
        }
    }
}
