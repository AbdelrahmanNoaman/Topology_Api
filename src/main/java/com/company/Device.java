package com.company;
import java.util.HashMap;
import java.util.Map;

public class Device {

    private HashMap<String, String> Netlist;
    private String DeviceType;
    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String deviceType) {
        DeviceType = deviceType;
    }
    public void PrintDevice()
    {
        for (Map.Entry<String, String> set :
                Netlist.entrySet())
        {
            System.out.println(" The Terminal with id = "+ set.getKey()+" is connected to "+set.getValue());
        }
    }

    public Device(HashMap<String, String> netlist) {
        setNetlist(netlist);
    }

    public HashMap<String, String> getNetlist() {
        return Netlist;
    }
    public void setNetlist(HashMap<String, String> netlist) {
        Netlist = netlist;
    }
}
