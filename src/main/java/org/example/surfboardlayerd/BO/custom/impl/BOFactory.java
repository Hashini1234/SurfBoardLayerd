package org.example.surfboardlayerd.BO.custom.impl;

import org.example.surfboardlayerd.Dao.DAOFactory;
import org.example.surfboardlayerd.Dao.SuperDAO;
import org.example.surfboardlayerd.Dao.custom.Impl.GuideDaoImpl;

import static org.example.surfboardlayerd.Dao.DAOFactory.daoFactory;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        return (BOFactory) ==null)?new DAOFactory():daoFactory;
    }
    public enum DAOTypes {
        GUIDE

    }
    public SuperDAO getDAO(DAOFactory.DAOTypes daoType) {
        switch(daoType){
            case GUIDE:
                return new GuideDaoImpl();
            default:
                return null;
        }
    }
}
