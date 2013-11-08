package org.basicjava.test.iu4.shevchik.Swing;

import java.awt.*;
import java.awt.geom.Ellipse2D;
//import java.awt.geom.Point2D;

/**
 * Created with IntelliJ IDEA.
 * User: Shevchik
 * Date: 09.11.13
 * Time: 0:39
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    private int number;
    private double x = 10.0;
    private double y = 10.0;
    private double radius = 10.0;
    private static Ellipse2D circle;

    public Node(int i){
        this.setNumber(i);
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        circle = new Ellipse2D.Double((int)getX(), (int)getY(), (int)getRadius()*2, (int)getRadius()*2);
        g2D.drawString(String.valueOf(number), (int) getX(), (int) getY());
        g2D.setColor(Color.PINK);
        g2D.fill(circle);
    }


    public boolean containsPoint(Point p){
        if (circle.contains(p)){
            return true;
        } else return false;
    }

    public double getDistance(Node node){
        double dist = Math.pow(Math.pow(node.getX()-this.getX(),2)+Math.pow(node.getY()-this.getY(),2),0.5);
        return dist;
    }

    public double getAngle(Node node){
        double dist = Math.pow(Math.pow(node.getX()-this.getX(),2)+Math.pow(node.getY()-this.getY(),2),0.5);
        double angle;
        if (dist < 0.0001){
            angle = 0;
        } else angle = Math.acos((node.getX()-this.getX())/dist);
        if (node.getY()-this.getY() > 0){
            angle = -angle;
        }
        return angle;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
