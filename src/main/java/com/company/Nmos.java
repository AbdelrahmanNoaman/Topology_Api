package com.company;

import java.util.HashMap;
/**
 * This class represents the Nmos as a Three Terminal device espesiaclly as a Mos Transistor
 * since it inherits from the MosTransistor class and sets default value, maximum value and
 * minimum value of the device
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */

public class Nmos extends MosTransistor{

    /**
     * Non Default Nmos Constructor
     * @param Name - Name of the device
     * @param netlist -Netlist that specifies terminals of the Nmos
     * @param dvalue - default value of the Nmos
     * @param minval - Minimum Value of the Nmos
     * @param maxval - Maximum Value of the Nmos
     */
    public Nmos(HashMap<String, String> netlist,double dvalue,double minval,double maxval,String Name) {
        super(netlist,dvalue,minval,maxval,Name);
    }
    /**
     * SetTransistorType function overriden from the MosTrasistor class
     * it sets the type of the transistor whether it's Nmos or Pmos
     */
    @Override
    public void setTrasistorType()
    {
        TransistorType="Nmos";
    }
}
