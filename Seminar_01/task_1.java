package Seminar_01;

// import Seminar_01.input_num;

public class task_1 {
    public static void main(String[] args) {
        int number = input_num.input_number();
        int total = number / 2 * (number + 1);
        System.out.printf("T(%d) = %d", number, total);
    }

}
