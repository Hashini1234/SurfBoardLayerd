package org.example.surfboardlayerd.BO.custom.impl;


import org.example.surfboardlayerd.BO.SuperBO;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        return ((boFactory) == null) ?new BOFactory():boFactory;
    }
    public enum BOTypes {
        GUIDE
        ,BeachLocation


    }
    public SuperBO getBO(BOTypes boType) {
        switch(boType){
            case GUIDE:
                return new GuideBOImpl();
                case BeachLocation:
                return new BeachLocationBoiMPL();
            default:
                return null;
        }


    }
}