package org.example.surfboardlayerd.BO.custom.impl;

import org.example.surfboardlayerd.BO.custom.BeachLocationBO;
import org.example.surfboardlayerd.Dao.DAOFactory;
import org.example.surfboardlayerd.Dao.custom.BeachLocationDao;
import org.example.surfboardlayerd.entity.BeachLocationEntity;
import org.example.surfboardlayerd.model.BeachLocationDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeachLocationBOImpl implements BeachLocationBO {
private final BeachLocationDao beachLocationDao = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BEACHLOCATION);
    @Override
    public List<BeachLocationDto> getAll() throws SQLException, ClassNotFoundException {
        List<BeachLocationEntity> entities = dao.getAll();
        List<BeachLocationDto> dtos = new ArrayList<>();
        for (BeachLocationEntity e : entities) {
            dtos.add(new BeachLocationDto(e.getBeachId(), e.getName(), e.getPeakSeason(), e.getMonth()));
        }
        return dtos;
    }

    @Override
    public boolean save(BeachLocationDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(BeachLocationDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return "";
    }
}
