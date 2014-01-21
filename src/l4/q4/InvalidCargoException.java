package l4.q4;

public class InvalidCargoException extends Exception {
    public InvalidCargoException() {
        super();
    }

    public InvalidCargoException(String text) {
        super(text);
    }
}
