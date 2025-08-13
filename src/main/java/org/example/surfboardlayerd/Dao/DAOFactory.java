package org.example.surfboardlayerd.Dao;

import org.example.surfboardlayerd.Dao.custom.Impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {}
    public static DAOFactory getInstance() {

        return (daoFactory==null)?new DAOFactory():daoFactory;
    }

    public enum DAOTypes {
       GUIDE,BEACHLOCATION,ITEM,USER,SUPPLIER,SURFBOARD

    }
    public static CrudDao getDAO(DAOTypes daoType) {
        switch(daoType){
            case GUIDE:
                return new GuideDaoImpl();
            case BEACHLOCATION:
                return new BeachLocationDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
                case USER:
                    return new UserDAOImpl();
            case SUPPLIER:
                return new SupplierDaoImpl();
                           case SURFBOARD:
                               return new SurfBoardDaoImpl();
            default:
                return null;
        }
    }
}
