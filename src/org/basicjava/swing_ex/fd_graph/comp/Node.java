package org.basicjava.swing_ex.fd_graph.comp;



import java.awt.*;

/**
 * User: Maxim
 * Date: 15.02.13
 * Time: 20:15
 */
public class Node {
    SybaseObject res;
    private double translateX = 0;
    private double translateY = 0;
    double x,y,r = 5.0;
    double fx,fy;
    double optL = 10;

    public Node(int x,int y){
        this.x = x;
        this.y = y;
    }

    public Node(SybaseObject res){
        this.res = res;
    }

    public boolean hasPoint(Point point){
        if (Math.pow(x+translateX-point.getX(),2)+Math.pow(y+translateY-point.getY(),2) < Math.pow(r,2)) return true;
        else return false;
    }
    public void paint(Graphics g){
        g.setColor(Color.MAGENTA);
        if (res != null){
            if (res.getType().equals("V")) g.setColor(Color.GREEN);
            if (res.getType().equals("U")) g.setColor(Color.ORANGE);
            if (res.getType().equals("P")) g.setColor(Color.CYAN);
        }
        g.fillOval((int)(x+translateX-r),(int)(y+translateY-r),(int)(2*r),(int)(2*r));
        g.setColor(Color.BLACK);
        g.drawOval((int)(x+translateX-r),(int)(y+translateY-r),(int)(2*r),(int)(2*r));
        if (res != null) {
            int style = Font.BOLD | Font.ITALIC;
            Font f = new Font("TimesNewRoman",style,16);
            g.setFont(f);
            g.setColor(Color.BLUE);
            g.drawString(res.toString(),(int)(x+translateX + 7),(int)(y+translateY+7));
        }
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

    public double getDistance(Node node){
        double dist = Math.pow(Math.pow(node.getX()-x,2)+Math.pow(node.getY()-y,2),0.5);
        if (dist > (r+node.getR()+optL/10)) return (dist-(r+node.getR()));
        else return optL/10;
    }

    public double getAngle(Node node){
        double dist = Math.pow(Math.pow(node.getX()-x,2)+Math.pow(node.getY()-y,2),0.5);
        //if (Double.isNaN(dist)) System.out.println("Dist is NAN");
        double angle;
        if (dist < 0.0001) angle = 0;
        else angle = Math.acos((node.getX()-x)/dist);
        //if (Double.isNaN(angle)) System.out.println("Angle is NAN");
        if (node.getY()-y >0) angle = -angle;
        return angle;
    }

    public double getFx() {
        return fx;
    }

    public void setFx(double fx) {
        this.fx = fx;
    }

    public double getFy() {
        return fy;
    }

    public void setFy(double fy) {
        this.fy = fy;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getOptL() {
        return optL;
    }

    public void setOptL(double optL) {
        this.optL = optL;
    }

    public double getTranslateX() {
        return translateX;
    }

    public void setTranslateX(double translateX) {
        this.translateX = translateX;
    }

    public double getTranslateY() {
        return translateY;
    }

    public void setTranslateY(double translateY) {
        this.translateY = translateY;
    }

    public SybaseObject getResource() {
        return res;
    }
}