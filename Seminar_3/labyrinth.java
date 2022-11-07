package Seminar_3;

import java.util.ArrayList;
import Seminar_2.inputIntNumber;

public class labyrinth {
    static int[][] field;
    static int number_steps = 1;
    static Сoordinates starting = new Сoordinates();
    static Сoordinates finishing = new Сoordinates();
    static ArrayList<Сoordinates> queue = new ArrayList<Сoordinates>();
    static ArrayList<Сoordinates> copy_queue = new ArrayList<Сoordinates>();

    public static void main(String[] args) {
        int num_start = -5;
        int num_finish = -7;
        int num_wall = -1;

        System.out.println("\nДан лабиринт: ");
        field = get_matrix();
        print_matrix(field, num_start, num_finish, num_wall);

        System.out.println("\nСтроим все возможные маршруты: ");
        wave(num_start, num_finish, num_wall);

        number_steps -= 1;

        print_matrix(field, num_start, num_finish, num_wall);
        System.out.println("\nКратчайший путь: " + number_steps + " шагов");

        finding_path();
        System.out.println("\nСамый короткий маршрут:");
        print_matrix(field, num_start, num_finish, num_wall);
    }

    static int[][] get_matrix() {
        System.out.println("Строки");
        int row = inputIntNumber.inputNumber();
        while (row == 0) {
            System.out.println("Повторите ввод");
            row = inputIntNumber.inputNumber();
        }
        System.out.println("Столбики");
        int column = inputIntNumber.inputNumber();
        while (column == 0) {
            System.out.println("Повторите ввод");
            column = inputIntNumber.inputNumber();
        }
        int[][] field = new int[row][column];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = 0;
            }
        }
        int block = row * column / 4;
        while (block > 0) {
            int randomRow = (int) (Math.random() * row);
            int randomColumn = (int) (Math.random() * column);
            field[randomRow][randomColumn] = -1;
            block--;
        }
        int randomRow = (int) (Math.random() * row);
        int randomColumn = (int) (Math.random() * column);
        field[randomRow][randomColumn] = -5;
        randomRow = (int) (Math.random() * row);
        randomColumn = (int) (Math.random() * column);
        field[randomRow][randomColumn] = -7;
        return field;
    }

    static void print_matrix(int[][] arr, int start, int finish, int wall) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    System.out.printf("▒▒▒");
                } else if (arr[i][j] == wall) {
                    System.out.printf("███");
                } else if (arr[i][j] == finish) {
                    System.out.printf("╳╳╳");
                } else if (arr[i][j] == start) {
                    System.out.printf("╪╪╪");

                } else if (arr[i][j] == -2) {
                    System.out.printf("   ");

                } else {
                    if (number_steps <= 0) {
                        System.out.printf("▒▒▒");
                    } else {
                        System.out.printf("%d ", arr[i][j]);
                    }
                }
            }
            System.out.println();
        }
    }

    static void wave(int start, int finish, int wall) {
        int k, m;
        find_point(starting, start);
        find_point(finishing, finish);
        boolean stop = false;

        queue.add(starting);

        while (queue.size() != 0) {
            copy_queue.clear();
            copy_queue.addAll(0, queue);
            queue.clear();
            for (int i = 0; i < copy_queue.size(); i++) {

                Сoordinates Temp_point = copy_queue.get(i);
                k = Temp_point.i;
                m = Temp_point.j;

                if (k > 0) {
                    stop = step_left(k, m);
                }
                if (k < field.length - 1) {
                    stop = step_right(k, m);
                }
                if (m > 0) {
                    stop = step_up(k, m);
                }
                if (m < field[m].length - 1) {
                    stop = step_down(k, m);
                }
                if (stop == true) {
                    queue.clear();
                    break;
                }
            }
            number_steps += 1;
        }
    }

    static void find_point(Сoordinates N_point, int number) {
        boolean flag = true;
        for (int i = 0; i < field.length; i++) {
            if (flag) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == number) {
                        N_point.i = i;
                        N_point.j = j;
                        flag = false;
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }

    static boolean step_left(int i, int j) {
        if (finishing.i == i - 1 && finishing.j == j) {
            return true;
        } else if (field[i - 1][j] == 0) {
            field[i - 1][j] = number_steps;
            queue.add(new Сoordinates(i - 1, j));
        }
        return false;
    }

    static boolean step_right(int i, int j) {
        if (finishing.i == i + 1 && finishing.j == j) {
            return true;
        } else if (field[i + 1][j] == 0) {
            field[i + 1][j] = number_steps;
            queue.add(new Сoordinates(i + 1, j));
        }
        return false;
    }

    static boolean step_up(int i, int j) {
        if (finishing.i == i && finishing.j == j - 1) {
            return true;
        } else if (field[i][j - 1] == 0) {
            field[i][j - 1] = number_steps;
            queue.add(new Сoordinates(i, j - 1));
        }
        return false;
    }

    static boolean step_down(int i, int j) {
        if (finishing.i == i && finishing.j == j + 1) {
            return true;
        } else if (field[i][j + 1] == 0) {
            field[i][j + 1] = number_steps;
            queue.add(new Сoordinates(i, j + 1));
        }
        return false;
    }

    static void finding_path() {
        boolean flag = true;
        int i = finishing.i;
        int j = finishing.j;
        number_steps -= 1;

        while (flag == true) {

            if ((starting.i == i && starting.j == j) || number_steps <= 0) {
                break;
            }

            if (j > 0 && field[i][j - 1] == number_steps) {
                field[i][j - 1] = -2;
                j -= 1;
                number_steps -= 1;
                continue;
            } else if (i > 0 && field[i - 1][j] == number_steps) {
                field[i - 1][j] = -2;
                i -= 1;
                number_steps -= 1;
                continue;
            } else if (i < field.length - 1 && field[i + 1][j] == number_steps) {
                field[i + 1][j] = -2;
                i += 1;
                number_steps -= 1;
                continue;
            } else if (j < field[j].length - 1 && field[i][j + 1] == number_steps) {
                field[i][j + 1] = -2;
                j += 1;
                number_steps -= 1;
                continue;
            }
        }
    }
}

class Сoordinates {
    int i, j;

    Сoordinates() {
        this.i = -1;
        this.j = -1;
    }

    Сoordinates(int i, int j) {
        this.i = i;
        this.j = j;
    }
}