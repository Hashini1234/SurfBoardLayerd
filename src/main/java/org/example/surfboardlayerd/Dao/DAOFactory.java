package org.example.surfboardlayerd.Dao;

import org.example.surfboardlayerd.Dao.custom.Impl.GuideDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {}
    public static DAOFactory getInstance() {
        return (daoFactory==null)?new DAOFactory():daoFactory;
    }
    public enum DAOTypes {
       GUIDE

    }
    public SuperDAO getDAO(DAOTypes daoType) {
        switch(daoType){
            case GUIDE:
                return new GuideDaoImpl();
                       default:
                return null;
        }
    }
}
