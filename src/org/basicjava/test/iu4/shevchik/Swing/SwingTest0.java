package org.basicjava.test.iu4.shevchik.Swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Shevchik
 * Date: 24.10.13
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
public class SwingTest0 {
    private static Toolkit kit = Toolkit.getDefaultToolkit();
    private static Dimension screenSize = kit.getScreenSize();

    public static int getCenterWidth(){
        return (screenSize.width/2)-200;
    }

    public static int getCenterHeight(){
        return (screenSize.height/4)+100;
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(300, 300);
        //frame.setBounds(600,600,300,300);
        frame.setBounds(getCenterWidth(),getCenterHeight(),screenSize.width/8,screenSize.height/4);
        //frame.setExtendedState(frame.MAXIMAZED_BOTH); // don't work, Horstmann lie me :)
        frame.setTitle("Utka is a God!");
        frame.setResizable(true);
        MyPanel panel = new MyPanel();
        frame.add(panel);
        frame.setVisible(true);
    }

    static class MyPanel extends JPanel{

        public void paintComponent (Graphics g){
            super.paintComponent(g);
            g.drawString("Temp",100,100);
        }
    }
}
