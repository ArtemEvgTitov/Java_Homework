package Seminar_01;

// Написать программу вычисления n-ого треугольного числа.

public class task_1 {
    public static void main(String[] args) {
        int number = inputNum.inputNumber();
        int total = number / 2 * (number + 1);
        System.out.printf("T(%d) = %d", number, total);
    }

}
