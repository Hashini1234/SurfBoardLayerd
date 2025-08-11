package org.example.surfboardlayerd.Dao.custom.Impl;

import org.example.surfboardlayerd.Dao.SQLUtil;
import org.example.surfboardlayerd.Dao.custom.ItemDao;
import org.example.surfboardlayerd.entity.ItemEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.surfboardlayerd.Dao.SQLUtil.executeQuery;

public class ItemDaoImpl implements ItemDao {

    @Override
    public List<ItemEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT * FROM Item");
        List<ItemEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new ItemEntity(
                    rs.getString("item_id"),
                    rs.getString("name"),
                    rs.getInt("qty_on_hand"),
                    rs.getDouble("unit_price")
            ));
        }
        return list;
    }

    @Override
    public boolean save(ItemEntity entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(
                "INSERT INTO Item VALUES (?,?,?,?)",
                entity.getItemId(),
                entity.getName(),
                entity.getQtyOnHand(),
                entity.getUnitPrice()
        );
    }

    @Override
    public boolean update(ItemEntity entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate(
                "UPDATE Item SET name=?, qty_on_hand=?, unit_price=? WHERE item_id=?",
                entity.getName(),
                entity.getQtyOnHand(),
                entity.getUnitPrice(),
                entity.getItemId()
        );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Item WHERE item_id=?", id);
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.executeQuery("SELECT item_id FROM Item ORDER BY item_id DESC LIMIT 1");
        char prefix = 'I';
        if (rs.next()) {
            String lastId = rs.getString(1);
            int num = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format(prefix + "%03d", num);
        }
        return prefix + "001";
    }
    }

