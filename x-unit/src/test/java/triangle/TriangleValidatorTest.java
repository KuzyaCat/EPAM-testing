package triangle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.exception.TriangleWrongDataException;
import triangle.validator.TriangleValidator;

public class TriangleValidatorTest {
    private static TriangleValidator triangleValidator;

    @BeforeClass
    public static void initTriangleValidator() {
        triangleValidator = new TriangleValidator();
    }

    @DataProvider
    public static Object[][] fractionalNumbers() {
        return new Object[][] {
                {1/3d, 1/2d, 1/4d},
                {15/6d, 15/7d, 15/8d},
                {14/6, 13/8, 12/5d}
        };
    }

    @DataProvider
    private Object[][] decimalNumbers() {
        return new Object[][] {
                {1.25, 2.25, 3.10},
                {2.51, 4.51, 6.28},
                {3, 4.15, 5.15}
        };
    }

    @DataProvider
    private Object[][] nanSides() {
        return new Object[][] {
                {1, Double.NaN, 15},
                {Double.NaN, 12, 41},
                {1, 12, Double.NaN}
        };
    }

    @DataProvider
    private Object[][] negativeSides() {
        return new Object[][] {
                {1, -5, 15},
                {-10, 12, 41},
                {1000, 500, -2000}
        };
    }

    @DataProvider
    private Object[][] zeroSides() {
        return new Object[][] {
                {1, 0, 15},
                {0, 12, 41},
                {1000, 500, 0}
        };
    }

    @DataProvider
    private Object[][] bigSides() {
        return new Object[][] {
                {Double.MAX_VALUE, Double.MAX_VALUE - 1.0, Double.MAX_VALUE - 2.0},
                {1111111111111111111111111d,1111111111111111111111111d, 1111111111111111111111111d},
                {1234567890123456789012345d,1234567890123456789012345d,1234567890123456789012345d}
        };
    }

    @DataProvider
    private Object[][] smallSides() {
        return new Object[][] {
                {Double.MIN_VALUE + 1.0, Double.MIN_VALUE + 2.0, Double.MIN_VALUE + 3.0},
                {0.0000003d, 0.0000001d, 0.0000002d},
                {0.0000000003d, 0.0000000001d, 0.0000000002d}
        };
    }

    @DataProvider
    private Object[][] existingOfIsoscelesTriangle() {
        return new Object[][] {
                {10 ,10, 8},
                {500, 500, 400},
                {16, 16, 10}
        };
    }

    @DataProvider
    private Object[][] existingOfScaleneTriangle() {
        return new Object[][] {
                {9, 10, 11},
                {16, 17, 18},
                {23, 29, 38}
        };
    }

    @DataProvider
    private Object[][] existingOfRightTriangle() {
        return new Object[][] {
                {3,4,5},
                {6,8,10},
                {16,12,20}
        };
    }

    @DataProvider
    private Object[][] existingOfEquilateralTriangle() {
        return new Object[][] {
                {5, 5, 5},
                {15, 15, 15},
                {1000, 1000, 1000}
        };
    }

    @Test(dataProvider = "fractionalNumbers")
    public void fractionalNumbers(double a, double b, double c) throws TriangleWrongDataException {
        triangleValidator.isTriangle(a, b, c);
    }

    @Test(dataProvider = "decimalNumbers")
    public void decimalNumbers(double a, double b, double c) throws TriangleWrongDataException {
        triangleValidator.isTriangle(a, b, c);
    }


    @Test(
            dataProvider = "nanSides",
            expectedExceptions = { TriangleWrongDataException.class },
            expectedExceptionsMessageRegExp = "Cannot read NaN values"
    )
    public void nanSides(double a, double b, double c) throws TriangleWrongDataException {
        triangleValidator.isTriangle(a, b, c);
    }

    @Test(
            dataProvider = "negativeSides",
            expectedExceptions = { TriangleWrongDataException.class },
            expectedExceptionsMessageRegExp = "Cannot read zero and negative values"
    )
    public void negativeSides(double a, double b, double c) throws TriangleWrongDataException {
        triangleValidator.isTriangle(a, b, c);
    }

    @Test(
            dataProvider = "zeroSides",
            expectedExceptions = { TriangleWrongDataException.class },
            expectedExceptionsMessageRegExp = "Cannot read zero and negative values"
    )
    public void zeroSides(double a, double b, double c) throws TriangleWrongDataException {
        triangleValidator.isTriangle(a, b, c);
    }

    @Test(dataProvider = "bigSides")
    public void bigSides(double a, double b, double c) throws TriangleWrongDataException {
        triangleValidator.isTriangle(a, b, c);
    }

    @Test(dataProvider = "smallSides")
    public void smallSides(double a, double b, double c) throws TriangleWrongDataException {
        triangleValidator.isTriangle(a, b, c);
    }

    @Test(dataProvider = "existingOfIsoscelesTriangle")
    public void existingOfIsoscelesTriangle(double a, double b, double c) throws TriangleWrongDataException {
        triangleValidator.isTriangle(a, b, c);
    }

    @Test(dataProvider = "existingOfScaleneTriangle")
    public void existingOfScaleneTriangle(double a, double b, double c) throws TriangleWrongDataException {
        triangleValidator.isTriangle(a, b, c);
    }

    @Test(dataProvider = "existingOfRightTriangle")
    public void existingOfRightTriangle(double a, double b, double c) throws TriangleWrongDataException {
        triangleValidator.isTriangle(a, b, c);
    }

    @Test(dataProvider = "existingOfEquilateralTriangle")
    public void existingOfEquilateralTriangle(double a, double b, double c) throws TriangleWrongDataException {
        triangleValidator.isTriangle(a, b, c);
    }
}
