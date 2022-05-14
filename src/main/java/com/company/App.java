package com.company;

public class App {
    private static ApplicationManager App= new ApplicationManager();

    public static void main(String[] args) {
        System.out.println("Start of Program");
        ApplicationManager.Execute();
        System.out.println("End of Program");
    }
}
