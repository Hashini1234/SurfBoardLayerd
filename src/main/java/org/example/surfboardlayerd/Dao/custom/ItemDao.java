package org.example.surfboardlayerd.Dao.custom;

import org.example.surfboardlayerd.entity.ItemEntity;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao {
    List<ItemEntity> getAll() throws SQLException, ClassNotFoundException;
    boolean save(ItemEntity entity) throws SQLException, ClassNotFoundException;
    boolean update(ItemEntity entity) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    String getNextId() throws SQLException, ClassNotFoundException;
}
