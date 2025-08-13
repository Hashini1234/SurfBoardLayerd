package org.example.surfboardlayerd.BO.custom;

import org.example.surfboardlayerd.BO.SuperBO;
import org.example.surfboardlayerd.model.SupplierDto;

import java.sql.SQLException;
import java.util.List;

public interface SupplierBO extends SuperBO {
    boolean saveSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException;
    boolean updateSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException;
    boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException;
    SupplierDto searchSupplier(String id) throws SQLException, ClassNotFoundException;
    List<SupplierDto> getAllSuppliers() throws SQLException, ClassNotFoundException;
    String getNextId() throws SQLException, ClassNotFoundException;
}
