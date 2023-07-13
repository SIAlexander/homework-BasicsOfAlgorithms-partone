package pro.sky.exceptions;

public class IndexOutException extends RuntimeException {
    public IndexOutException() {
    }

    public IndexOutException(String message) {
        super(message);
    }

    public IndexOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexOutException(Throwable cause) {
        super(cause);
    }

    public IndexOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
