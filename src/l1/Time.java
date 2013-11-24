package l1;
import java.util.Scanner;

public class Time {
    private static int getDeltaMin (String now, String then) {
        int hNow, minNow, hThen, minThen, delta;

        hNow = Integer.parseInt(now.substring(0, 2));
        minNow = Integer.parseInt(now.substring(3, 5));
        hThen = Integer.parseInt(then.substring(0, 2));
        minThen = Integer.parseInt(then.substring(3, 5));

        if (hNow == 24) {
            hNow = 0;
        }

        if (hThen == 24) {
            hThen = 0;
        }

        delta = ((hThen - hNow) * 60) + (minThen - minNow);

        return delta;
    }

    private static String getPalindromeTime (String now, int h, int min) {
        String temporary, palindrome;

        if (Integer.parseInt(h + "" + min) >= Integer.parseInt(h + "" + now.substring(0, 1) + "" + now.substring(1, 2))) {
            h = (h == 24) ? 1 : h + 1;
        }

        while (true) {
            temporary = Integer.toString(h);

            if (h < 10) {
                temporary = "0" + temporary;
            }

            palindrome = temporary + ":" + temporary.charAt(1) + "" + temporary.charAt(0);

            //between 06-09 and 16-19 it' gonna fail
            if (Integer.parseInt(temporary.charAt(1) + "" + temporary.charAt(0)) < 60) {
                break;
            }

            h += 1;
        }

        return palindrome;
    }

    private static String getRepeatedTime (int h, int min) {
        String repeated;

        if (Integer.parseInt(h + "" + min) >= Integer.parseInt(h + "" + h)) {
            h = (h == 24) ? 1 : h + 1;
        }

        repeated = Integer.toString(h);

        if (h < 10) {
            repeated = "0" + repeated;
        }

        repeated = repeated + ":" + repeated;

        return repeated;
    }

    public static void main (String[] args) {
        int h, min;
        String now, repeated, palindrome;
        Scanner input;

        input = new Scanner(System.in);

        System.out.print("Digite a hora no formato <hh:mm>: ");
        now = input.nextLine();

        h = Integer.parseInt(now.substring(0, 2));
        min = Integer.parseInt(now.substring(3, 5));

        repeated = getRepeatedTime(h, min);
        palindrome = getPalindromeTime(now, h, min);

        System.out.println("A próxima hora repetida é: " + repeated + "\n" +
                "Alguém pensará em você em " + getDeltaMin(now, repeated) + " minutos");

        System.out.println("A próxima hora palíndroma é: " + palindrome + "\n" +
                "Faça um pedido em " + getDeltaMin(now, palindrome) + " minutos");
    }
}
