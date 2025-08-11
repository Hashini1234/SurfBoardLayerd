package org.example.surfboardlayerd.BO.custom;

import org.example.surfboardlayerd.BO.SuperBO;
import org.example.surfboardlayerd.model.ItemDto;

import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {
    List<ItemDto> getAll() throws SQLException, ClassNotFoundException;
    boolean save(ItemDto dto) throws SQLException, ClassNotFoundException;
    boolean update(ItemDto dto) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    String getNextId() throws SQLException, ClassNotFoundException;
}
