import Standard_calc.Stan_Operation;
//import Standard_calc.History_calc.History;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Stan_Operation operation = new Stan_Operation();
        // Scientific_calc sci_operation = new Scientific_calc()
        // History history = new History();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display calculator menu
            System.out.println("\nCalculator Menu:");
            System.out.println("1. Standard Calculator\n2. Scientific Calculator\n3. Programmer Calculator\n4. Exit");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();

            // Process user's choice
            switch (choice) {
                case 1:
                    operation.menuForStandard();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("\nExiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

}