package l1;
import java.util.Scanner;
import java.util.Arrays;

public class FindMe {
    public static int gcd (int a, int b) {
        int temp;

        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static int lcm (int a, int b) {
        int res = 0;

        if (a != 0 && b != 0) {
            res = (a * b) / gcd(a, b);
        }

        return res;
    }

    public static void main (String[] args) {
        int factor = 2;
        int number = 1;
        boolean[] multiples = new boolean[101];
        boolean divisible;
        boolean canBeZero = true;
        boolean jump = false;

        Scanner input;

        Arrays.fill(multiples, Boolean.FALSE);

        input = new Scanner(System.in);

        System.out.println("Escolha um número de 0 a 100 e deixe-me adivinhar.");

        while (factor <= 100) {
            if (lcm(number, factor) >= 100) {
                factor += 1;
                continue;
            }

            for (int counter = factor - 1; counter > 1; counter -= 1) {
                if ((factor % counter) == 0) {
                    if (!multiples[counter]) {
                        jump = true;
                    }
                }
            }

            if (jump) {
                divisible = false;
            } else if ((number % factor) == 0) {
                divisible = true;
            } else {
                System.out.print("Seu número é divisível por " + factor + " (s/n)? ");
                divisible = input.nextLine().equalsIgnoreCase("s");
            }

            jump = false;

            if (divisible) {
                multiples[factor] = true;
                number = lcm(number, factor);
            } else {
                canBeZero = false;
            }

            factor += 1;
        }

        if (canBeZero) {
            System.out.print("É um número que divisível por qualquer número dá ele mesmo (s/n)? ");
            canBeZero = input.nextLine().equalsIgnoreCase("s");
        }

        if (canBeZero) {
            number = 0;
        }

        System.out.println("Número: " + number);
    }
}
