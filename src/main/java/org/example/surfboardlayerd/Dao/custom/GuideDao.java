package org.example.surfboardlayerd.Dao.custom;

import org.example.surfboardlayerd.Dao.CrudDao;
import org.example.surfboardlayerd.entity.GuideEntity;

import java.sql.SQLException;

public interface GuideDao extends CrudDao<GuideEntity> {
    public GuideEntity getById(String id) throws SQLException, ClassNotFoundException;
}
