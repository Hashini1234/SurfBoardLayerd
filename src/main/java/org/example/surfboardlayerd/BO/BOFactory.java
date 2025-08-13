package org.example.surfboardlayerd.BO;


import org.example.surfboardlayerd.BO.custom.impl.*;
import org.example.surfboardlayerd.Dao.custom.Impl.ItemDaoImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        return ((boFactory) == null) ?new BOFactory():boFactory;
    }
    public enum BOTypes {
        GUIDE,BeachLocation,Item,USER,SUPPLIER,SURFBOARD




    }
    public SuperBO getBO(BOTypes boType) {
        switch(boType){
            case GUIDE:
                return new GuideBOImpl();
                case BeachLocation:
                return new BeachLocationBOImpl();
            case Item:
                return new ItemBOImpl();
                case USER:
                    return new UserBOImpl();
                    case SUPPLIER:
                        return new SupplierBoImpl();
                        case SURFBOARD:
                            return new SurfBoardBoImpl();
            default:
                return null;
        }


    }
}