package com.company;


public class Component {
    private String ComponentType;
    private String ComponentId;
    private Device componentDevice;


    public Component(String componentType, String componentId,Device ComponentDevice) {
        setComponentType(componentType);
        setComponentId(componentId);
        componentDevice=ComponentDevice;
    }
    public Component() {

    }
    public void printComponent(){
        System.out.println("Component id ="+ComponentId);
        System.out.println("Component type ="+ComponentType);
        componentDevice.PrintDevice();
    }

    public String getComponentType() {
        return ComponentType;
    }
    public void setComponentType(String componentType) {
        ComponentType = componentType;
    }
    public String getComponentId() {
        return ComponentId;
    }
    public void setComponentId(String componentId) {
        ComponentId = componentId;
    }
}
