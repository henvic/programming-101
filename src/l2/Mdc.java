package l2;
import java.util.Scanner;

public class Mdc {
    public int lcm (int a, int b) {
        int temp;

        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }

        if (b == 0) {
            return a;
        }

        //only using a recursive function here because that's what was asked for
        return this.lcm(b, a % b);
    }

    private int[] mdcArrays (int[] a, int[] b) {
        int[] mdc;
        int amount = a.length;

        mdc = new int[amount];

        for (int counter = 0; counter < amount; counter += 1) {
            mdc[counter] = this.lcm(a[counter], b[counter]);
        }

        return mdc;
    }

    public Mdc () {
        int amount;
        int[] numbers1, numbers2, mdc;

        Scanner input;

        input = new Scanner(System.in);

        do {
            System.out.print("Quantidade de pares? ");
            amount = input.nextInt();
            input.nextLine();

            if (amount < 0) {
                System.out.println("Por favor, use inteiros positivos.");
            }
        } while (amount < 0);

        numbers1 = new int[amount];
        numbers2 = new int[amount];

        for (int counter = 0; counter < amount; counter += 1) {
            do {
                System.out.print("\nPar " + (counter + 1) + "/1: ");
                numbers1[counter] = input.nextInt();

                System.out.print("Par " + (counter + 1) + "/2: ");
                numbers2[counter] = input.nextInt();

                if (numbers1[counter] < 0 || numbers1[counter] < 0) {
                    System.out.println("Por favor, use inteiros positivos.");
                }
            } while (numbers1[counter] < 0 || numbers1[counter] < 0);
        }

        mdc = this.mdcArrays(numbers1, numbers2);

        for (int counter = 0; counter < amount; counter += 1) {
            System.out.println("\nmdc(" + numbers1[counter] + ", " + numbers2[counter] + ") = " + mdc[counter]);
        }
    }

    public static void main (String[] args) {
        new Mdc();
    }
}
