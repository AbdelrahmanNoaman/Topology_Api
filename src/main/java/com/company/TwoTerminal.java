package com.company;

import java.util.HashMap;
/**
 * This class represents every two terminal device, in the JSON file there is resistor only
 * but this class is made for future extension if any two terminal device is added
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */

public class TwoTerminal extends Device{
    String TwoTerminalType;
    /**
     * Non Default Pmos Constructor
     * @param Name - Name of the device
     * @param netlist -Netlist that specifies terminals of the Pmos
     * @param dvalue - default value of the Pmos
     * @param minval - Minimum Value of the Pmos
     * @param maxval - Maximum Value of the Pmos
     */
    public TwoTerminal(HashMap<String, String> netlist,double dvalue,double minval,double maxval,String Name) {
        super(netlist,dvalue,minval,maxval,Name);
        setDeviceType("Two_Terminal_Device");
    }
    /**
     * Default MosTransistor Constructor
     */
    public TwoTerminal() {
        super();
        setDeviceType("Two_Terminal_Device");
    }
    /**
     * Function that will be overriden in the child classes
     * in which each child will determine it's own type
     */
    public void setTwoTerminalType()
    {

    }
    /**
     * Setter for the terminal of T1
     * @param s1 - the new connected part of T1
     */

    public void SetT1(String s1)
    {
        getNetlist().put("T1",s1);
    }
    /**
     * Setter for the terminal of T2
     * @param s2 - the new connected part of T2
     */
    public void SetT2(String s2)
    {
        getNetlist().put("T2",s2);
    }
    /**
     * Get The connected node with t1
     * @return connected node with t1
     */
    public String getT1()
    {
        HashMap<String, String> Temp=getNetlist();
        return Temp.get("T1");
    }
    /**
     * Get The connected node with t2
     * @return connected node with t2
     */
    public String getT2()
    {
        HashMap<String, String> Temp=getNetlist();
        return Temp.get("T2");
    }
}
