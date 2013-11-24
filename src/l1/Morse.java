package hvop.q4;
import java.util.Scanner;

public class Morse {
    private static String translate (char c) {
        //fallback to the original char if there's no morse code associated to it
        //just to make it easier to see if any of the required translation rules is missing
        String word = Character.toString(c);

        switch (c) {
            case ' ': word = "/"; break;
            case 'a': word = ".-"; break;
            case 'b': word = "-..."; break;
            case 'c': word = "-.-."; break;
            case 'd': word = "-.."; break;
            case 'e': word = "."; break;
            case 'f': word = "..-."; break;
            case 'g': word = "--."; break;
            case 'h': word = "...."; break;
            case 'i': word = ".."; break;
            case 'j': word = ".---"; break;
            case 'k': word = "-.-"; break;
            case 'l': word = ".-.."; break;
            case 'm': word = "--"; break;
            case 'n': word = "-."; break;
            case 'o': word = "---"; break;
            case 'p': word = "--.-"; break;
            case 'q': word = "--.-"; break;
            case 'r': word = ".-."; break;
            case 's': word = "..."; break;
            case 't': word = "-"; break;
            case 'u': word = "..-"; break;
            case 'v': word = "...-"; break;
            case 'w': word = ".--"; break;
            case 'x': word = "-..-"; break;
            case 'y': word = "-.--"; break;
            case 'z': word = "--.."; break;
            case 'á': word = ".--.-"; break;
            case 'ä': word = ".-.-"; break;
            case 'é': word = "..-.."; break;
            case 'ñ': word = "--.--"; break;
            case 'ö': word = "---."; break;
            case 'ü': word = "..--"; break;
            case '1': word = ".----"; break;
            case '2': word = "..---"; break;
            case '3': word = "...--"; break;
            case '4': word = "....-"; break;
            case '5': word = "....."; break;
            case '6': word = "-...."; break;
            case '7': word = "--..."; break;
            case '8': word = "---.."; break;
            case '9': word = "----."; break;
            case '0': word = "-----"; break;
            case ',': word = "--..--"; break;
            case '.': word = ".-.-.-"; break;
            case '?': word = "..--.."; break;
            case ';': word = "-.-.-."; break;
            case ':': word = "---..."; break;
            case '\'': word = ".----."; break;
            case '-': word = "-....-"; break;
            case '/': word = "-..-."; break;
            case '(': word = "-.--."; break;
            case ')': word = "-.--.-"; break;
        }

        return word;
    }

    public static String encode (String message) {
        int length;
        String code = "";

        message = message.toLowerCase();
        length = message.length();

        for (int counter = 0; counter < length; counter += 1) {
            code += translate(message.charAt(counter));
        }

        return code;
    }

    public static void main (String[] args) {
        boolean exit = false;
        String message;
        Scanner input;

        input = new Scanner(System.in);

        System.out.println("Morse code");

        while (!exit) {
            System.out.print("Message: ");
            message = input.nextLine();
            System.out.println("Morse: " + encode(message));
            System.out.print("Continue? (yes/no) ");
            exit = input.nextLine().equals("no");
        }
    }
}
