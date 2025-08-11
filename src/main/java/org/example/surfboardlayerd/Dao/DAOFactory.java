package org.example.surfboardlayerd.Dao;

import org.example.surfboardlayerd.Dao.custom.Impl.BeachLocationDaoImpl;
import org.example.surfboardlayerd.Dao.custom.Impl.GuideDaoImpl;
import org.example.surfboardlayerd.Dao.custom.Impl.ItemDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {}
    public static DAOFactory getInstance() {
        return (daoFactory==null)?new DAOFactory():daoFactory;
    }
    public enum DAOTypes {
       GUIDE,BEACHLOCATION,ITEM

    }
    public GuideDaoImpl getDAO(DAOTypes daoType) {
        switch(daoType){
            case GUIDE:
                return new GuideDaoImpl();
            case BEACHLOCATION:
                return new BeachLocationDaoImpl();
            case GUIDE:
                return new ItemDaoImpl();
                       default:
                return null;
        }
    }
}
