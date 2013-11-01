package org.basicjava.swing_ex.fd_graph.comp;

import java.awt.*;

/**
 * User: Maxim
 * Date: 15.02.13
 * Time: 20:15
 */
public class Edge {
    public static final int TYPE_SUBCLASS = 0;
    public static final int TYPE_ASSOCIATE = 1;

    int x,y;
    Node subj;
    Node obj;
    int type = TYPE_SUBCLASS;

    public Edge(Node subj,Node obj){
        this.subj = subj;
        this.obj = obj;
    };

    public void paint(Graphics g){
        if (type == TYPE_SUBCLASS) g.setColor(Color.BLACK);
        else g.setColor(Color.RED);
        //System.out.println("Object = " + subj);
        double x1 = subj.getX()+subj.getTranslateX();
        double y1 = subj.getY()+subj.getTranslateY();
        double x2 = obj.getX()+obj.getTranslateX();
        double y2 = obj.getY()+obj.getTranslateY();

        if (obj == null) g.drawLine((int)x1,(int)y1,x,y);
        else {
            if (type == TYPE_SUBCLASS) g.setColor(Color.BLACK);
            else g.setColor(Color.MAGENTA);
            g.drawLine((int)x1,(int)y1,(int)(x1+(x2-x1)/2),(int)(y1+(y2-y1)/2));

            if (type == TYPE_SUBCLASS) g.setColor(Color.RED);
            else g.setColor(Color.MAGENTA);
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

    public void setType(int type) {
        this.type = type;
    }

    public int hashCode(){
        return this.subj.getResource().getId().hashCode() + this.obj.getResource().getId().hashCode();
    }

    public boolean equals(Object edge){
        if (this.subj.getResource().getId().equals(((Edge)edge).getSubj().getResource().getId())
                && this.obj.getResource().getId().equals(((Edge)edge).getObj().getResource().getId())) return true;
        else return false;
    }
}
