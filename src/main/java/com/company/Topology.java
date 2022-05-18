package com.company;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.naming.Name;
import java.util.*;
/**
 * The Main class of the whole API is the topology as it has relation with all other
 * classes and instantiates lists and objects from these classes
 * It contains all the information from the json file through its id and
 * list of components which include devices with their specification and data
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */

public class Topology {
    /**
     * 1-List of components the topology contains
     * 2-TopologyId to differentiate between Topologies and each other
     * 3-JSONOBJ that we use to fill the data of each component
     * 4-HashMap of nodes that we will use to get the connected nodes
     * where for each node it will have the connected components at it
     */

    private List<Component> component;
    private String TopologyID;
    private JSONObject JSONOBJ;
    private HashMap<String,List<Component>>Nodes=new HashMap<>();
    /**
     * Default Topology Constructor
     */
    public Topology() {

    }
    /**
     * Non Default Topology Constructor
     * @param id - Topology ID
     * @param Components - Array of JSONObject that we will fill with OBJ JSONObject
     * @param OBJ - Main JSON object which is parsed later to fill component data
     */

    public Topology(String id,JSONArray Components,JSONObject OBJ)
    {
        setTopologyID(id);
        setComponent(Components);
        setJSONOBJ(OBJ);
    }
    /**
     * Print device function which is used to print the details of the netlist of the device
     */
    public void PrintTopology()
    {
        System.out.println("Topology id = "+TopologyID);
        for (Component i : component) {

            // Print all elements of ArrayList
            i.printComponent();
        }
    }
    /**
     * This function takes the components Array and loops through it to extract
     * each component from this Array and set its data
     * @param Components - Array of components
     */

    public void setComponent(JSONArray Components) {
        component=new ArrayList<Component>();
        for(Object emp:Components)
        {
            Component StoredOne=getComponent((JSONObject)emp);
            component.add(StoredOne);
        }
    }
    /**
     * Get Component list of the topology
     * @return Components that exist in the topology
     */
    public List<Component> GetComponentList()
    {
        return component;
    }
    /**
     * This function that I Used to fill the data of each component
     * by parsing it from the JSONObject with the data
     * in netlist we search for each node if it exists before then this component
     * will be added to the list of components connected in this node
     * @return Component that will e added to component list
     */

    public Component getComponent(JSONObject Component) {
        HashMap<String,String> TempHashMap=new HashMap<String, String>();
        JSONObject DeviceInfo=(JSONObject) Component.get("netlist");
        String Type;

        Type = (String) Component.get("type");
        String Name = "";
        switch (Type) {
            case "resistor" -> Name = "resistance";
            case "nmos" -> Name = "m(1)";
            case "pmos" -> Name = "m(2)";
        }
        Device d1=new Device();
        JSONObject deviceObj = (JSONObject) Component.get(Name);
        // These lines are commented because it's not specified if the values are double or long
        //so if it's specified then they must be uncommented
        //double defaultvalue=(double) deviceObj.get("default");
        // double maxvalue=(double) deviceObj.get("max");
        // double minvalue=(double) deviceObj.get("min");
        //then instead of these numbers in the next switch case each one will be substituted with its variable


        switch (Type) {
            case "pmos" -> d1 = new MosTransistor(TempHashMap, 1.5, 1, 2,Name);
            case "resistor" -> d1 = new Resistor(TempHashMap, 100, 10, 1000,Name);
            case "nmos" -> d1 = new MosTransistor(TempHashMap, 1.5, 1, 2,Name);

        }

        Set<String> keys = (Set<String>) DeviceInfo.keySet();

        for (String key : keys) {
            String value = (String) DeviceInfo.get((String) key);
            TempHashMap.put(key,value);
        }

        for (Map.Entry<String, String> set :
                TempHashMap.entrySet()) {

            if (!Nodes.containsKey(set.getValue())) {
                List<Component> list = new ArrayList<>();
                Nodes.put(set.getValue(), list);
            }

            Nodes.get(set.getValue()).add(new Component((String) Component.get("type"), (String) Component.get("id"),d1));
        }
        Component c1=new Component(Type,(String) Component.get("id"),d1);
        return c1;
    }
    /**
     * Get JSON
     * @return JSONObject
     */

    public JSONObject getJSONOBJ() {
        return JSONOBJ;
    }
    /**
     * Set JSON
     * @param JSONOBJ - JSONObject
     */

    public void setJSONOBJ(JSONObject JSONOBJ) {
        this.JSONOBJ = JSONOBJ;
    }

    /**
     * Get nodes from the NodeMap
     * @return Nodes in the topology
     */

    public HashMap<String, List<Component>> getNodes() {
        return Nodes;
    }
    /**
     * Get TopologiesID
     * @return TopologiesID of the topology
     */

    public String getTopologyID() {
        return TopologyID;
    }

    /**
     * Set topologyID
     * @param topologyID - String
     */
    public void setTopologyID(String topologyID) {
        TopologyID = topologyID;
    }

}
