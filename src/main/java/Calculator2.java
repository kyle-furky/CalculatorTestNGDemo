public class Calculator2 {

    // Addition
    public long add(int a, int b) {
        return (long) a + b; // cast to long to handle overflow
    }

    // Subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Multiplication
    public long multiply(int a, int b) {
        return (long) a * b; // cast to long to handle large results
    }

    // Division
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}
