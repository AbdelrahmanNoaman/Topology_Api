package com.company;
import org.w3c.dom.Node;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 *the application manager class of the program is the one who controls everything.
 * It contains the infinite loop which keeps running until the user exits.
 * Otherwise he will choose between the given functionalities to perform any of them.
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */


public class ApplicationManager {
    /**
     * Object from the API class to call the functions of API which has all functionalities.
     */
    private static API ApiExecuter = new API();
    /**
     * Execute function that is called in Main class
     */
    public static void Execute() {
        Scanner in = new Scanner(System.in);
        while (true) {
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
                   boolean indicator = readJSON(FileName);
                    if (indicator)
                        System.out.println(FileName+" has been read successfully");
                    else
                        System.out.println("Error in Reading "+FileName);
                }
                case 2 -> {
                    System.out.printf("Please enter Topology ID: ");
                    String TopologyID = in.next();
                    System.out.println();
                    boolean indicator = writeJSON(TopologyID);
                    if (indicator)
                        System.out.println("Topology2 has been Written successfully");
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
    /**
     * Function that Reads JSON file
     * @param FileName - Name of the file
     */
    private static boolean readJSON(String FileName) {
        return ApiExecuter.ReadTopology(FileName);
    }
    /**
     * A Function that Writes a JSON file stored in the memory with the existing ones
     * @param TopologyID - Id of the topology that defines the file that we will write
     */
    private static boolean writeJSON(String TopologyID) {

        return ApiExecuter.WriteTopology(TopologyID);
    }
    /**
     * Query all Topologies existing in memory
     */
    private static void queryTopologies() {
        System.out.println(ApiExecuter.getTopologiesMemory());
        System.out.println();
    }
    /**
     * Deletes an existing topology
     * @param TopologyID - ID to be deleted
     */
    private static void deleteTopology(String TopologyID) {

        boolean a=ApiExecuter.DeleteTopology(TopologyID);
        if(a==false)
            System.out.println("this ID doesn't exist in the memory");
    }
    /**
     * Query all devices exist in a given Topology
     * @param TopologyID - ID to search for in Memory
     */
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
    /**
     * Query connected devices in a given netlist node in a specific topology
     * @param TopologyID - Topology ID
     * @param NodeName - Node required to get the connected devices
     * @return a list containing the components connected
     */
    private static void queryDevicesWithNetlistNode(String TopologyID,String NodeName) {
        List<Component> MyList=ApiExecuter.queryDevicesWithNetlistNode(TopologyID, NodeName);
        if(MyList==null)
        {
            System.out.println("Wrong topology id or at this node there are no connections");
            System.out.println("");
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

