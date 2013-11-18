package org.basicjava.virtual_filesystem.listeners;

import org.basicjava.virtual_filesystem.controller.VirtualFilesystemController;
import org.basicjava.virtual_filesystem.file_catalogs_comp.FileCatalog;
import org.basicjava.virtual_filesystem.prop.TL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 26.12.12
 * Time: 13:36
 * To change this template use File | Settings | File Templates.
 */
public class FileCatalogTableListener implements MouseListener{
    private VirtualFilesystemController controller;

    public FileCatalogTableListener(VirtualFilesystemController controller){
        this.controller = controller;
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        checkPopup(e);
    }

    public void mouseReleased(MouseEvent e) {
        checkPopup(e);
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    private void checkPopup(MouseEvent e){
        if (e.isPopupTrigger()){
            JTable table = controller.getFileCatalogsTable();
            int row = table.rowAtPoint(e.getPoint());
            final FileCatalog cat = (FileCatalog)table.getValueAt(row,0);
            table.setRowSelectionInterval(row,row);
            JPopupMenu popup = new JPopupMenu();
            if (cat.getStatus().equals(FileCatalog.FILE_CATALOG_STATUS_OPEN)){
                JMenuItem open = new JMenuItem(TL.getTW(TL.OPEN));
                open.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.startFileManager(cat);
                    }
                });
                popup.add(open);
            }
            popup.show(table,e.getX(),e.getY());

            System.out.println("Show popup");
        }
    }
}
