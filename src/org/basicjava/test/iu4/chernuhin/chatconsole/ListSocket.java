package org.basicjava.test.iu4.chernuhin.chatconsole;

import java.net.Socket;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Макс
 * Date: 26.10.13
 * Time: 1:36
 * To change this template use File | Settings | File Templates.
 */
public class ListSocket {

    private static ArrayList<Socket> listSocket = new ArrayList<Socket>();

    public synchronized static ArrayList<Socket> getListSocket() {
        return ListSocket.listSocket;
    }

    public synchronized static void addSocketToList(Socket s) {
        ListSocket.listSocket.add(s);
    }

    public synchronized static void removeSocketWithList(Socket s) {
        ListSocket.listSocket.remove(s);
    }
}