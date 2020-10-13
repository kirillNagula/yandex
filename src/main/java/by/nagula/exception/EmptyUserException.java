package by.nagula.exception;

public class EmptyUserException extends RuntimeException {

    public EmptyUserException() {
    }

    public EmptyUserException(String message) {
        super(message);
    }

    public EmptyUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyUserException(Throwable cause) {
        super(cause);
    }

    public EmptyUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
