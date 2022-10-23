package Seminar_2;

import java.util.Scanner;

public class inputIntNumber {
    static int inputNumber() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        boolean flag = iScanner.hasNextInt();
        if (flag == true) {
            int x = iScanner.nextInt();
            if (x <= 0){
                return 0;
            }
            return x;
        } else {
            return 0;
        }
    }
}