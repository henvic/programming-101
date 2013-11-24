package l1;
import java.util.Scanner;

public class Base {
    public static int numberToBase(String number, int base) {
        int output = 0;
        boolean negative = (number.charAt(0) == '-');

        if (negative) {
            number = number.substring(1);
        }

        for (int pos = 0, numberLength = number.length(); pos < numberLength; pos += 1) {
            output += (Character.digit(number.charAt(pos), 10) * Math.pow(base, numberLength - pos - 1));
        }

        if (negative) {
            output *= -1;
        }

        return output;
    }

    public static void main(String[] args) {
        boolean exit = false;
        boolean hasBase = false;
        int base = 2;
        String number;
        Scanner input;

        input = new Scanner(System.in);

        while (!exit) {
            if (!hasBase) {
                System.out.print("Base de enumeração: ");
                base = input.nextInt();
                input.nextLine();
            }

            System.out.print("Número na base " + base + ": ");
            input.hasNextLine();
            number = input.nextLine();

            System.out.println("Decimal: " + numberToBase(number, base));

            System.out.print("Continuar com a base " + base + "? (y/n): ");
            hasBase = input.nextLine().equals("y");

            if (!hasBase) {
                System.out.print("Deseja usar outra base? (y/n): ");
                exit = input.nextLine().equals("n");
            }
        }
    }
}
