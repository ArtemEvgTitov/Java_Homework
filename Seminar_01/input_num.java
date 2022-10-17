package Seminar_01;

import java.util.Scanner;

public class input_num {
    static int input_number() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        boolean flag = iScanner.hasNextInt();
        if (flag == true){
            int x = iScanner.nextInt();
            iScanner.close();
            return x; 
        }
        else return input_number();
    }
}
