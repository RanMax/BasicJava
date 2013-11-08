package org.basicjava.test.iu4.shevchik.Swing;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Shevchik
 * Date: 09.11.13
 * Time: 0:39
 * To change this template use File | Settings | File Templates.
 */
public class Edge {
    Node subj;
    Node obj;

    public Edge(Node subj,Node obj){
        this.subj = subj;
        this.obj = obj;
    }

    public void paint(Graphics g){
        int xSubj = (int)subj.getX();
        int ySubj = (int)subj.getY();
        int xObj = (int)obj.getX();
        int yObj = (int)obj.getY();

        g.setColor(Color.BLACK);
        g.drawLine(xSubj,ySubj,xObj,yObj);
    }
}
