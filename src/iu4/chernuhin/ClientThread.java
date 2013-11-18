package iu4.chernuhin;

import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: Макс
 * Date: 06.10.13
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
public class ClientThread extends Thread {
    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
        this.start();
    }

    public void run() {

    }
}