package Seminar_2;

// Написать программу, показывающую последовательность действий для игры “Ханойская башня”

public class hanoiTower {

    public static void move(int disks, char first, char second, char third) {
        if (disks == 1) {
            System.out.println("Перенести диск 1 со стержня " + first + " на стержень " + third);
        } else {
            move(disks - 1, first, third, second);
            System.out.println("Перенести диск " + disks + " со стержня " + first + " на стержень " + third);
            move(disks - 1, second, first, third);
        }
    }

    public static void main(String[] args) {
        int disks = inputIntNumber.inputNumber();
        move(disks, '1', '2', '3');

    }
}
