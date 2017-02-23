package week4;

/**
 *
 * @author hgontarz
 */
public class HexFormatException extends Exception {
    public HexFormatException() {
        super("Invalid hex number format!");
    }

    public HexFormatException(String message) {
        super(message);
    }
}
