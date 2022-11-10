package transport;

public class WrongTestDriveException extends Exception {
    public WrongTestDriveException() {
    }

    public WrongTestDriveException(String message) {
        super(message);
    }
}
