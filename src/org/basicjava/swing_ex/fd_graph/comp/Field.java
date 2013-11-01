package org.basicjava.swing_ex.fd_graph.comp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * User: Maxim
 * Date: 15.02.13
 * Time: 20:15
 */
public class Field extends JComponent {
    ArrayList<Node> nodes = new ArrayList<Node>();
    ArrayList<Edge> edges = new ArrayList<Edge>();
    double cM = 150;
    double optL = 50;
    double m = 100;
    double k = 1;
    Node translateNode;
    private double translateX = 0;
    private double translateY = 0;
    Timer timer;

    private int nodeCount = 0;


    public Field(){
        FieldMouseListener l = new FieldMouseListener();
        this.addMouseListener(l);
        this.addMouseMotionListener(l);

        timer = new Timer(5,new ActionListener() {
            int i = 0;
            public void actionPerformed(ActionEvent e) {
                if (i==1) {estimateForce(); i = 0;}
                moveNode();
                repaint();
                i++;
            }
        });
        timer.start();
    }

    public void increaseOptLen(){
        optL= optL*1.5;
        m = cM;
        for (Node node: nodes){
            node.setOptL(optL);
        }
    }

    public void decreaseOptLen(){
        if (optL > 5){
            optL= optL*0.8;
            m = cM;
            for (Node node: nodes){
                node.setOptL(optL);
            }
        }
    }

    public double getTranslateX() {
        return translateX;
    }

    public void setTranslateX(double translateX) {
        this.translateX = translateX;
        for (Node n: nodes){
            n.setTranslateX(translateX);
        }
    }

    public double getTranslateY() {
        return translateY;
    }

    public void setTranslateY(double translateY) {
        this.translateY = translateY;
        for (Node n: nodes){
            n.setTranslateY(translateY);
        }
    }

    public void estimateForce(){
        for (Node n1: nodes){
            n1.setFx(0);
            n1.setFy(0);
            for(Node n2: nodes) if (!n1.equals(n2)){
                double r = n1.getDistance(n2);
                double f = Math.abs(Math.pow(optL,2)/r);
                double angle = n1.getAngle(n2);
                double fx = f*Math.cos(angle);
                double fy = f*Math.sin(angle);
                n1.setFx(fx+n1.getFx());
                n1.setFy(fy+n1.getFy());

                //if (r < optL/2) m = cM;
            }
        }
        for (Edge edge: edges){
            Node subj = edge.getSubj();
            Node obj = edge.getObj();
            if (obj != null && subj != null){
                double r = subj.getDistance(obj);
                double f = k*Math.pow(r,2)/ optL;
                double angle = subj.getAngle(obj);
                double fx = f*Math.cos(angle);
                double fy = f*Math.sin(angle);
                subj.setFx(subj.getFx()-fx);
                subj.setFy(subj.getFy()-fy);
                obj.setFx(obj.getFx()+fx);
                obj.setFy(obj.getFy()+fy);

                if (r > 3* optL || r < optL /3) m = cM;

            }
        }
    }

    public void moveNode(){
        double lM = m;
        for (Node n: nodes) if (n != translateNode){
            //if (Math.pow(n.getFx(),2)+Math.pow(n.getFy(),2) > 10000) m = cM;
            n.setX(n.getX()-n.getFx()/lM);
            n.setY(n.getY()+n.getFy()/lM);
            m++;
        }
    }

    public void paint(Graphics g){
        for (Edge edge: edges){
            edge.paint(g);
        }
        for (Node node: nodes){
            node.paint(g);
        }
    }

    public Node getNode(Point p){
        for (Node node: nodes){
            if (node.hasPoint(p)) return node;
        }
        return null;
    }

    public Dimension getPreferredSize(){
        return new Dimension(1400,700);
    }

    public void startMove(){
        m = cM;
        timer.start();
    };

    public void stopMove(){
        timer.stop();
    }

    public class FieldMouseListener extends MouseAdapter{
        Node node;
        Edge edge;
        Point startPoint;
        public void mousePressed(MouseEvent e) {
            node = getNode(e.getPoint());
            startPoint = e.getPoint();
            if (e.getModifiers() == InputEvent.BUTTON1_MASK){
                translateNode = node;
            } else if (node != null){
                edge = new Edge(node,null);
                edge.setX(e.getX());
                edge.setY(e.getY());
                edges.add(edge);
            }
        }
        public void mouseReleased(MouseEvent e) {
            if (edge != null){
                Node node = getNode(e.getPoint());
                if (node == null || node.equals(edge.getSubj())) {
                    edges.remove(edge);
                    edge = null;
                } else {
                    edge.setObj(node);
                    edge = null;
                    m = cM;
                }
            }
            node = null;
            startPoint = null;
            translateNode = null;
            repaint();
        }
        public void mouseDragged(MouseEvent e){
            if (translateNode != null && startPoint != null){
                node.setX((int)(node.getX()+e.getX()-startPoint.getX()));
                node.setY((int) (node.getY() + e.getY() - startPoint.getY()));
                startPoint = e.getPoint();
                m = cM;
            } else if (edge != null) {
                edge.setX(e.getX());
                edge.setY(e.getY());
            } else {
                if (node == null && startPoint != null){
                    setTranslateX(getTranslateX()+ e.getX() - startPoint.getX());
                    setTranslateY(getTranslateY()+ e.getY() - startPoint.getY());
                    startPoint = e.getPoint();
                }
            }
            repaint();
        }

        public void mouseClicked(MouseEvent e) {
            Node clickNode = getNode(e.getPoint());
            if (clickNode == null) addNode(e.getPoint());
        }

        private void addNode(Point p){
            Node n = new Node("Node " + ++nodeCount);
            n.setX(p.getX());
            n.setY(p.getY());
            nodes.add(n);
        }

    }
}