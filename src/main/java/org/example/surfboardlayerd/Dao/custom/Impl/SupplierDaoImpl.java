package org.example.surfboardlayerd.Dao.custom.Impl;

import org.example.surfboardlayerd.Dao.SQLUtil;
import org.example.surfboardlayerd.Dao.custom.SupplierDao;
import org.example.surfboardlayerd.entity.GuideEntity;
import org.example.surfboardlayerd.entity.SupplierEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    @Override
    public ArrayList<SupplierEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT * FROM supplier");
        ArrayList<SupplierEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new SupplierEntity(rs.getString(1), rs.getString(2), rs.getString(3)));
        }
        return list;
    }

    @Override
    public boolean save(SupplierEntity supplier) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(
                "INSERT INTO supplier VALUES (?,?,?)",
                supplier.getSupplierId(),
                supplier.getName(),
                supplier.getContactInfo()
        );
    }

    @Override
    public boolean update(SupplierEntity supplier) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(
                "UPDATE supplier SET name=?, contact_info=? WHERE supplier_id=?",
                supplier.getName(),
                supplier.getContactInfo(),
                supplier.getSupplierId()
        );
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM supplier WHERE supplier_id=?", id);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT supplier_id FROM supplier ORDER BY supplier_id DESC LIMIT 1");
        if (rs.next()) {
            String lastId = rs.getString(1);
            int num = Integer.parseInt(lastId.replace("S", "")) + 1;
            return String.format("S%03d", num);
        }
        return "S001";
    }

    @Override
    public SupplierEntity search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT * FROM supplier WHERE supplier_id=?", id);
        if (rs.next()) {
            return new SupplierEntity(rs.getString(1), rs.getString(2), rs.getString(3));
        }
        return null;
    }
}