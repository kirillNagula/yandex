package by.nagula.exception;

public class EmptyListOfComment extends RuntimeException {

    public EmptyListOfComment() {
    }

    public EmptyListOfComment(String message) {
        super(message);
    }

    public EmptyListOfComment(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyListOfComment(Throwable cause) {
        super(cause);
    }

    public EmptyListOfComment(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
