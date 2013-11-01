package org.basicjava.swing_ex.fd_graph;

import org.basicjava.swing_ex.fd_graph.comp.Field;

import javax.swing.*;
import java.awt.*;

/**
 * User: Maxim
 * Date: 02.11.13
 * Time: 1:37
 */
public class FDGraph {

    public static void main(String[] args){
        JFrame frame = new JFrame("Force-directed Graph Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        Field field = new Field();
        frame.add(field, BorderLayout.CENTER);

        frame.setVisible(true);
    }

}
