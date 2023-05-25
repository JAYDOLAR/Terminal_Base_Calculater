package Standard_calc;

public class Calculation {
    // assigning an private variable to give it to the history.java file to stored
    // in the txt file as a history...
    private double operand1;
    private double operand2;
    private String operator;
    private double result;
    private String operation_to;

    public Calculation(String operation, double op1, double op2, String o, double result) {
        // Assigning value to new private variable from the Stan_operation.java file..
        this.operand1 = op1;
        this.operand2 = op2;
        this.operator = o;
        this.result = result;
        this.operation_to = operation;
    }

    public String toString() {
        if (operator.equals("√") || operator.equals("3√")) {
            return operation_to + " of : " + operator + " " + operand1 + " = " + result;
        } else if (operator.equals("log") || operator.equals("sin") || operator.equals("cos")
                || operator.equals("tan") || operator.equals("cosec") || operator.equals("sec")
                || operator.equals("cot") || operator.equals("fact")) {
            return operation_to + " is : " + operator + " ( " + operand1 + " ) = " + result;
        }
        // Generate a string representation of the calculation
        return operation_to + " of : " + operand1 + " " + operator + " " + operand2 + " = " + result;
    }
}
