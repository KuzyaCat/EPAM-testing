package triangle.exception;

public class TriangleWrongDataException extends Exception {
    public TriangleWrongDataException() {
    }

    public TriangleWrongDataException(String message) {
        super(message);
    }

    public TriangleWrongDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleWrongDataException(Throwable cause) {
        super(cause);
    }
}
