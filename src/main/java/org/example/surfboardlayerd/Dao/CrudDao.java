package org.example.surfboardlayerd.Dao;

import org.example.surfboardlayerd.entity.GuideEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDao<T> extends SuperDAO {
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
    public  boolean save(T dto) throws SQLException, ClassNotFoundException;
    public boolean update(T dto) throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public  String generateNewId() throws SQLException, ClassNotFoundException;
    public T search(String id) throws SQLException, ClassNotFoundException;
}
