package com.company;

import java.util.HashMap;

public class Nmos extends MosTransistor{

    public Nmos(HashMap<String,String> netlist) {
        super(netlist);
    }

    @Override
    public void setTrasistorType()
    {
        TransistorType="Nmos";
    }
}
