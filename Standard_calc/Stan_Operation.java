package Standard_calc;

import java.util.Scanner;

import Standard_calc.History_calc.History;

import java.lang.Math;

class submenuforoperation {

    double op1, op2, result , reminder = 0;
    String operation, o = " ";
    Scanner sc = new Scanner(System.in);

    double sum(double o1, double o2) {
        result = o1 + o2;
        return result;
    }

    double sub(double o1, double o2) {
        result = o1 - o2;
        return result;
    }

    double mult(double o1, double o2) {
        result = o1 * o2;
        return result;
    }

    double div(double o1, double o2) {
        result = o1 / o2;
        reminder = o1 % o2;
        return result + reminder;
    }

    double sqrt(double o1) {
        result = Math.sqrt(o1);
        return result;
    }

    double curt(double o1) {
        result = Math.cbrt(o1);
        return result;
    }

    double ln(double o1) {
        result = Math.log(o1);
        return result;
    }

    public double pw(double o1, double o2) {
        result = Math.pow(o1, o2);
        return result;
    }

    double nroot(double o1, double o2) {
        result = Math.pow(o1, 1.0 / o2);
        return result;
    }

    double sin(double o1) {
        result = Math.sin(o1);
        return result;
    }

    double cos(double o1) {
        result = Math.cos(o1);
        return result;
    }

    double tan(double o1) {
        result = Math.tan(o1);
        return result;
    }

    double cosec(double o1) {
        result = 1.0 / Math.sin(o1);
        return result;
    }

    double sec(double o1) {
        result = +1.0 / Math.cos(o1);
        return result;
    }

    double cot(double o1) {
        result = +1.0 / Math.tan(o1);
        return result;
    }

    double fact(double o1) {
        result = 1;
        for (int i = 1; i <= o1; i++) {
            result *= i;
        }
        return result;
    }

    public void userInput() {
        System.out.println("\nPerforming Calculation:");
        System.out.printf("%-10s %-10s %-10s\n", "__________", "__________", "__________");
        if (o.equals("√") || o.equals("3√") || o.equals("log") || o.equals("sin") || o.equals("cos")
                || o.equals("tan") || o.equals("cosec") || o.equals("sec") || o.equals("cot") || o.equals("fact")) {
            System.out.print("\nEnter the Value for " + operation + " " + o + ": ");
            this.op1 = sc.nextDouble();
        } else {
            System.out.print("\nEnter First Value: ");
            this.op1 = sc.nextDouble();
            System.out.print("Enter Second Value: ");
            this.op2 = sc.nextDouble();
        }
        System.out.printf("%-10s %-10s %-10s\n", "__________", "__________", "__________");
    }

    public void display() {
        System.out.println("_______________");
        Calculation calculation = new Calculation(operation, op1, op2, o, result);
        System.out.println("\nResult: \n" + calculation.toString());
        if (o.equals("/")) {
            System.out.println("Reminder is : " + reminder);
        }
        System.out.println("_______________");
    }
}

