package net.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 * User: Maxim
 * Date: 06.10.13
 * Time: 11:36
 */

/*
После запуска - начинает прослушивать порт 1300 локальной машины
и при попытках подключения вещает на каждое подключение экземпляр
обработчика Dialog
*/
public class Server {
    private ServerSocket server;
    private Socket client;
    private ArrayList<Dialog> dialogs = new ArrayList<Dialog>();
    private boolean flag = true;

    public static void main(String[] args) throws Exception{
        Server ser = new Server();
        ser.start();
    }

    public void start() throws Exception{
        server = new ServerSocket(1300);
        while (flag){
            try{
                client = server.accept();
                System.out.println("Новое подключение!");
                Dialog dialog = new Dialog(this);
                dialogs.add(dialog);
                new Thread(dialog).start();
            } catch (SocketException ex){
                flag = false;
                System.out.println("Сокет закрыт!");
            }
        }
    }

    public Socket getClient(){
        return this.client;
    }

    public void shutdown(){
        for (Dialog dialog: dialogs){
            dialog.close();
        }
        try {
            client.close();
            server.close();
        } catch (Exception ex){
            System.out.println("Не получилось закрыть сокет!");
        }

    }

    public void closeDialog(Dialog dialog){
        dialogs.remove(dialog);
    }
}
