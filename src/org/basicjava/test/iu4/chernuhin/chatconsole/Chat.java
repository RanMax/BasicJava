package org.basicjava.test.iu4.chernuhin.chatconsole;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Макс
 * Date: 26.10.13
 * Time: 1:34
 * To change this template use File | Settings | File Templates.
 */
public class Chat{
    public static void main(String[] args) {
        System.out.println("Program starting...");
        try {
            ServerSocket ss = new ServerSocket(9222);
            System.out.println("Server starting...");
            while(true){
                Socket s = ss.accept(); // ожидание новых клиентов
                SocketThread socketThread = new SocketThread(s);
                Thread t = new Thread(socketThread);
                t.start(); // запуск нового потока для каждого нового клиента
            }
        } catch (IOException ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
