package org.basicjava.net.chat;

import java.io.*;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * User: Maxim
 * Date: 06.10.13
 * Time: 11:36
 */

/*
После запуска устанавливает соединение с сервером и отправляет на сервер сообщения,
вводимые пользователем в стандартный ввод
После получения от сервера сообщения "Соединение разорвано" - прекращает свою работу
*/
public class Client {
    public static void main(String[] args) throws Exception{
        Socket kkSocket = new Socket("localhost", 1300);
        PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        String fromServer;
        String fromUser;

        while ((fromServer = in.readLine()) != null) {
            System.out.println("Server: " + fromServer);
            if (fromServer.equals("Соединение разорвано"))
                break;

            fromUser = stdIn.readLine();
            if (fromUser != null) {
                System.out.println("Client: " + fromUser);
                out.println(fromUser);
            }
        }
    }
}
