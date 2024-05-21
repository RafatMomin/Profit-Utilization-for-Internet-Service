package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Rafat Momin
 * <p>
 * The ISPBusiness class performs simulation over a grid
 * plain with cells occupied by different TownCell types.
 */
public class ISPBusiness {

    public static Town updatePlain(Town oldTown) {
        Town newTown = new Town(oldTown.getLength(), oldTown.getWidth());

        for (int i = 0; i < oldTown.getWidth(); i++) {
            for (int j = 0; j < oldTown.getLength(); j++) {
                newTown.grid[i][j] = oldTown.grid[i][j].next(newTown);
            }
        }
        return newTown;
    }

    public static int getProfit(Town town) {
        int profit = 0;

        for (int i = 0; i < town.getWidth(); i++) {
            for (int j = 0; j < town.getLength(); j++) {
                if (town.grid[i][j].who() == State.CASUAL) {
                    profit++;
                }
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int userInput;

        Scanner scanner = new Scanner(System.in);

        System.out.println("How to populate grid (type 1 or 2): 1: from a file. 2: randomly with seed");
        userInput = scanner.nextInt();
        Town town = null;

        if (userInput == 1) {
            String filePath = "";
            try {
                System.out.println("Please Enter the file name: ");
                scanner.nextLine();
                filePath = scanner.nextLine();

                File file = new File(filePath);
                town = new Town(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("You've entered a invalid file path :- " + e.toString());
            }
        }

        if (userInput == 2) {
            int seed;
            int row;
            int col;
            System.out.println("Enter Rows, Cols and SEED, separated by a space: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            seed = scanner.nextInt();
            town = new Town(row, col);

            town.randomInit(seed);
        }

        double profit = 0.0;

        for (int month = 0; month < 12; month++) {
            profit += (getProfit(town) / ((double) town.getWidth() * (double) town.getLength())) * 100;
            town = updatePlain(town);
        }
        profit = profit / 12;

        System.out.printf("%.2f%c", profit, '%');
    }
}
