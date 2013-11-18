package org.basicjava.virtual_filesystem.controller;

import org.basicjava.virtual_filesystem.file_catalogs_comp.FileCatalog;
import org.basicjava.virtual_filesystem.prop.TL;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 26.12.12
 * Time: 13:53
 * To change this template use File | Settings | File Templates.
 */
public class FileManagerController {
    ArrayList<FileCatalog> catalogs;
    FileCatalog currCat;

    public FileManagerController(ArrayList<FileCatalog> catalogs, FileCatalog currCat){
        this.catalogs = catalogs;
        this.currCat = currCat;
    }

    public void runController(){
        JFrame frame = new JFrame(TL.getTW(TL.FILE_MANAGER));
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        frame.setBounds(200,100,800,400);

        JTree tree = new JTree();
        frame.add(new JScrollPane(tree),BorderLayout.WEST);

        frame.setVisible(true);
    }
}
