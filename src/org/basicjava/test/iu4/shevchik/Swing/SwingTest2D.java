package org.basicjava.test.iu4.shevchik.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created with IntelliJ IDEA.
 * User: Shevchik
 * Date: 25.10.13
 * Time: 12:43
 * To change this template use File | Settings | File Templates.
 */

public class SwingTest2D {
    public static void main(String[] args){
        PaintFrame frame = new PaintFrame();
        frame.setDefaultCloseOperation(PaintFrame.EXIT_ON_CLOSE);
        //frame.setBackground(SystemColor.GRAY);
        frame.setVisible(true);
        //frame.setResizable(true);
    }

    public static class PaintFrame extends JFrame{
        private int leftX = 800;
        private int topY = 400;
        private int width = 300;
        private int height = 300;

        public PaintFrame() {
            setBounds(getLeftX(), getTopY(), getWidth(), getHeight());
            setTitle("2D draw frame");
            //setBackground(SystemColor.GRAY);

            PaintPanel panel = new PaintPanel();
            add(panel);
        }

        public int getLeftX() {
            return leftX;
        }

        public int getTopY() {
            return topY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    public static class PaintPanel extends JPanel{
        private int panelLeftX = 100;
        private int panelTopY = 100;
        private int panelWidth = 100;
        private int panelHeight = 100;

        public PaintPanel(){
            /*
            JButton yellowButton = new JButton("Yellow!");
            JButton blueButton = new JButton("Blue!");
            JButton redButton = new JButton("Red!");
            //JButton clearButton = new JButton("Clear!");

            add(yellowButton);
            add(blueButton);
            add(redButton);
            //add(clearButton);

            DrawAction yellowAction = new DrawAction(Color.YELLOW);
            DrawAction blueActiob = new DrawAction(Color.BLUE);
            DrawAction redAction = new DrawAction(Color.RED);
            //DrawAction clearAction = new DrawAction(Color.BLACK);

            yellowButton.addActionListener(yellowAction);
            blueButton.addActionListener(blueActiob);
            redButton.addActionListener(redAction);
            //clearButton.addActionListener(clearAction);
            */
            makeButton("yellow", Color.YELLOW);
            makeButton("blue", Color.BLUE);
            makeButton("red", Color.RED);
        }

        void makeButton(String name, final Color backgroundColor){
            JButton button = new JButton(name);
            add(button);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setBackground(backgroundColor);


                }
            });
        }

        /*
        public class DrawAction implements ActionListener{
            private Color backgroundColor;

            public DrawAction(Color c){
                backgroundColor = c;
            }

            public void actionPerformed(ActionEvent e) {
                /*
                if (backgroundColor == Color.BLACK){
                    removeAll();
                } else
                */
//                setBackground(backgroundColor);
//            }
//        }


        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;

            //rectangle draw
            Rectangle2D rect = new Rectangle2D.Double(getPanelLeftX(), getPanelTopY(), getPanelWidth(), getPanelHeight());
            g2D.setPaint(Color.BLACK);
            g2D.draw(rect);

            //Rectangle2D r = new Rectangle2D.Double(100,100,100,100);
            //g2D.draw(r);
            //ellipse draw
            Ellipse2D ellipse = new Ellipse2D.Double();
            ellipse.setFrame(rect);
            g2D.setPaint(Color.BLUE);
            g2D.draw(ellipse);

            //line draw
            g2D.setPaint(Color.GREEN);
            g2D.draw(new Line2D.Double(getPanelLeftX() + getPanelHeight() / 2, getPanelTopY(), getPanelLeftX(), getPanelTopY() - getPanelHeight() / 4));
            g2D.draw(new Line2D.Double(getPanelLeftX() + getPanelHeight() / 2, getPanelTopY(), getPanelLeftX() + getPanelWidth(), getPanelTopY() - getPanelHeight() / 4));
        }

        public int getPanelLeftX() {
            return panelLeftX;
        }

        public int getPanelTopY() {
            return panelTopY;
        }

        public int getPanelWidth() {
            return panelWidth;
        }

        public int getPanelHeight() {
            return panelHeight;
        }
    }

}
