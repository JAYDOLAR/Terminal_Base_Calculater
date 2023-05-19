package Standard_calc;

public class Calculation {
    // assigning an private variable to give it to the history.java file to stored
    // in the txt file as a history...
    private double operand1;
    private double operand2;
    private char operator;
    private double result;
    private String operation_to;

    public Calculation(String operation, double op1, double op2, char o, double result) {
        // Assigning value to new private variable from the Stan_operation.java file..
        this.operand1 = op1;
        this.operand2 = op2;
        this.operator = o;
        this.result = result;
        this.operation_to = operation;
    }

    public String toString() {
        if (operator == '√' || operator == '∛') {
            return operation_to + " of : " + operand1 + " " + operator + " = " + result;
        }
        // Generate a string representation of the calculation
        return operation_to + " of : " + operand1 + " " + operator + " " + operand2 + " = " + result;
    }
}
