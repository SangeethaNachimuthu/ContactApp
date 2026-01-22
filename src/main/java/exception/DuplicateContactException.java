package exception;

public class DuplicateContactException extends Exception {

    public DuplicateContactException(String message) {
        super(message);
    }

    public DuplicateContactException(String message, Throwable cause) {
        super(message, cause);
    }
}
