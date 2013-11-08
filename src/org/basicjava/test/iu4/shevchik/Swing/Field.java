package org.basicjava.test.iu4.shevchik.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Shevchik
 * Date: 09.11.13
 * Time: 0:38
 * To change this template use File | Settings | File Templates.
 */
public class Field extends JComponent {
    private final Timer timer;
    ArrayList<Node> nodes = new ArrayList<Node>();
    ArrayList<Edge> edges = new ArrayList<Edge>();

    public Field(){
        super();
        FieldMouseListener listener = new FieldMouseListener();
        this.addMouseListener(listener);
        this.addMouseMotionListener(listener);

        timer = new Timer(10,new ActionListener() {
            boolean flag = true;
            public void actionPerformed(ActionEvent e) {
                if (flag){
                    forceCoulomb();
                    forceHooke();
                    flag = false;
                }
                repaint();
                flag = true;
            }
        });
        timer.start();
    }


    public void addNode(Point p){
        Node node = new Node(nodes.size());
        node.setX(p.getX());
        node.setY(p.getY());
        nodes.add(node);
    }

    public Node getNode(Point p){
        for (Node n : nodes){
            if (n.containsPoint(p)){
                return n;
            }
        }
        return null;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Node n : nodes){
            n.paint(g);
        }
        for (Edge e : edges){
            e.paint(g);
        }
    }

    private void forceCoulomb() {

    }

    private void forceHooke() {

    }

    private class FieldMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            super.mouseWheelMoved(e);    //To change body of overridden methods use File | Settings | File Templates.
        }
    }
}
