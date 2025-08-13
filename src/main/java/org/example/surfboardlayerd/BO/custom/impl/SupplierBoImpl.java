package org.example.surfboardlayerd.BO.custom.impl;

import org.example.surfboardlayerd.BO.custom.SupplierBO;
import org.example.surfboardlayerd.Dao.DAOFactory;
import org.example.surfboardlayerd.Dao.custom.SupplierDao;
import org.example.surfboardlayerd.entity.SupplierEntity;
import org.example.surfboardlayerd.model.SupplierDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBoImpl implements SupplierBO {
    private final SupplierDao SupplierDao= (SupplierDao) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean saveSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException {
        return SupplierDao.save(new SupplierEntity(dto.getSupplierId(), dto.getName(), dto.getContactInfo()));
    }

    @Override
    public boolean updateSupplier(SupplierDto dto) throws SQLException, ClassNotFoundException {
       return SupplierDao.update(new SupplierEntity(dto.getSupplierId(), dto.getName(), dto.getContactInfo()));

    }

    @Override
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        return SupplierDao.delete(id);
    }

    @Override
    public SupplierDto searchSupplier(String id) throws SQLException, ClassNotFoundException {
        SupplierEntity entity = SupplierDao.search(id);
        if (entity != null) {
            return new SupplierDto(entity.getSupplierId(), entity.getName(), entity.getContactInfo());
        }
        return null;
    }

    @Override
    public List<SupplierDto> getAllSuppliers() throws SQLException, ClassNotFoundException {
        List<SupplierEntity> entities = SupplierDao.getAll();
        List<SupplierDto> list = new ArrayList<>();
        for (SupplierEntity e : entities) {
            list.add(new SupplierDto(e.getSupplierId(), e.getName(), e.getContactInfo()));
        }
        return list;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return SupplierDao.generateNewId();
    }
}
