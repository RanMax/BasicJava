package org.basicjava.test.iu4.isaev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created with IntelliJ IDEA.
 * User: Eduard.Isaev
 * Date: 25.10.13
 * Time: 23:51
 * To change this template use File | Settings | File Templates.
 */
public class testing {
    public static void main (String[] args) {
        SimpleFrame frame = new SimpleFrame();
        SimplePanel canvas = new SimplePanel();
        frame.add(canvas);
    }

    private static class SimpleFrame extends JFrame{
        public int width=500;
        public int height=500;
        public int startX=400;
        public int startY=200;

        public SimpleFrame (){
            setSize(width,height);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(false);
            setTitle("Apple tree");
            setLocation(startX,startY);
        }
    }

    private static class SimplePanel extends JPanel{
        double x = 50;
        double y = 50;
        double w = 50;
        double h = 50;
        Rectangle2D curRect;
        Rectangle2D rect = new Rectangle2D.Double(x,y,w,h);

        public SimplePanel (){
            setBackground(Color.LIGHT_GRAY);

          //  addMouseListener(new MouseHandler());
            addMouseMotionListener(new MouseMotionHandler());

            curRect = null;
        }

        public void paintComponent(Graphics c){
            super.paintComponent(c);
            Graphics2D canv = (Graphics2D) c;
            canv.setPaint(Color.CYAN);
            canv.fill(rect);
        }

        public Rectangle2D find(Point2D p, Rectangle2D rect){
            if (rect.contains(p)) return rect;
            return null;
        }
        /*
        private class MouseHandler extends MouseAdapter {
            public void mousePressed (MouseEvent e){
                curRect = findeComponent(e.getPoint(),rect);
                if (curRect != null){

                }
            }
        }
        */
        private class MouseMotionHandler implements MouseMotionListener {
            public void mouseDragged(MouseEvent e) {
                curRect = find(e.getPoint(),rect);
                if (curRect != null){
                    int i = e.getX();
                    int j = e.getY();

                    curRect.setFrame(i,j,w,h);
                    repaint();
                }
            }

            public void mouseMoved(MouseEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        }
    }


}
