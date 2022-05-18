package com.company;
import java.util.HashMap;
/**
 * This class represents the resistor as a Two Terminal device since it inherits from the TwoTerminal class
 * and sets default value, maximum value and minimum value of the device
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */

public class Resistor extends TwoTerminal{
    /**
     * Non Default Resistor Constructor
     * @param Name - Unique Name
     * @param netlist -Netlist that specifies terminals of the resistor
     * @param dvalue - default value of the device
     * @param minval - Minimum Value of the device
     * @param maxval - Maximum Value of the device
     */

    public Resistor(HashMap<String, String> netlist,double dvalue,double minval,double maxval,String Name) {
        super(netlist,dvalue,minval,maxval,Name);
        setDeviceType("resistor");
    }
    /**
     * SetTransistorType function overriden from the MosTrasistor class
     * it sets the type of the transistor whether it's Nmos or Pmos
     */
    @Override
    public void setTwoTerminalType()
    {
        TwoTerminalType="resistor";
    }
}
