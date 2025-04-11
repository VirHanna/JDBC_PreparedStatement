package goit.jdbc.exception;

public class DatabaseQueryException extends RuntimeException {
    public DatabaseQueryException(String message, Throwable cause) {
        super(message, cause);
    }
}
