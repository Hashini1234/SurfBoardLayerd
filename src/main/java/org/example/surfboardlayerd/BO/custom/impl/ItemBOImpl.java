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
    private final ItemDao itemDao= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public List<ItemDto> getAll() throws SQLException, ClassNotFoundException {
        List<ItemEntity> entities = ItemDao.getAll();
        List<ItemDto> dtos = new ArrayList<>();
        for (ItemEntity e : entities) {
            dtos.add(new ItemDto(e.getItemId(), e.getName(), e.getQtyOnHand(), e.getUnitPrice()));
        }
        return dtos;
    }

    @Override
    public boolean save(ItemDto dto) throws SQLException, ClassNotFoundException {
        return ItemDao.save(new ItemEntity(dto.getItemId(), dto.getName(), dto.getQtyOnHand(), dto.getUnitPrice()));
    }

    @Override
    public boolean update(ItemDto dto) throws SQLException, ClassNotFoundException {
        return ItemDao.update(new ItemEntity(dto.getItemId(), dto.getName(), dto.getQtyOnHand(), dto.getUnitPrice()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return ItemDao.delete(id);
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return ItemDao.getNextId();
    }
}
