package org.basicjava.swing_ex.fd_graph.comp;

import java.awt.*;

/**
 * User: Maxim
 * Date: 15.02.13
 * Time: 20:15
 */
public class Edge {
    int x,y;
    Node subj;
    Node obj;

    public Edge(Node subj,Node obj){
        this.subj = subj;
        this.obj = obj;
    };

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        //System.out.println("Object = " + subj);
        double x1 = subj.getX()+subj.getTranslateX();
        double y1 = subj.getY()+subj.getTranslateY();

        if (obj == null) g.drawLine((int)x1,(int)y1,x,y);
        else {
            double x2 = obj.getX()+obj.getTranslateX();
            double y2 = obj.getY()+obj.getTranslateY();

            g.setColor(Color.BLACK);
            g.drawLine((int)x1,(int)y1,(int)(x1+(x2-x1)/2),(int)(y1+(y2-y1)/2));

            g.setColor(Color.RED);
            g.drawLine((int)(x1+(x2-x1)/2),(int)(y1+(y2-y1)/2),(int)x2,(int)y2);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setObj(Node obj) {
        this.obj = obj;
    }

    public void setSubj(Node subj) {
        this.subj = subj;
    }

    public Node getObj() {
        return obj;
    }

    public Node getSubj() {
        return subj;
    }

    public int hashCode(){
        return this.subj.getName().hashCode() + this.obj.getName().hashCode();
    }

    public boolean equals(Object edge){
        if (this.subj.getName().equals(((Edge)edge).getSubj().getName())
                && this.obj.getName().equals(((Edge)edge).getObj().getName())) return true;
        else return false;
    }
}
