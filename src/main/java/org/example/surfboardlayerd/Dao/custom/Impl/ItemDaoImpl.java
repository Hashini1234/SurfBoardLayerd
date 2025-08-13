package org.example.surfboardlayerd.Dao.custom.Impl;

import org.example.surfboardlayerd.Dao.SQLUtil;
import org.example.surfboardlayerd.Dao.custom.ItemDao;
import org.example.surfboardlayerd.entity.ItemEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Override
    public ArrayList<ItemEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT * FROM item");
        ArrayList<ItemEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new ItemEntity(
                    rs.getString("item_id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("conditions"),
                    rs.getString("availability_status")
            ));
        }
        return list;
    }

    @Override
    public boolean save(ItemEntity entity) throws SQLException, ClassNotFoundException {
        System.out.println(entity);
        return SQLUtil.execute(
                "INSERT INTO item (item_id, name, type, conditions, availability_status) VALUES (?,?,?,?,?)",
                entity.getItemId(),
                entity.getName(),
                entity.getType(),
                entity.getConditions(),
                entity.getAvailabilityStatus()
        );
    }

    @Override
    public boolean update(ItemEntity entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(
                "UPDATE Item SET name=?, type=?, conditions=?, availability_status=? WHERE item_id=?",
                entity.getName(),
                entity.getType(),
                entity.getConditions(),
                entity.getAvailabilityStatus(),
                entity.getItemId()
        );
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Item WHERE item_id=?", id);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        try{
        ResultSet rs = SQLUtil.execute("select Item_id from Item order by Item_id DESC limit 1");
        char tableCharactor ='I';
        if(rs.next()){
            String lastId =rs.getString(1);
            String lastIdNumberString = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(lastIdNumberString);
            int nextIdNumber = lastIdNumber + 1;
            String nextIdString =String.format("I%03d", nextIdNumber);
            return nextIdString;
        }
        return tableCharactor+"001";

        }catch (Exception e){
            return "I001";
        }
    }

    @Override
    public ItemEntity search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}

