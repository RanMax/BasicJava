package org.basicjava.test.iu4.shevchik.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Shevchik
 * Date: 25.10.13
 * Time: 21:29
 * To change this template use File | Settings | File Templates.
 */
public class SwingTestMouse {
    private final static int SIZE = 13;

    public static void main(String[] args){
        MouseFrame frame = new MouseFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static class MouseFrame extends JFrame{
        private int leftX = 800;
        private int topY = 400;
        private int width = 500;
        private int height = 500;

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

        public MouseFrame(){
            setBounds(getLeftX(), getTopY(), getWidth(),getHeight());
            MousePanel panel = new MousePanel();
            panel.setBackground(Color.GRAY);
            add(panel);
        }
    }

    public static class MousePanel extends JPanel{
        private ArrayList<Rectangle2D> list;
        private Rectangle2D current;

        public MousePanel(){
            list = new ArrayList<Rectangle2D>();
            current = null;

            addMouseListener(new MouseHandler());
            addMouseMotionListener(new MouseMotionHandler());
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            for (Rectangle2D rectangle : list){
                g2D.draw(rectangle);
            }
        }

        public void addRectangle(Point2D p){
            double x = p.getX();
            double y = p.getY();
            current = new Rectangle2D.Double(x-SIZE/2, y-SIZE/2,SIZE,SIZE);
            list.add(current);
            repaint();
        }

        public void remove(Rectangle2D rect){
            if (rect == null) return;
            if (rect == current) list.remove(rect);
            repaint();
        }

        public Rectangle2D find(Point2D p){
            for (Rectangle2D rect : list){
                if (rect.contains(p)) return rect;
            }
            return null;
        }

        public class MouseHandler extends MouseAdapter{
            public void mousePressed(MouseEvent event){
                current = find(event.getPoint());
                if (current == null){
                    addRectangle(event.getPoint());
                }
            }

            public void mouseClicked(MouseEvent event){
                current = find(event.getPoint());
                if (current != null && event.getClickCount() >= 2){
                    remove(current);
                }
            }
        }


        public class MouseMotionHandler implements MouseMotionListener {
            public void mouseDragged(MouseEvent event) {
                if (current != null){
                    int x = event.getX();
                    int y = event.getY();

                    current.setFrame(x-SIZE/2, y-SIZE/2,SIZE,SIZE);
                    repaint();
                }
            }

            public void mouseMoved(MouseEvent event) {

                if (find(event.getPoint()) == null){
                    setCursor(Cursor.getDefaultCursor());
                } else {
                    setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                }
            }
        }
    }
}
