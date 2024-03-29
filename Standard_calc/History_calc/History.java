package Standard_calc.History_calc;

import Standard_calc.Calculation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        // try {
        // FileWriter writer = new FileWriter("history.txt", true);
        // for (int i = 0; i < currentIndex; i++) {
        // writer.write(history[i].toString() + "\n");
        // }
        // writer.close();
        // System.out.println("History saved to history.txt.");
        // } catch (IOException e) {
        // System.out.println("Failed to save history to file.");
        // e.printStackTrace();
        // }

        try {
            PrintWriter writer = new PrintWriter("history.txt");
            writer.close();
            FileWriter fileWriter = new FileWriter("history.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the history to the file
            for (int i = 0; i < currentIndex; i++) {
                bufferedWriter.write(history[i].toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
            System.out.println("History saved to history.txt.");
        } catch (IOException e) {
            System.out.println("Failed to save history to file.");
            e.printStackTrace();
        }
    }

    public void displayHistoryFile() {
        // try {
        // BufferedReader reader = new BufferedReader(new FileReader("history.txt"));
        // String line;
        // while ((line = reader.readLine()) != null) {
        // System.out.println("\nHistory :- \n\n" + line);
        // }
        // reader.close();
        // } catch (IOException e) {
        // System.out.println("Failed to read history from file.");
        // e.printStackTrace();
        // }

        System.out.println("\nHistory :-");
        try {
            FileReader fileReader = new FileReader("history.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}