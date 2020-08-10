package online.rumac.main.model.exceptions;

public class IllegalCardValueException extends IllegalArgumentException {
    public IllegalCardValueException() {}
    public IllegalCardValueException(String msg) {
        super(msg);
    }
}
