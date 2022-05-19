package com.company;
import java.util.HashMap;
import java.util.Map;
/**
 * Class device is in Component but doesn't inherit from it.
 * It contains all the information of the component except it's
 * name and ID
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */
public class Device {

    private HashMap<String, String> Netlist;
    private String DeviceType;
    private String Name;
    private double defaultvalue;
    private double minvalue;
    private double maxvalue;
    /**
     * Non Default constructor to set the device parameters
     * @param netlist -Netlist of the device which describes the terminals of the device
     * @param defaultval - Default Value
     * @param maxval - Maximum Value
     * @param minval - Minimum Value
     */

    public Device(HashMap<String, String> netlist,double defaultval,double maxval,double minval,String Name) {

        setNetlist(netlist);
        setDefaultvalue(defaultval);
        setMaxvalue(maxval);
        setMinvalue(minval);
        setName(Name);
    }

    /**
     * Default Device Constructor
     */
    Device() {
        setNetlist(new HashMap<>());
        setDefaultvalue(0.0);
        setMaxvalue(0.0);
        setMinvalue(0.0);
    }

    /**
     * Get the kind for specific device
     * @return - String(Type)
     */

    public String getDeviceType() {
        return DeviceType;
    }
    /**
     * Set Device Type
     * @param deviceType - Kind of the calling device
     */
    public void setDeviceType(String deviceType) {
        DeviceType = deviceType;
    }
    /**
     * Print device function which is used to print the details of the netlist of the device
     */

    public void PrintDevice()
    {
        System.out.println(Name +" :");
        System.out.println("\t\t Default: "+defaultvalue);
        System.out.println("\t\t Min: "+minvalue);
        System.out.println("\t\t Max: "+maxvalue);
        for (Map.Entry<String, String> set :
                Netlist.entrySet())
        {
            System.out.println(" The Terminal with id = "+ set.getKey()+" is connected to "+set.getValue());
        }
        System.out.println("\n");
    }
    /**
     * Get name of calling device
     * @return - String(Name)
     */
    public String getName() {
        return Name;
    }
    /**
     * Set Device Name
     * @param name - Name of the device
     */
    public void setName(String name) {
        Name = name;
    }
    /**
     * Get Default Value of the device
     * @return double(Default) of calling device
     */

    public double getDefaultvalue() {
        return defaultvalue;
    }
    /**
     * Set Default Value to the calling device
     * @param defaultvalue - Default Value
     */

    public void setDefaultvalue(double defaultvalue) {
        this.defaultvalue = defaultvalue;
    }
    /**
     * Get the Minimum Value of the calling device
     * @return double(Min)
     */
    public double getMinvalue() {
        return minvalue;
    }
    /**
     * Set Minimum Value to the calling device
     * @param minvalue - Minimum Value
     */

    public void setMinvalue(double minvalue) {
        this.minvalue = minvalue;
    }
    /**
     * Get the Maximum Value of the calling device
     * @return double(Min)
     */

    public double getMaxvalue() {
        return maxvalue;
    }
    /**
     * Set Maximum Value to the calling device
     * @param maxvalue - Maximum Value
     */

    public void setMaxvalue(double maxvalue) {
        this.maxvalue = maxvalue;
    }

    /**
     * Function that gets all nodes in a given topology.
     * @return Node Map consisting of the terminals of every device and what it's connected to.
     */
    public HashMap<String, String> getNetlist() {
        return Netlist;
    }


    /**
     * Set Netlist of the device
     * @param netlist -HashMap of String , String
     */

    public void setNetlist(HashMap<String, String> netlist) {
        Netlist = netlist;
    }
}
