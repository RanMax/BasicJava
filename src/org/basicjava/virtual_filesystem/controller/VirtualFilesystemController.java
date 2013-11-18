package org.basicjava.virtual_filesystem.controller;

import org.basicjava.virtual_filesystem.prop.TL;
import org.basicjava.virtual_filesystem.containers.LangTag;
import org.basicjava.virtual_filesystem.file_catalogs_comp.FileCatalog;
import org.basicjava.virtual_filesystem.listeners.FileCatalogTableListener;
import org.basicjava.virtual_filesystem.metadata_model.MetadataModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 17.12.12
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
public class VirtualFilesystemController {
    JFrame frame;
    JTable table;
    JProgressBar progressBar;
    JMenuBar menuBar;
    ConnectLinkTableModel tableModel;


    MetadataModel model;

    public void runController(){
        TL.load("RU");
        createGui();
    }

    private void createCatalogsTable(){
        String[] colNames = {TL.getTW(TL.CATALOG_NAME), TL.getTW(TL.CATALOG_ID), TL.getTW(TL.CATALOG_SEQ), TL.getTW(TL.CATALOG_STATUS)};
        tableModel = new ConnectLinkTableModel(null,colNames);
        this.table = new JTable(tableModel);
        table.addMouseListener(new FileCatalogTableListener(this));

        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setPreferredWidth(30);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JTableHeader h = table.getTableHeader();
        frame.add(h, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane,BorderLayout.CENTER);
    }

    private void createFrame(){
        this.frame = new JFrame(TL.getTW(TL.FILE_INSPECTOR));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBounds(200,200,700,300);

        progressBar = new JProgressBar();

        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu file = new JMenu(TL.getTW(TL.FILE));
        menuBar.add(file);
        JMenu options = new JMenu(TL.getTW(TL.OPTIONS));
        menuBar.add(options);
        JMenu lang = new JMenu(TL.getTW(TL.LANG));
        List<LangTag> langTags = TL.getListLang();
        for (LangTag tag: langTags){
            JMenuItem item = new JMenuItem(tag.toString());
            lang.add(item);
        }
        options.add(lang);
    }

    private void createGui(){
        createFrame(); // Создание формы
        createCatalogsTable(); // Создание таблицы файловых каталогов

        new Thread(new Runnable(){
            public void run() {
                JProgressBar bar = getProgressBar();
                bar.setIndeterminate(true);
                bar.setString(TL.getTW(TL.LOAD_FILE_CATALOGS));
                bar.setStringPainted(true);
                bar.setMinimum(0);
                bar.setMaximum(100);
                frame.add(bar, BorderLayout.SOUTH);

                model = new MetadataModel("jdbc:hsqldb:db/virtual_filesystem/test");

                List<FileCatalog> list = model.getCatalogs();
                for (FileCatalog cat: list){
                    Object[] data = new Object[4];
                    data[0] = cat;
                    data[1] = cat.getCatNatId();
                    data[2] = cat.getCatSeq();
                    data[3] = TL.getTW(cat.getStatus());
                    tableModel.addRow(data);
                }


                bar.setString(TL.getTW(TL.LOAD_FILE_CATALOGS_FIN));
                bar.setIndeterminate(false);
                bar.setValue(0);
                frame.remove(bar);
                frame.setVisible(true);

                loadCatalogs();
                frame.setVisible(true);
            }
        }){}.start();

        frame.setVisible(true);
    }

    public void loadCatalogs(){
        int catCount = this.tableModel.getRowCount();
        progressBar.setMinimum(0);
        progressBar.setMaximum(catCount);
        frame.add(progressBar, BorderLayout.SOUTH);
        frame.setVisible(true);
        for (int i = 0; i < catCount; i++){
            progressBar.setValue(i);
            FileCatalog fileCatalog = (FileCatalog)tableModel.getValueAt(i,0);
            progressBar.setString(TL.getTW(TL.LOAD_FILE_LOCATIONS) + " : " + fileCatalog.getCatName());

            try{Thread.sleep(5000);} catch (Exception ex){ex.printStackTrace();}

            loadCatalog(fileCatalog);
            tableModel.setValueAt(TL.getTW(fileCatalog.getStatus()),i,3);
        }
        frame.remove(progressBar);
        frame.setVisible(true);
    }

    public void loadCatalog(FileCatalog cat){
        this.model.loadFileCatalog(cat);
    }

    public JTable getFileCatalogsTable(){
        return table;
    }

    public JProgressBar getProgressBar(){
        return progressBar;
    }

    public void startFileManager(FileCatalog catalog){
        int rowCount = tableModel.getRowCount();
        ArrayList<FileCatalog> list = new ArrayList<FileCatalog>();
        for (int i = 0; i < rowCount; i++){
            list.add((FileCatalog)tableModel.getValueAt(i,0));
        }
        FileManagerController fileManager = new FileManagerController(list,catalog);
        fileManager.runController();
        System.out.println("startFileManager");
    }

    public class ConnectLinkTableModel extends DefaultTableModel{
        public ConnectLinkTableModel(String[][] data, String[] colNames){super(data,colNames);}

        public boolean isCellEditable(int rowIndex, int columnIndex){return false;}
}

}
