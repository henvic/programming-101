package l2;
import java.util.Scanner;

public class Joviais {
    private Scanner input;

    private int[] getNumbers () {
        boolean numberBegin = false;
        boolean addDigit = false;
        boolean isDigit;
        int numberBeginPos = -1;
        int[] vector;
        int position = 0;
        char eachChar;
        String vector1;
        String temporary = "";

        vector = new int[50];

        vector1 = this.input.nextLine();

        for (int counter = 0, stringLength = vector1.length(); counter < stringLength; counter += 1) {
            eachChar = vector1.charAt(counter);
            isDigit = Character.isDigit(eachChar);

            if (isDigit) {
                temporary += eachChar;
                numberBegin = !(counter == stringLength - 1);

                if (numberBegin) {
                    numberBeginPos = counter;
                }

                if (!numberBegin) {
                    addDigit = true;
                }
            }

            if (!isDigit && numberBegin) {
                addDigit = true;
                numberBegin = false;
            }

            if (addDigit) {
                addDigit = false;
                vector[position] = Integer.parseInt(temporary);

                if (numberBeginPos > 0 && vector1.charAt(numberBeginPos - 1) == '-') {
                    vector[position] *= - 1;
                    System.out.println(vector[position]);
                }

                position += 1;
                temporary = "";
            }
        }

        return vector;
    }

    private int[] getSequence () {
        int[] sequence, numbers;

        numbers = this.getNumbers();

        sequence = new int[numbers[0]];

        System.arraycopy(numbers, 1, sequence, 0, numbers[0]);

        return sequence;
    }

    public boolean is (int[] numbers) {
        int next = 1;
        int diff;

        for (int counter = numbers.length - 1; counter > 1; counter -= 1) {
            //not allowed to use use Math.abs
            diff = numbers[counter] - numbers[counter - 1];
            if (diff != next && -diff != next) {
                return false;
            }

            next += 1;
        }

        return true;
    }

    public Joviais(Scanner input) {
        this.input = input;

        System.out.println("Números joviais\n" +
            "Entre com [n] [a...], onde n é o número de entradas e os números seguintes, a sequência:");

        System.out.println((this.is(this.getSequence())) ? "Números joviais." : "Números não joviais.");
    }

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        new Joviais(input);
    }
}
