package by.nagula.exception;

public class EmptyDateInLogin extends RuntimeException {
    public EmptyDateInLogin() {
    }

    public EmptyDateInLogin(String message) {
        super(message);
    }

    public EmptyDateInLogin(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyDateInLogin(Throwable cause) {
        super(cause);
    }

    public EmptyDateInLogin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
