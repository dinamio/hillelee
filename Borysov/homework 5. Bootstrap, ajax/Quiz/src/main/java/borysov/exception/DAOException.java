package borysov.exception;

public class DAOException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DAOException() {
    }

    public DAOException(String msg) {
        super(msg);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

}
