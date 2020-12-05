package triangle.validator;

import triangle.exception.TriangleWrongDataException;

public class TriangleValidator {
    public static boolean isTriangle(double a, double b, double c) throws TriangleWrongDataException {
        if (a > 0 && b > 0 && c > 0 ) {
            return a < b + c && b < a + c && c < a + b;
        } else if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c)) {
            throw new TriangleWrongDataException("Cannot read NaN values");
        } else {
            throw new TriangleWrongDataException("Cannot read zero and negative values");
        }
    }
}
