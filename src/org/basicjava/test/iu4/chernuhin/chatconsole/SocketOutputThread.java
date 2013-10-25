package org.basicjava.test.iu4.chernuhin.chatconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Макс
 * Date: 26.10.13
 * Time: 1:40
 * To change this template use File | Settings | File Templates.
 */
public class SocketOutputThread implements Runnable {

    private Socket s = null;
    private Scanner in = null;
    private PrintWriter out = null;
    private boolean exit = true;
    private String inMessage = null;
    private String outMessage = null;

    public SocketOutputThread(Socket s) {
        this.s = s;
    }


    public void run() {
        try {
            out = new PrintWriter(s.getOutputStream());
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                outMessage = buffer.readLine();
                out.println(outMessage);
                out.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketOutputThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}