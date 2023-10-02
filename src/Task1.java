
public class Task1 {
    public static Integer operation(int a, int b, String opchar) {
        try {
            switch (opchar) {

                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/": {
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    return a / b;
                }
                default:
                    throw new IllegalArgumentException("Invalid character");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }
}