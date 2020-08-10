package online.rumac.main.model.exceptions;

public class NoSuchCardInDeckException extends Throwable {
    public NoSuchCardInDeckException(String msg) {
        super(msg);
    }
}
