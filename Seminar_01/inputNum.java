package Seminar_01;

import java.util.Scanner;

public class inputNum {
    static double inputNumber() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        boolean flag = iScanner.hasNextDouble();
        if (flag == true) {
            double x = iScanner.nextDouble();
            iScanner.close();
            return x;
        } else {
            System.out.println("Некорректный ввод числа");
            return inputNumber();
        }
    }
}
