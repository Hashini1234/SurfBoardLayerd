package org.example.surfboardlayerd.BO.custom.impl;

import org.example.surfboardlayerd.BO.custom.SurfBoardBO;
import org.example.surfboardlayerd.Dao.DAOFactory;
import org.example.surfboardlayerd.Dao.custom.ItemDao;
import org.example.surfboardlayerd.Dao.custom.SurfBoardDao;
import org.example.surfboardlayerd.entity.SurfBoardEntity;
import org.example.surfboardlayerd.model.SurfBoardDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurfBoardBoImpl implements SurfBoardBO {
    private final SurfBoardDao surfBoardDao= (SurfBoardDao) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SURFBOARD);

    @Override
    public List<SurfBoardDto> getAllSurfBoards() throws SQLException, ClassNotFoundException {
        List<SurfBoardEntity> entities = surfBoardDao.getAll();
        List<SurfBoardDto> dtos = new ArrayList<>();
        for (SurfBoardEntity e : entities) {
            dtos.add(new SurfBoardDto(e.getSurfboardId(), e.getBrand(), e.getConditions()));
        }
        return dtos;
    }

    @Override
    public boolean saveSurfBoard(SurfBoardEntity dto) throws SQLException, ClassNotFoundException {
        return surfBoardDao.save(new SurfBoardEntity(dto.getSurfboardId(), dto.getBrand(), dto.getConditions(), dto.getStatus()));
    }

    @Override
    public boolean updateSurfBoard(SurfBoardEntity dto) throws SQLException, ClassNotFoundException {
        return surfBoardDao.update(new SurfBoardEntity(dto.getSurfboardId(), dto.getBrand(), dto.getConditions(), dto.getStatus()));
    }

    @Override
    public boolean deleteSurfBoard(String id) throws SQLException, ClassNotFoundException {
        return surfBoardDao.delete(id);
    }

    @Override
    public String getNextSurfBoardId() throws SQLException, ClassNotFoundException {
        return surfBoardDao.getNextId();
    }

    @Override
    public List<String> getAllSurfBoardIds() throws SQLException, ClassNotFoundException {
        return surfBoardDao.getAllIds();
    }
}
