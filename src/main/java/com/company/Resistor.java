package com.company;
import java.util.HashMap;

public class Resistor extends Device{

    public Resistor(HashMap<String, String> netlist) {
        super(netlist);
        setDeviceType("resistor");
    }
   public void SetT1(String s1)
    {
        HashMap<String, String> Temp=getNetlist();
        Temp.replace("T1",s1);
        setNetlist(Temp);
    }
    public void SetT2(String s2)
    {
        HashMap<String, String> Temp=getNetlist();
        Temp.replace("T2",s2);
        setNetlist(Temp);
    }
    public String getT1()
    {
        HashMap<String, String> Temp=getNetlist();
        return Temp.get("T1");
    }
    public String getT2()
    {
        HashMap<String, String> Temp=getNetlist();
        return Temp.get("T2");
    }
}
