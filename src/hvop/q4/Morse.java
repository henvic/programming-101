package hvop.q4;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Morse {
    public static Map getDictionary () {
        return new HashMap<Character, String>() {
            {
                put(' ', "/");
                put('a', ".-");
                put('b', "-...");
                put('c', "-.-.");
                put('d', "-..");
                put('e', ".");
                put('f', "..-.");
                put('g', "--.");
                put('h', "....");
                put('i', "..");
                put('j', ".---");
                put('k', "-.-");
                put('l', ".-..");
                put('m', "--");
                put('n', "-.");
                put('o', "---");
                put('p', "--.-");
                put('q', "--.-");
                put('r', ".-.");
                put('s', "...");
                put('t', "-");
                put('u', "..-");
                put('v', "...-");
                put('w', ".--");
                put('x', "-..-");
                put('y', "-.--");
                put('z', "--..");
                put('á', ".--.-");
                put('ä', ".-.-");
                put('é', "..-..");
                put('ñ', "--.--");
                put('ö', "---.");
                put('ü', "..--");
                put('1', ".----");
                put('2', "..---");
                put('3', "...--");
                put('4', "....-");
                put('5', ".....");
                put('6', "-....");
                put('7', "--...");
                put('8', "---..");
                put('9', "----.");
                put('0', "-----");
                put(',', "--..--");
                put('.', ".-.-.-");
                put('?', "..--..");
                put(';', "-.-.-.");
                put(':', "---...");
                put('\'', ".----.");
                put('-', "-....-");
                put('/', "-..-.");
                put('(', "-.--.");
                put(')', "-.--.-");
            }
        };
    }

    public static String encode (String message, Map dictionary) {
        int length;
        String code = "";

        message = message.toLowerCase();
        length = message.length();

        for (int counter = 0; counter < length; counter += 1) {
            code += dictionary.get(message.charAt(counter)).toString();
        }

        return code;
    }

    public static void main (String[] args) {
        boolean exit = false;
        String message;
        Scanner input;
        Map dictionary;

        dictionary = getDictionary();

        input = new Scanner(System.in);

        System.out.println("Morse code");

        while (!exit) {
            System.out.print("Message: ");
            message = input.nextLine();
            System.out.println("Morse: " + encode(message, dictionary));
            System.out.print("Continue? (yes/no) ");
            exit = input.nextLine().equals("no");
        }
    }
}
