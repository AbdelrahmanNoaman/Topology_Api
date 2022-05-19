package com.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.io.FileWriter;
import java.util.List;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * API
 * The API class contains all the functionalities that we will execute which they are
 * Reading a JSON file
 * Writing to JSON file
 * Query which topologies are in the memory
 * Delete a topology
 * query which devices are in a specific topology
 * query devices of a specific topology in a given node
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */
public class API {

    /**
     * This hashmap contains all the topologies are in the memory
     */
    private static HashMap<String, Topology> TopologiesMemory = new HashMap<>();
    /**
     * Default API constructor
     * - Sets the memory of the API
     */
    API() {
        setMemory(new HashMap<>());
    }

    /**
     * Gets the Memory
     * @return HashMap of string and topology
     */
    public HashMap<String, Topology> getMemory() {
        return TopologiesMemory;
    }
    /**
     * Gets the Ids of the Topologies in the memory
     * @return Set of strings"IDs"
     */

    public Set<String> getTogologiesIDs() {
        return TopologiesMemory.keySet();
    }


    /**
     * Sets the API's Memory
     * @param TopoMemory - Map for the memory to be set to
     */
    public void setMemory(HashMap<String, Topology> TopoMemory) {
        TopologiesMemory = TopoMemory;
    }

    /**
     * Gets all Topologies
     * @return Memory keyset
     */
    public static Set<String> getTopologiesMemory() {
        return TopologiesMemory.keySet();
    }

    /**
     * Reads a json file and stores it in TopologiesMemory
     * @param FileName - filename passed to the function to be opened
     * @return boolean whether the file is inserted into TopologiesMemory successfully or not
     */
    public static boolean ReadTopology(String FileName)
    {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(FileName)) {
            Object obj = jsonParser.parse(reader);
            JSONObject TopologyObj = (JSONObject) obj;
            parseTopology(TopologyObj);
            return true;
        }
        catch (IOException | ParseException e) {
            System.out.println("\nSorry, file isn't found\n");
            return false;
        }
    }
    /**
     * Adds a new topology to the TopologiesMemory
     * @param TopologyOne - JSON file that we use to get the topology's info
     */
    private static void parseTopology(JSONObject TopologyOne)
    {
        String id = (String) TopologyOne.get("id");
        JSONArray TopologyArr = (JSONArray) TopologyOne.get("components");
        Topology t1=new Topology(id,TopologyArr,TopologyOne);
        TopologiesMemory.put(id,t1);
    }
    /**
     * A Function that Writes a JSON file stored in the memory with the existing ones
     * @param TopologyID - Id of the topology that stored in the TopologiesMemory which we will write
     * @return boolean to check if it is successfully created
     */

    public static boolean WriteTopology(String TopologyID)
    {
        if(TopologiesMemory.containsKey(TopologyID)==false)
        {
            System.out.println("\nSorry, this topology isn't in the memory\n");
            return false;
        }
        try (FileWriter file = new FileWriter( "Topology2.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            if(TopologiesMemory.get(TopologyID)!=null) {
                file.write(TopologiesMemory.get(TopologyID).getJSONOBJ().toJSONString());
                file.flush();
                return true;
            }
        } catch (IOException e) {
            System.out.println("\nError in IO.\n");
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("\nThis ID isn't in memory.\n");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Deletes an existing topology from the TopologiesMemory
     * @param TopologyId - ID to be deleted
     * @return boolean to indicate success or failure
     */

    public boolean DeleteTopology(String TopologyId) {
        if (TopologiesMemory.containsKey(TopologyId)) {
            TopologiesMemory.remove(TopologyId);
            System.out.println("\nTopology with ID "+TopologyId+" has been deleted\n");
            return true;
        }
        return false;
    }
    /**
     * Query all devices exist in a given Topology
     * @param topologyID - ID to search for in TopologiesMemory
     * @return Component List containing all devices existing in a given topology
     */
    public List<Component> queryDevices(String topologyID) {

        if(TopologiesMemory.containsKey(topologyID)==false)
        {
            return null;
        }
        return TopologiesMemory.get(topologyID).GetComponentList();
    }
    /**
     * Query connected devices in a given netlist node in a specific topology
     * @param TopologyID - Topology ID
     * @param Node - Node required to get the connected devices
     * @return a list containing the components connected
     */

    public List<Component> queryDevicesWithNetlistNode(String TopologyID, String Node) {
        if(TopologiesMemory.containsKey(TopologyID)==false)
            return null;
        if(TopologiesMemory.get(TopologyID).getNodes()==null)
            return null;
        else
            return TopologiesMemory.get(TopologyID).getNodes().get(Node);
    }
}





