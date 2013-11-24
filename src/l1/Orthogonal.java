package l1;
import java.util.Scanner;

public class Orthogonal {
    public static int getDotProduct (int[] vector1, int[] vector2) {
        int length = vector1.length;
        int dotProduct = 0;

        for (int counter = 0; counter < length; counter++) {
            dotProduct += (vector1[counter] * vector2[counter]);
        }

        return dotProduct;
    }

    public static boolean isVectorNull (int[] vector) {
        for (int p : vector) {
            if (p != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isOrthogonal (int[] vector1, int[] vector2) {
        return (getDotProduct(vector1, vector2) == 0);
    }

    /**
     * Pega as coordenadas
     * Para esse caso ignoramos completamente o sinal -
     * pois, dadas as propriedades dos vetores ele
     * não é necessário
     */
    private static int[] getVector() {
        boolean numberBegin = false;
        boolean addDigit = false;
        boolean isDigit;
        int[] vector;
        int position = 0;
        char eachChar;
        String vector1;
        String temporary = "";
        Scanner input;

        input = new Scanner(System.in);
        vector = new int[3];

        vector1 = input.nextLine();

        for (int counter = 0, stringLength = vector1.length(); counter < stringLength; counter++) {
            eachChar = vector1.charAt(counter);
            isDigit = Character.isDigit(eachChar);

            if (isDigit) {
                temporary += eachChar;
                numberBegin = !(counter == stringLength - 1);

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
                position += 1;
                temporary = "";
            }
        }

        return vector;
    }

    public static void main (String[] args) {
        boolean exit = false;

        Scanner input;

        int v1[], v2[];

        input = new Scanner(System.in);

        while (!exit) {
            System.out.println("Entre dois vetores na forma (x, y, z):");

            v1 = getVector();
            v2 = getVector();

            if (isVectorNull(v1) || isVectorNull(v2)) {
                System.out.println("Entre vetores não nulos");
                continue;
            }

            System.out.println(isOrthogonal(v1, v2) ? "Ortogonal" : "Não ortogonal");
            System.out.print("Deseja continuar? (s/n): ");

            exit = input.nextLine().equals("n");
        }
    }
}
