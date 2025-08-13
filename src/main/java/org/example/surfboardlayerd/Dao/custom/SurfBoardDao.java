package org.example.surfboardlayerd.Dao.custom;

import org.example.surfboardlayerd.Dao.CrudDao;
import org.example.surfboardlayerd.entity.SurfBoardEntity;

import java.sql.SQLException;
import java.util.List;

public interface SurfBoardDao extends CrudDao <SurfBoardEntity>{
    public List<String> getAllIds() throws SQLException, ClassNotFoundException;

    String getNextId();
}
