package Standard_calc;

import java.util.Scanner;
import java.lang.Math;

public class Stan_Operation {

    double op1, op2, result, reminder;
    String operation, o;
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

    double pw(double o1, double o2) {
        result = Math.pow(o1, o2);
        return result;
    }

    double nroot(double o1, double o2) {
        result = Math.pow(o1, 1.0 / o2);
        return result;
    }

    public void userInput() {
        System.out.println("\nPerforming Calculation:");
        System.out.printf("%-10s %-10s %-10s\n", "__________", "__________", "__________");
        if (o.equals("√") || o.equals("3√") || o.equals("log")) {
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

    public void menuForStandard() {
        boolean exit = false;
        while (!exit) {
            try {
                // menu for the user to choice there operation..
                System.out.println("\nCalculator Menu:");
                System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Square Root\n6. Cube Root\n7. nth Root\n8. Power\n9. Log\n10.Exit");
                System.out.print("\nEnter your choice: ");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        operation = "Addition";
                        userInput();// call the methode to input from user..
                        sum(op1, op2);// call the methode to performed the Addition of op1 and op2..
                        o = "+";
                        display();// call the funtion to display result..
                        break;
                    case 2:
                        operation = "Subtraction";
                        userInput();// call the methode to input from user
                        sub(op1, op2);// call the methode to performed the Subtraction of op1 and op2..
                        o = "-";
                        display();// call the funtion to display result..
                        break;
                    case 3:
                        operation = "Multiplication";
                        userInput();// call the methode to input from user
                        mult(op1, op2);// call the methode to performed the Multiplication of op1 and op2..
                        o = "*";
                        display();// call the funtion to display result..
                        break;
                    case 4:
                        operation = "Division";
                        userInput();// call the methode to input from user
                        if (op2 == 0) {
                            // when any value is zero then it will throw an error..
                            throw new ArithmeticException("Error: Cannot divide by zero.");
                        } else {
                            div(op1, op2);// call the methode to performed the Divisio of op1 and op2..
                            o = "/";
                            display();// call the funtion to display result..
                            break;
                        }
                    case 5:
                        operation = "Square Root";
                        o = "√";
                        userInput();
                        sqrt(op1);
                        display();
                        break;
                    case 6:
                        operation = "Cube Root";
                        o = "3√";
                        userInput();
                        curt(op1);
                        display();
                        break;
                    case 7:
                        operation = "nth Root";
                        o = "n√";
                        userInput();
                        nroot(op1, op2);
                        display();
                        break;
                    case 8:
                        operation = "Power";
                        o = "^";
                        userInput();
                        pw(op1, op2);
                        display();
                        break;
                    case 9:
                        operation = "Log (base e)";
                        o = "log";
                        userInput();
                        ln(op1);
                        display();
                        break;
                    case 10:
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
