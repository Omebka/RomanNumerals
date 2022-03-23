import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите натуральное число");

            Scanner scan = new Scanner (System.in);
            int number = scan.nextInt();

            String rome = "";
            String[][] numerals = {{"I", "X", "C", "M"}, {"V", "L", "D"}};

            if (number / 1000 >= 1) {
                rome = numerals[0][3].repeat(number / 1000);
                number = number % 1000;
            }

            for (int i = 2; i >= 0; i--) {
                if (number / ((int) Math.pow(10, i)) == 9) {
                    rome += numerals[0][i] + numerals[0][i + 1];
                    number = number % (9 * ((int) Math.pow(10, i)));
                }
                else {
                    if (number / ((int) Math.pow(10, i)) == 4) {
                        rome += numerals[0][i] + numerals[1][i];
                        number = number % (4 * ((int) Math.pow(10, i)));
                    }
                    else {
                        if (number / (5 * ((int) Math.pow(10, i))) >= 1) {
                            rome += numerals[1][i];
                            number = number % (5 * ((int) Math.pow(10, i)));
                        }
                        if (number / ((int) Math.pow(10, i)) >= 1) {
                            rome += numerals[0][i].repeat(number / ((int) Math.pow(10, i)));
                            number = number % (((int) Math.pow(10, i)));
                        }
                    }
                }
            }

            System.out.println(rome);
        }
    }
}