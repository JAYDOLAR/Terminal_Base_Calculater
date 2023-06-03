package Standard_calc.History_calc;

import Standard_calc.Calculation;

import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;

public class History {
    private Calculation[] history;
    private int currentIndex;

    public History() {
        history = new Calculation[1000];
        currentIndex = 0;
    }

    public void addCalculation(String operation, double operand1, double operand2, String operator, double result) {
        if (currentIndex < history.length) {
            Calculation calculation = new Calculation(operation, operand1, operand2, operator, result);
            history[currentIndex] = calculation;
            currentIndex++;
        } else {
            System.out.println("History is full. Cannot add more calculations.");
        }
    }

    public void saveHistoryToFile() {
        try {
            FileWriter writer = new FileWriter("history.txt");
            for (int i = 0; i < currentIndex; i++) {
                writer.write(history[i].toString() + "\n");
            }
            writer.close();
            System.out.println("History saved to history.txt.");
        } catch (IOException e) {
            System.out.println("Failed to save history to file.");
            e.printStackTrace();
        }
    }
}
