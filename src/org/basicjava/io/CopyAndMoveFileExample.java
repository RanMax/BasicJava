package org.basicjava.io;

import java.io.File;
import java.nio.file.Files;

/**
 * User: Maxim
 * Date: 19.12.12
 * Time: 11:25
 */
/* Копирование и перемещение файла с использованием класса Files*/
public class CopyAndMoveFileExample {
    public static void main(String[] args) throws Exception{
        File sourceFile = new File("D:/test1.jpg");
        File targetFile = new File("D:/test2.jpg");

        //Files.copy(sourceFile.toPath(), targetFile.toPath());
        Files.move(sourceFile.toPath(), targetFile.toPath());
    }
}
