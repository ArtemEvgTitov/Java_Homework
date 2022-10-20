package Seminar_01;

// Написать программу вычисления n-ого треугольного числа.

public class task_1 {
    public static void main(String[] args) {
        double number = inputDoubleNum.inputNumber();
        double total = number * (number + 1) / 2;
        System.out.printf("T(%f) = %f", number, total);
    }

}
