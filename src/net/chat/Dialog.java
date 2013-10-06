package net.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * User: Maxim
 * Date: 06.10.13
 * Time: 14:47
 */

/*
Обработчик соединения
Принимает сообщения от клиента и отправляет в ответ на
них строки из массива mas
При получении сообщения stop - закрывает соединение
При получении команды shutdown - закрывает сокет
*/
public class Dialog implements Runnable {
    private Server server;
    private Socket client;
    private PrintWriter out;
    private BufferedReader in;
    private String[] mas = {"Hello!","How are you?","I'm nice. Thank you", "Good bay!", "See you tomorrow"};
    private boolean flag = true;

    public Dialog(Server server){
        this.server = server;
        this.client = server.getClient();
    }

    public void close(){
        out.println("Соединение разорвано");
        flag = false;
        server.closeDialog(this);

        try{
            out.close();
            in.close();
        } catch (Exception ex){
            System.out.println("Не удалось закрыть потоки ввода-вывода");
        }
    }

    public void run(){
        try{
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            out.println("Соединение установлено");

            int i = 0;
            while (flag) {
                String str = in.readLine();
                //out.println(str);
                if (str.equals("shutdown")) server.shutdown();
                else if (str.equals("stop")) {
                    close();
                    break;
                } else {
                    out.println(mas[i]);
                    if (++i >= mas.length) i = 0;
                }
            }
            close();
        }
        catch (Exception ex){
            System.out.println("Ошибка открытия соединения!");
        }
    }
}
