package org.basicjava.test.iu4.shevchik.Swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Shevchik
 * Date: 08.11.13
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 */
public class ForceDirectedGraph {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBounds(30, 40, 300,200);
        frame.setTitle("ForceDirectedGraphFrame");

        Field field = new Field();
        frame.add(field, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
