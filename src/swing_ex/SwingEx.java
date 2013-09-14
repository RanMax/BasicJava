package swing_ex;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim
 * Date: 20.12.12
 * Time: 12:33
 * To change this template use File | Settings | File Templates.
 */
public class SwingEx {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,300,100);
        MyButton b1 = new MyButton("fdgfdg");
        frame.add(b1,BorderLayout.CENTER);

        frame.setVisible(true);
    }

    static class MyButton extends JButton{
        public MyButton(String name){
            super(name);
        }

        public String getText(){
            //Object obj;
            return "Eres'";
        }
    }
}
