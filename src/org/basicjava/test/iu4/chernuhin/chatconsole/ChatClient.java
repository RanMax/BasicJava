package org.basicjava.test.iu4.chernuhin.chatconsole;

import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Макс
 * Date: 26.10.13
 * Time: 1:39
 * To change this template use File | Settings | File Templates.
 */
public class ChatClient {

    public static void main(String[] args) {
        try {
            System.out.println("Client starting...");
            Socket s = new Socket("192.168.0.17",9222);
            System.out.println("Connect to server...");
            Thread threadIn = new Thread(new SocketInputThread(s));// создание отдельного потока на считывание даных от сервера
            Thread threadOut = new Thread(new SocketOutputThread(s));// создание отдельного потока на ввод даных из клавиатуры
            threadIn.start();
            threadOut.start();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
