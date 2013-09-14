package virtual_filesystem;

import virtual_filesystem.controller.VirtualFilesystemController;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 17.12.12
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
public class VirtualFilesystem  {
    public static void main(String[] args){
        System.out.println("Program start!!!");
        try {
        UIManager.setLookAndFeel(UIManager.
                getSystemLookAndFeelClassName());
        } catch(Exception e) {}
        VirtualFilesystemController controller = new VirtualFilesystemController();
        controller.runController();

        //System.out.println(new File(".").getAbsolutePath());

    }
}
