package com.company;

public class Component {

    private String ComponentType;
    private int ComponentId;

    public String getComponentType() {
        return ComponentType;
    }

    public void setComponentType(String componentType) {
        ComponentType = componentType;
    }

    public int getComponentId() {
        return ComponentId;
    }

    public void setComponentId(int componentId) {
        ComponentId = componentId;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    private Device device;

}
