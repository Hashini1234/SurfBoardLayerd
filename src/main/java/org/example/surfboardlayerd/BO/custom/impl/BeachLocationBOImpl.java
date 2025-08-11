package org.example.surfboardlayerd.BO.custom.impl;

import org.example.surfboardlayerd.BO.custom.BeachLocationBO;
import org.example.surfboardlayerd.BO.custom.impl.BOFactory;
import org.example.surfboardlayerd.stom.BeachLocationDAO;
import org.example.surfboardlayerd.achLocationDTO;
import org.example.surfboardlayerd.BeachLocationEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeachLocationBOImpl implements BeachLocationBO {

    private final BeachLocationDAO beachLocationDAO = (BeachLocationDAO) DAOFactory.getDAOFactory()
            .getDAO(DAOFactory.DAOTypes.BEACH_LOCATION);

    @Override
    public boolean saveBeachLocation(BeachLocationDTO dto) throws SQLException, ClassNotFoundException {
        BeachLocationEntity entity = convertDTOToEntity(dto);
        return beachLocationDAO.save(entity);
    }

    @Override
    public boolean updateBeachLocation(BeachLocationDTO dto) throws SQLException, ClassNotFoundException {
        BeachLocationEntity entity = convertDTOToEntity(dto);
        return beachLocationDAO.update(entity);
    }

    @Override
    public boolean deleteBeachLocation(String id) throws SQLException, ClassNotFoundException {
        return beachLocationDAO.delete(id);
    }

    @Override
    public List<BeachLocationDTO> getAllBeachLocations() throws SQLException, ClassNotFoundException {
        List<BeachLocationEntity> entities = beachLocationDAO.getAll();
        List<BeachLocationDTO> dtos = new ArrayList<>();

        for (BeachLocationEntity entity : entities) {
            dtos.add(convertEntityToDTO(entity));
        }
        return dtos;
    }

    @Override
    public BeachLocationDTO getBeachLocationById(String id) throws SQLException, ClassNotFoundException {
        BeachLocationEntity entity = beachLocationDAO.findById(id);
        return entity != null ? convertEntityToDTO(entity) : null;
    }

    @Override
    public String getNextBeachLocationId() throws SQLException, ClassNotFoundException {
        return beachLocationDAO.getNextId();
    }

    @Override
    public List<String> getAllBeachLocationIds() throws SQLException, ClassNotFoundException {
        return beachLocationDAO.getAllBeachIds();
    }

    @Override
    public List<String> getAllMonths() {
        return Arrays.asList(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
    }

    @Override
    public List<String> getAllSeasons() {
        return Arrays.asList("High Season", "Low Season", "Peak Season", "Off Season");
    }
