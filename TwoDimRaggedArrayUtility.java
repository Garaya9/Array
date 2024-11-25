package application;

/*
 * Class: CMSC203
 * Instructor: GARY C. THAI
 * Description: The project focuses on processing  arrays (arrays with rows of varying lengths) in Java. 
 * It involves implementing functionality to read input data representing ragged arrays, process it, 
 * and display the results through a graphical user interface (GUI). 
 * Due: 11/25/2024
 * Platform/compiler: Eclipse
 *
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * STUD NAme: G.Araya
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
    // Reads a file and creates a two-dimensional ragged array of doubles
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        double[][] data = new double[10][];
        int row = 0;

        while (scanner.hasNextLine()) {
            String[] values = scanner.nextLine().split(" ");
            double[] rowValues = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                rowValues[i] = Double.parseDouble(values[i]);
            }
            data[row++] = rowValues;
        }

        scanner.close();
        double[][] finalData = new double[row][];
        System.arraycopy(data, 0, finalData, 0, row);
        return finalData;
    }

    // Writes a two-dimensional ragged array of doubles to a file
    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        for (double[] row : data) {
            for (double value : row) {
                writer.print(value + " ");
            }
            writer.println();
        }
        writer.close();
    }

    // Returns the total of all elements in the array
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    // Returns the average of all elements in the array
    public static double getAverage(double[][] data) {
        double total = getTotal(data);
        int count = 0;
        for (double[] row : data) {
            count += row.length;
        }
        return total / count;
    }

    // Returns the total of elements in a specified row
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double value : data[row]) {
            total += value;
        }
        return total;
    }

    // Returns the total of elements in a specified column
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    // Returns the highest value in a specified row
    public static double getHighestInRow(double[][] data, int row) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double value : data[row]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }

    // Returns the index of the highest value in a specified row
    public static int getHighestInRowIndex(double[][] data, int row) {
        int highestIndex = 0;
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    // Returns the lowest value in a specified row
    public static double getLowestInRow(double[][] data, int row) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double value : data[row]) {
            if (value < lowest) {
                lowest = value;
            }
        }
        return lowest;
    }

    // Returns the index of the lowest value in a specified row
    public static int getLowestInRowIndex(double[][] data, int row) {
        int lowestIndex = 0;
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    // Returns the highest value in a specified column
    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] > highest) {
                highest = row[col];
            }
        }
        return highest;
    }

    // Returns the index of the highest value in a specified column
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int highestIndex = -1;
        double highest = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > highest) {
                highest = data[i][col];
                highestIndex = i;
            }
        }
        return highestIndex;
    }

    // Returns the lowest value in a specified column
    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] < lowest) {
                lowest = row[col];
            }
        }
        return lowest;
    }

    // Returns the index of the lowest value in a specified column
    public static int getLowestInColumnIndex(double[][] data, int col) {
        int lowestIndex = -1;
        double lowest = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < lowest) {
                lowest = data[i][col];
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    // Returns the highest value in the entire array
    public static double getHighestInArray(double[][] data) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }

    // Returns the lowest value in the entire array
    public static double getLowestInArray(double[][] data) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }
        return lowest;
    }
}
