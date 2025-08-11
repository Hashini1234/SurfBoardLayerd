package org.example.surfboardlayerd.Dao;

import org.example.surfboardlayerd.entity.BeachLocationEntity;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> extends SuperDAO {
    public List<BeachLocationEntity> getAll() throws SQLException, ClassNotFoundException;
    public  boolean save(T customerDTO) throws SQLException, ClassNotFoundException;
    public boolean update(T customerDTO) throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public  String generateNewId() throws SQLException, ClassNotFoundException;
    public T search(String id) throws SQLException, ClassNotFoundException;
}
