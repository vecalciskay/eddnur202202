package nur.p3.patrondao.shared;

public class DaoException extends Exception {

    public DaoException(String message) {
        super(message);
    }
    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException() {
    }
}
