package org.example.surfboardlayerd.Dao.custom;

import org.example.surfboardlayerd.Dao.CrudDao;
import org.example.surfboardlayerd.entity.BeachLocationEntity;

import java.sql.SQLException;
import java.util.List;

public interface BeachLocationDao extends CrudDao<BeachLocationEntity> {
    List<BeachLocationEntity> getAll() throws SQLException, ClassNotFoundException;
    boolean save(BeachLocationEntity entity) throws SQLException, ClassNotFoundException;
    boolean update(BeachLocationEntity entity) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    String getNextId() throws SQLException, ClassNotFoundException;
}
