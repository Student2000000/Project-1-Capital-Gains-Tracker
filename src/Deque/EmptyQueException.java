public class EmptyQueException extends Exception {

    public EmptyQueException() {
        super("Queue is empty.");
    }

    public EmptyQueException(String message) {
        super(message);
    }
}
