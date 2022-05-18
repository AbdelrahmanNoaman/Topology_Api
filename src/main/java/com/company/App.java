package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The App class is the main program.
 * It has a data member from Application Manager that calls all the functionalties
 * which are defined there
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */

public class App {
    private static ApplicationManager App = new ApplicationManager();
    private static Testing test = new Testing();

    /**
     * Main function (Application Manager)
     *
     * @param args - Args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("(1) Execute Main Functionalities:");
            System.out.println("(2) Execute Testing: ");
            System.out.println("(3) exit");
            int WantedFunctionality = 0;
            try {
                WantedFunctionality = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            switch (WantedFunctionality) {
                case 1 -> {
                    System.out.println("Start of Executing Main Functionalities");
                    ApplicationManager.Execute();
                    System.out.println("End of Executing Main Functionalities");
                }
                case 2 -> {
                    System.out.println("Start of Executing Testing");
                    test.testAll();
                    System.out.println("End of Executing Testing");
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }
}
