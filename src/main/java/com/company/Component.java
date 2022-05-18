package com.company;
/**
 * Class component describes each component with all its parameters that it needs
 * and is what the topology consists of
 * @author Abdelrahman Noaman
 * @version 1.0.0 May 17, 2022
 */

public class Component {
    private String ComponentType;
    private String ComponentId;
    private Device componentDevice;

    /**
     * Non Default Component Constructor to set the data member of the component
     * @param componentType - Component type
     * @param componentId - Unique Component ID in each topology
     * @param ComponentDevice - device object to set it's default, min and max
     */
    public Component(String componentType, String componentId,Device ComponentDevice) {
        setComponentType(componentType);
        setComponentId(componentId);
        setComponentDevice((ComponentDevice));
    }
    /**
     * Default Component Constructor
     */
    public Component() {
        setComponentType("");
        setComponentId("");
    }
    /**
     * Print component function which is used to print the details of the netlist of the device
     */
    public void printComponent(){
        System.out.println("Component id ="+ComponentId);
        System.out.println("Component type ="+ComponentType);
        componentDevice.PrintDevice();
    }
    /**
     * Get the component type
     * @return type
     */
    public String getComponentType() {
        return ComponentType;
    }
    /**
     * Set component type
     * @param componentType - The type of the component
     */
    public void setComponentType(String componentType) {
        ComponentType = componentType;
    }
    /**
     * Get the component ID
     * @return ComponentID
     */
    public String getComponentId() {
        return ComponentId;
    }
    /**
     * Set component ID
     * @param componentId - The ID of the component
     */
    public void setComponentId(String componentId) {
        ComponentId = componentId;
    }
    /**
     * Get the Device "ComponentDevice"
     * @return Device of the component
     */
    public Device getComponentDevice() {
        return componentDevice;
    }
    /**
     * Set Device
     * @param componentDevice - the device of the component
     */

    public void setComponentDevice(Device componentDevice) {
        this.componentDevice = componentDevice;
    }
}
