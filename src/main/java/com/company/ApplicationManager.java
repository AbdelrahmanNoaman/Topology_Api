package com.company;
import org.w3c.dom.Node;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ApplicationManager {
    private static API ApiExecuter = new API();
    public static void Execute() {
        while (true) {
            Scanner in = new Scanner(System.in);

            System.out.println("(1) Read a JSON file: ");
            System.out.println("(2) Write a JSON file: ");
            System.out.println("(3) Topologies in the memory: ");
            System.out.println("(4) Delete a Topology: ");
            System.out.println("(5) Devices in a specific Topology: ");
            System.out.println("(6) Devices connected to a specific Node: ");
            System.out.println("(7) exit ");
            int WantedFunctionality = 0;
            try {
                WantedFunctionality = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
            switch (WantedFunctionality) {
                case 1 -> {
                    System.out.printf("Please enter File Name: ");
                    String FileName = in.next();
                    readJSON(FileName);
                }
                case 2 -> {
                    System.out.printf("Please enter Topology ID: ");
                    String TopologyID = in.next();
                    System.out.println();
                    writeJSON(TopologyID);
                }
                case 3 -> {
                    System.out.println("Existing Topologies in the memory are :");
                    queryTopologies();
                }
                case 4 -> {
                    System.out.printf("Please enter Topology ID: ");
                    String TopologyID = in.next();
                    System.out.println();
                    deleteTopology(TopologyID);
                }
                case 5 -> {
                    System.out.printf("Please enter Topology ID: ");
                    String TopologyID = in.next();
                    System.out.println();
                    queryDevices(TopologyID);
                }
                case 6 -> {
                    System.out.printf("Please enter Topology ID: ");
                    String TopologyID = in.next();
                    System.out.printf("Please enter Node name: ");
                    String NodeName = in.next();
                    System.out.println();
                    queryDevicesWithNetlistNode(TopologyID,NodeName);
                }
                case 7 -> {
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }
        }

    }

    private static void readJSON(String FileName) {
        ApiExecuter.ReadTopology(FileName);
    }

    private static void writeJSON(String TopologyID) {

        ApiExecuter.WriteTopology(TopologyID);
    }

    private static void queryTopologies() {
        System.out.println(ApiExecuter.getTopologiesMemory());
        System.out.println();
    }

    private static void deleteTopology(String TopologyID) {

        boolean a=ApiExecuter.DeleteTopology(TopologyID);
        if(a==false)
            System.out.println("this ID doesn't exist in the memory");
    }

    private static void queryDevices(String TopologyID) {

        List<Component>List=ApiExecuter.queryDevices(TopologyID);
        if(List==null)
        {
            System.out.println("Sorry, this topology isn't in the memory");
            return;
        }
        for (Component i : List) {
            i.printComponent();
        }
        System.out.println();
    }

    private static void queryDevicesWithNetlistNode(String TopologyID,String NodeName) {
        List<Component> MyList=ApiExecuter.queryDevicesWithNetlistNode(TopologyID, NodeName);
        if(MyList==null)
        {
          return;
        }
        else {
            System.out.println("At Node " + NodeName + " These Components are connected :");
            for (Component i : MyList) {
                System.out.println(" Component with ID " + i.getComponentId() + " and type " + i.getComponentType());
            }

        }
        System.out.println();
    }
}

