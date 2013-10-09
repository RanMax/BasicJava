package org.basicjava.test.iu4.chernov.tel_dic.view;

import javax.swing.*;
import javax.swing.tree.TreeModel;
import java.awt.*;

/**
 * User: Maxim
 * Date: 07.10.13
 * Time: 17:41
 */
public class TelDicView {
    public void show(TreeModel model){
        JFrame frame = new JFrame("Представление сущностей");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTree tree = new JTree(model);
        JScrollPane treeScrollPane = new JScrollPane(tree);


        JTable table = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(table);

        JSplitPane splitPane = new JSplitPane();
        splitPane.setLeftComponent(treeScrollPane);
        splitPane.setRightComponent(tableScrollPane);

        frame.add(splitPane, BorderLayout.CENTER);

        frame.setBounds(100,50,700,400);

        frame.setVisible(true);
    }
}
