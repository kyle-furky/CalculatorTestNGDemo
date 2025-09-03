import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Calculator2Test {

    private Calculator2 calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator2();
    }

    // ✅ Positive Test: Addition with multiple inputs
    @DataProvider(name = "additionData")
    public Object[][] additionData() {
        return new Object[][] {
                {2, 3, 5},
                {-2, 3, 1},
                {0, 0, 0},
                {Integer.MAX_VALUE, 1, (long) Integer.MAX_VALUE + 1} // edge case with overflow
        };
    }

    @Test(dataProvider = "additionData")
    public void testAddition(int a, int b, long expected) {
        long result = calculator.add(a, b);
        Assert.assertEquals(result, expected, "Addition result mismatch!");
    }

    // ✅ Negative Test: Division by Zero
    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        calculator.divide(10, 0);
    }

    // ✅ Boundary Test: Subtraction with min/max values
    @Test
    public void testSubtractionWithBoundaries() {
        int result = calculator.subtract(Integer.MIN_VALUE, 1);
        Assert.assertEquals(result, Integer.MAX_VALUE); // overflow behavior
    }

    // ✅ Data-driven Division Test
    @DataProvider(name = "divisionData")
    public Object[][] divisionData() {
        return new Object[][] {
                {10, 2, 5},
                {9, 3, 3},
                {-15, 3, -5}
        };
    }

    @Test(dataProvider = "divisionData")
    public void testDivision(int a, int b, int expected) {
        int result = calculator.divide(a, b);
        Assert.assertEquals(result, expected, "Division result mismatch!");
    }

    // ✅ Multiplication Test
    @Test
    public void testMultiplication() {
        long result = calculator.multiply(20000, 20000);
        Assert.assertEquals(result, 400_000_000L, "Multiplication result mismatch!");
    }
}
