package Seminar_2;

import java.util.Scanner;

public class inputIntNumber {
    static int inputNumber() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        boolean flag = iScanner.hasNextInt();
        if (flag == true) {
            int x = iScanner.nextInt();
            iScanner.close();
            if (x < 0){
                System.out.println("Вы ввели отрицательное число. Я перевёл его в положительное :)");
                iScanner.close();
                return -x;
            }
            return x;
        } else {
            System.out.println("Некорректный ввод числа");
            iScanner.close();
            return inputNumber();
        }
    }
}