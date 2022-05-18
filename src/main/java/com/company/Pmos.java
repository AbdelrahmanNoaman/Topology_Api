package com.company;

import java.util.HashMap;
/**
 * This class represents the Pmos as a Three Terminal device espesiaclly as a Mos Transistor
 * since it inherits from the MosTransistor class and sets default value, maximum value and
 * minimum value of the device
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */

public class Pmos extends MosTransistor{
    /**
     * Non Default Pmos Constructor
     * @param Name - Name of the device
     * @param netlist -Netlist that specifies terminals of the Pmos
     * @param dvalue - default value of the Pmos
     * @param minval - Minimum Value of the Pmos
     * @param maxval - Maximum Value of the Pmos
     */

    public Pmos(HashMap<String, String> netlist,double dvalue,double minval,double maxval,String Name) {
        super(netlist,dvalue,minval,maxval,Name);
        setTrasistorType();
    }
    /**
     * Default Pmos Constructor
     */

    public Pmos()
    {
        super();
    }
    /**
     * SetTransistorType function overriden from the MosTrasistor class
     * it sets the type of the transistor whether it's Nmos or Pmos
     */

    @Override
    public void setTrasistorType()
    {
        TransistorType="Pmos";
    }
}
