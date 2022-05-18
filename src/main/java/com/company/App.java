package com.company;
/**
 * The App class is the main program.
 * It has a data member from Application Manager that calls all the functionalties
 * which are defined there
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */

public class App {
    private static ApplicationManager App= new ApplicationManager();
    /**
     * Main function (Application Manager)
     * @param args - Args
     */
    public static void main(String[] args) {
        System.out.println("Start of Program");
        ApplicationManager.Execute();
        System.out.println("End of Program");
    }
}