public class Stan_Operation extends submenuforoperation {
    public void menuForStandard() {
        boolean exit = false;
        History h = new History();
        while (!exit) {
            try {
                // menu for the user to choose their operation..
                System.out.println("\nCalculator Menu:");
                System.out.println(
                        "1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Square Root\n6. Cube Root\n7. nth Root\n8. Power\n9. Log\n10.Factorial(n!)\n11.TRIGONOMETRIC_OPERATION\n12.Exit");
                System.out.print("\nEnter your choice: ");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        operation = "Addition";
                        userInput();// call the method to input from the user..
                        sum(op1, op2);// call the method to perform the Addition of op1 and op2..
                        o = "+";
                        display();// call the function to display the result..
                        h.addCalculation(operation, op1, op2, o, result);
                        h.saveHistoryToFile();
                        break;
                    case 2:
                        operation = "Subtraction";
                        userInput();// call the method to input from the user
                        sub(op1, op2);// call the method to perform the Subtraction of op1 and op2..
                        o = "-";
                        display();// call the function to display the result..
                        h.addCalculation(operation, op1, op2, o, result);
                        h.saveHistoryToFile();
                        break;
                    case 3:
                        operation = "Multiplication";
                        userInput();// call the method to input from the user
                        mult(op1, op2);// call the method to perform the Multiplication of op1 and op2..
                        o = "*";
                        display();// call the function to display the result..
                        h.addCalculation(operation, op1, op2, o, result);
                        h.saveHistoryToFile();
                        break;
                    case 4:
                        operation = "Division";
                        userInput();// call the method to input from the user
                        if (op2 == 0 && op1 == 0) {
                            // when any value is zero, it will throw an error..
                            throw new ArithmeticException("Error: Cannot divide by zero.");
                        } else {
                            div(op1, op2);// call the method to perform the Division of op1 and op2..
                            o = "/";
                            display();// call the function to display the result..
                            h.addCalculation(operation, op1, op2, o, result);
                            h.saveHistoryToFile();
                            break;
                        }
                    case 5:
                        operation = "Square Root";
                        o = "√";
                        userInput();
                        sqrt(op1);
                        display();
                        h.addCalculation(operation, op1, op2, o, result);
                        h.saveHistoryToFile();
                        break;
                    case 6:
                        operation = "Cube Root";
                        o = "3√";
                        userInput();
                        curt(op1);
                        display();
                        h.addCalculation(operation, op1, op2, o, result);
                        h.saveHistoryToFile();
                        break;
                    case 7:
                        operation = "nth Root";
                        o = "n√";
                        userInput();
                        nroot(op1, op2);
                        display();
                        h.addCalculation(operation, op1, op2, o, result);
                        h.saveHistoryToFile();
                        break;
                    case 8:
                        operation = "Power";
                        o = "^";
                        userInput();
                        pw(op1, op2);
                        display();
                        h.addCalculation(operation, op1, op2, o, result);
                        h.saveHistoryToFile();
                        break;
                    case 9:
                        operation = "Log (base e)";
                        o = "log";
                        userInput();
                        ln(op1);
                        display();
                        h.addCalculation(operation, op1, op2, o, result);
                        h.saveHistoryToFile();
                        break;
                    case 10:
                        operation = "Factorial";
                        o = "fact";
                        userInput();
                        fact(op1);
                        display();
                        h.addCalculation(operation, op1, op2, o, result);
                        h.saveHistoryToFile();
                        break;
                    case 11:
                        while (!exit) {
                            System.out.println("\nTRIGONOMETRIC_OPERATION : ");
                            System.out.println("1. SINE\n2. COS\n3. TAN\n4. COSEC\n5. SEC\n6. COT\n7. Exit");
                            System.out.print("\nEnter your choice: ");
                            int choice_2 = sc.nextInt();
                            switch (choice_2) {
                                case 1:
                                    operation = "Sin";
                                    o = "sin";
                                    userInput();
                                    sin(op1);
                                    display();
                                    h.addCalculation(operation, op1, op2, o, result);
                                    h.saveHistoryToFile();
                                    break;
                                case 2:
                                    operation = "Cos";
                                    o = "cos";
                                    userInput();
                                    cos(op1);
                                    display();
                                    h.addCalculation(operation, op1, op2, o, result);
                                    h.saveHistoryToFile();
                                    break;
                                case 3:
                                    operation = "Tan";
                                    o = "tan";
                                    userInput();
                                    tan(op1);
                                    display();
                                    h.addCalculation(operation, op1, op2, o, result);
                                    h.saveHistoryToFile();
                                    break;
                                case 4:
                                    operation = "Cosec";
                                    o = "cosec";
                                    userInput();
                                    cosec(op1);
                                    display();
                                    h.addCalculation(operation, op1, op2, o, result);
                                    h.saveHistoryToFile();
                                    break;
                                case 5:
                                    operation = "Sec";
                                    o = "sec";
                                    userInput();
                                    sec(op1);
                                    display();
                                    h.addCalculation(operation, op1, op2, o, result);
                                    h.saveHistoryToFile();
                                    break;
                                case 6:
                                    operation = "Cot";
                                    o = "cot";
                                    userInput();
                                    cot(op1);
                                    display();
                                    h.addCalculation(operation, op1, op2, o, result);
                                    h.saveHistoryToFile();
                                    break;
                                case 7:
                                    exit = true;
                                    break;
                                default:
                                    System.out.println("\nInvalid choice. Please enter a valid trigonometric operation. \n");
                                    break;
                            }
                        }
                        break;
                    case 12:
                        exit = true;
                        break;
                    default:
                        System.out.println("\nInvalid choice.\n");
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println("\n" + e.getMessage());
            }
        }
    }
}
