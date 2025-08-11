package org.example.surfboardlayerd.BO;


import org.example.surfboardlayerd.BO.custom.impl.BeachLocationBOImpl;
import org.example.surfboardlayerd.BO.custom.impl.GuideBOImpl;
import org.example.surfboardlayerd.BO.custom.impl.ItemBOImpl;
import org.example.surfboardlayerd.Dao.custom.Impl.ItemDaoImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        return ((boFactory) == null) ?new BOFactory():boFactory;
    }
    public enum BOTypes {
        GUIDE,BeachLocation,Item




    }
    public SuperBO getBO(BOTypes boType) {
        switch(boType){
            case GUIDE:
                return new GuideBOImpl();
                case BeachLocation:
                return new BeachLocationBOImpl();
            case Item:
                return new ItemBOImpl();
            default:
                return null;
        }


    }
}