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

public class API {

    private static HashMap<String, Topology> TopologiesMemory = new HashMap<>();

    public static void ReadTopology(String FileName)
    {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(FileName)) {
            Object obj = jsonParser.parse(reader);
            JSONObject employeeList = (JSONObject) obj;
            parseTopology(employeeList);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } catch(ParseException e){
            e.printStackTrace();
        }
    }
    private static void parseTopology(JSONObject employee)
    {
        String id = (String) employee.get("id");
        JSONArray employeeObject = (JSONArray) employee.get("components");
        Topology t1=new Topology(id,employeeObject,employee);
        TopologiesMemory.put(id,t1);
    }

    public static void WriteTopology(String TopologyID)
    {
        try (FileWriter file = new FileWriter(TopologyID + ".json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(TopologiesMemory.get(TopologyID).getJSONOBJ().toJSONString());
            file.flush();
        } catch (IOException e) {
            System.out.println("Error in IO.");
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("This ID isn't in memory.");
            e.printStackTrace();
        }
    }


    public static Set<String> getTopologiesMemory() {
        return TopologiesMemory.keySet();
    }

    public boolean DeleteTopology(String TopologyId) {
        if (TopologiesMemory.containsKey(TopologyId)) {
            TopologiesMemory.remove(TopologyId);
            return true;
        }
        return false;
    }
    public List<Component> queryDevices(String topologyID) {
        return TopologiesMemory.get(topologyID).GetComponentList();
    }

    public List<Component> queryDevicesWithNetlistNode(String TopologyID, String Node) {
        if(TopologiesMemory.get(TopologyID).getNodes()==null)
        {
            return null;
        }
        else
        {
            return TopologiesMemory.get(TopologyID).getNodes().get(Node);
        }
    }


}




