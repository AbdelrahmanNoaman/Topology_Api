package com.company;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class Topology {
    private List<Component> component;
    private String TopologyID;
    private JSONObject JSONOBJ;
    private HashMap<String,List<Component>>Nodes=new HashMap<>();

    public Topology() {
    }
    public void PrintTopology()
    {
        System.out.println("**************************************************************************************");
        System.out.println("Topology id = "+TopologyID);
        for (Component i : component) {

            // Print all elements of ArrayList
            i.printComponent();
        }
        System.out.println("**************************************************************************************");
    }

    public Topology(String id,JSONArray Components,JSONObject OBJ)
    {
        setTopologyID(id);
        setComponent(Components);
        setJSONOBJ(OBJ);
    }

    public void setComponent(JSONArray Components) {
        component=new ArrayList<Component>();
        for(Object emp:Components)
        {
            Component StoredOne=getComponent((JSONObject)emp);
            component.add(StoredOne);
        }
    }
    public List<Component> GetComponentList()
    {
        return component;
    }

    public Component getComponent(JSONObject Components) {
        HashMap<String,String> TempHashMap=new HashMap<String, String>();
        JSONObject DeviceInfo=(JSONObject) Components.get("netlist");
        Set<String> keys = (Set<String>) DeviceInfo.keySet();

        for (String key : keys) {
            String value = (String) DeviceInfo.get((String) key);
            TempHashMap.put(key,value);
        }
        Device d1=new Device(TempHashMap);
        for (Map.Entry<String, String> set :
                TempHashMap.entrySet()) {

            if (!Nodes.containsKey(set.getValue())) {
                List<Component> list = new ArrayList<>();
                Nodes.put(set.getValue(), list);
            }

            Nodes.get(set.getValue()).add(new Component((String) Components.get("type"), (String) Components.get("id"),d1));
        }
        Component c1=new Component((String) Components.get("type"),(String) Components.get("id"),d1);
        System.out.println("**************************************************************************************");
        c1.printComponent();
        System.out.println("**************************************************************************************");
        return c1;
    }

    public JSONObject getJSONOBJ() {
        return JSONOBJ;
    }

    public void setJSONOBJ(JSONObject JSONOBJ) {
        this.JSONOBJ = JSONOBJ;
    }

    public HashMap<String, List<Component>> getNodes() {
        return Nodes;
    }

    public String getTopologyID() {
        return TopologyID;
    }

    public void setTopologyID(String topologyID) {
        TopologyID = topologyID;
    }

}
