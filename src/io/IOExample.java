package io;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 19.12.12
 * Time: 8:16
 * To change this template use File | Settings | File Templates.
 */
public class IOExample {
    public static void main(String[] args) throws Exception{
        File file = new File("meta/catalogs");
        FileInputStream fileInputStream = new FileInputStream("meta/catalogs");
        FileReader r = new FileReader(file);
        FileWriter w = new FileWriter(file);
        w.write("1235\r\n12345");
        w.close();
        //ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
        File file2 = new File("D:/test1.jpg");

        FileInputStream i1 = new FileInputStream(file2);
        FileOutputStream o1 = new FileOutputStream("C:/test2");

        FileChannel source = i1.getChannel();
        FileChannel target = o1.getChannel();
        target.transferFrom(source,0,source.size());

        //FileReader reader = new FileReader(file2);
        //FileWriter writer = new FileWriter("C:/test2");
        //writer.write(reader.);
    }
}
