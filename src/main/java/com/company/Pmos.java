package com.company;

import java.util.HashMap;

public class Pmos extends MosTransistor{

    public Pmos(HashMap<String,String> netlist) {
        super(netlist);
    }
    @Override
    public void setTrasistorType()
    {
        TransistorType="Pmos";
    }
}
