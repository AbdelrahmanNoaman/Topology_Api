package com.company;
import java.util.HashMap;

public class MosTransistor extends Device{
    String TransistorType;
    public MosTransistor(HashMap<String,String> netlist) {
        super(netlist);
        setDeviceType("MosTransistor");
    }
    public void setTrasistorType()
    {

    }
    public void SetSource(String source)
    {
        HashMap<String, String> Temp=getNetlist();
        Temp.replace("source",source);
        setNetlist(Temp);
    }
    public void SetGate(String gate)
    {
        HashMap<String, String> Temp=getNetlist();
        Temp.replace("gate",gate);
        setNetlist(Temp);
    }
    public void SetDrain(String drain)
    {
        HashMap<String, String> Temp=getNetlist();
        Temp.replace("drain",drain);
        setNetlist(Temp);
    }
    public String getSource()
    {
        HashMap<String, String> Temp=getNetlist();
        return Temp.get("source");
    }
    public String getDrain()
    {
        HashMap<String, String> Temp=getNetlist();
        return Temp.get("drain");
    }
    public String getGate()
    {
        HashMap<String, String> Temp=getNetlist();
        return Temp.get("gate");
    }
}
