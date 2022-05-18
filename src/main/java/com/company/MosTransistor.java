package com.company;
import java.util.HashMap;
/**
 * This class represents every three terminal device,which the Nmos and Pmos devices inherit from
 * it specializes the device which will be a MosTransistor
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */

public class MosTransistor extends Device{
    String TransistorType;
    /**
     * Non Default Pmos Constructor
     * @param Name - Name of the device
     * @param netlist -Netlist that specifies terminals of the Pmos
     * @param dvalue - default value of the Pmos
     * @param minval - Minimum Value of the Pmos
     * @param maxval - Maximum Value of the Pmos
     */
    public MosTransistor(HashMap<String, String> netlist,double dvalue,double minval,double maxval,String Name) {
        super(netlist,dvalue,minval,maxval,Name);
        setDeviceType("MosTransistor");
    }
    /**
     * Default MosTransistor Constructor
     */
    public MosTransistor() {
        super();
        setDeviceType("MosTransistor");
    }
    /**
     * Function that will be overriden in the child classes
     * in which each child will determine it's own type
     */
    public void setTrasistorType()
    {

    }
    /**
     * Setter for the terminal of source
     * @param source - the new connected part of source
     */
    public void SetSource(String source)
    {
        HashMap<String, String> Temp=getNetlist();
        Temp.replace("source",source);
        setNetlist(Temp);
    }
    /**
     * Setter for the terminal of gate
     * @param gate - the new connected part of gate
     */
    public void SetGate(String gate)
    {
        HashMap<String, String> Temp=getNetlist();
        Temp.replace("gate",gate);
        setNetlist(Temp);
    }
    /**
     * Setter for the terminal of drain
     * @param drain - the new connected part of drain
     */
    public void SetDrain(String drain)
    {
        HashMap<String, String> Temp=getNetlist();
        Temp.replace("drain",drain);
        setNetlist(Temp);
    }
    /**
     * Get The connected node with source
     * @return connected node with source
     */
    public String getSource()
    {
        HashMap<String, String> Temp=getNetlist();
        return Temp.get("source");
    }
    /**
     * Get The connected node with drain
     * @return connected node with drain
     */
    public String getDrain()
    {
        HashMap<String, String> Temp=getNetlist();
        return Temp.get("drain");
    }
    /**
     * Get The connected node with gate
     * @return connected node with gate
     */
    public String getGate()
    {
        HashMap<String, String> Temp=getNetlist();
        return Temp.get("gate");
    }
}
