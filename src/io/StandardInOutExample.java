package io;

/**
 * User: Maxim
 * Date: 06.10.13
 * Time: 11:49
 */
/* Пример использования стандартного ввода-вывода*/
/*
  Считывает со стандартного ввода данные порциями по 4 байта и
  выводит их на Стандартный вывод. При считывании набора байт
  stop - прекращает обработку
*/
  public class StandardInOutExample {
    public static void main(String[] args) throws Exception{
        boolean flag = true;
        while (flag){
            byte[] b = new byte[4];
            System.in.read(b);
            String str = new String(b);
            if (str.equals("stop")) {
                flag = false;
                System.out.println("Обработка завершена!");
            }
            System.out.println(str);
        }
    }
}
