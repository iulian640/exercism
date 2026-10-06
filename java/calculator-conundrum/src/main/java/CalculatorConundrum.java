class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {

        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        if (operation.isBlank()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        if (operation != "/" && operation != "*" && operation != "+") {
            throw new IllegalOperationException("Operation " + "'" + operation + "'" + " does not exist");
        }
        if (operand2 == 0 && operation == "/") {

        }
        switch (operation) {
            case "+":
                int sum = operand1 + operand2;
                return operand1 + " + " + operand2 + " = " + sum;

            case "*":
                int mult = operand1 * operand2;
                return operand1 + " * " + operand2 + " = " + mult;

            case "/":
                try {
                    int div = operand1 / operand2;
                    return operand1 + " / " + operand2 + " = " + div;
                } catch (ArithmeticException e) {
                    throw new IllegalOperationException("Division by zero is not allowed", e);
                }
            default:
                return operation;
        }
    }
}
