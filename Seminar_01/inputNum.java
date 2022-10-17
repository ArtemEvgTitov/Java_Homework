package Seminar_01;

import java.util.Scanner;

public class inputNum {
    static int inputNumber() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        boolean flag = iScanner.hasNextInt();
        if (flag == true) {
            int x = iScanner.nextInt();
            iScanner.close();
            return x;
        } else {
            System.out.println("Некорректный ввод числа");
            return inputNumber();
        }
    }
}
