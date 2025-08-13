package org.example.surfboardlayerd.BO.custom.impl;

import org.example.surfboardlayerd.BO.custom.ItemBO;
import org.example.surfboardlayerd.Dao.DAOFactory;
import org.example.surfboardlayerd.Dao.custom.ItemDao;
import org.example.surfboardlayerd.entity.ItemEntity;
import org.example.surfboardlayerd.model.ItemDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    private final ItemDao itemDao= (ItemDao)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<ItemDto> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemEntity> entities = itemDao.getAll();
        ArrayList<ItemDto> dtos = new ArrayList<>();
        for (ItemEntity e : entities) {
            dtos.add(new ItemDto(e.getItemId(), e.getName(), e.getType(), e.getConditions(),e.getAvailabilityStatus()));
        }
        return dtos;
    }

    @Override
    public boolean save(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.save(new ItemEntity(dto.getItemId(), dto.getName(), dto.getType(), dto.getConditions(), dto.getAvailabilityStatus()));
    }

    @Override
    public boolean update(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new ItemEntity(dto.getItemId(), dto.getName(), dto.getType(), dto.getConditions(), dto.getAvailabilityStatus()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return itemDao.delete(id);
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return itemDao.generateNewId();
    }
}
