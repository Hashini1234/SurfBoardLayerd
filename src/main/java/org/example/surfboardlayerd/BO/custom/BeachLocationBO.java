package org.example.surfboardlayerd.BO.custom;

import org.example.surfboardlayerd.BO.SuperBO;
import org.example.surfboardlayerd.model.BeachLocationDto;

import java.sql.SQLException;
import java.util.List;

public interface BeachLocationBO extends SuperBO {
    List<BeachLocationDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(BeachLocationDto dto) throws SQLException, ClassNotFoundException;
    boolean update(BeachLocationDto dto) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    String getNextId() throws SQLException, ClassNotFoundException;

}
