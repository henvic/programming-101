package l4.q4;

public class InvalidInstrumentTypeException extends Exception {
    public InvalidInstrumentTypeException() {
        super();
    }

    public InvalidInstrumentTypeException(String text) {
        super(text);
    }
}
