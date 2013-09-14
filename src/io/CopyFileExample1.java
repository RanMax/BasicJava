package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 19.12.12
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
/* Копирование файла с использованием FileInput/OutputStream, FileChannel*/
public class CopyFileExample1 {
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
