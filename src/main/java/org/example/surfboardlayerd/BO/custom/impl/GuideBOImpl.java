package org.example.surfboardlayerd.BO.custom.impl;

import org.example.surfboardlayerd.BO.custom.GuideBO;
import org.example.surfboardlayerd.Dao.DAOFactory;
import org.example.surfboardlayerd.Dao.custom.GuideDao;
import org.example.surfboardlayerd.entity.GuideEntity;
import org.example.surfboardlayerd.model.GuideDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuideBOImpl implements GuideBO {
private final GuideDao guideDao = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GUIDE);


    @Override
    public boolean saveGuide(GuideEntity guide) throws SQLException, ClassNotFoundException {
        return guideDao.save(new GuideEntity(
                guide.getGuideId(),
                guide.getName(),
                guide.getContactDetails(),
                guide.getExperienceLevel(),
                guide.getPayFor(),
                guide.getStatus()
        ));
    }

    @Override
    public boolean updateGuide(GuideEntity guide) throws SQLException, ClassNotFoundException {
        return guideDao.update(new GuideEntity(
                guide.getGuideId(),
                guide.getName(),
                guide.getContactDetails(),
                guide.getExperienceLevel(),
                guide.getPayFor(),
                guide.getStatus()
        ));
    }

    @Override
    public boolean deleteGuide(String id) throws SQLException, ClassNotFoundException {
        return guideDao.delete(id);
    }

    @Override
    public GuideEntity getGuideById(String id) throws SQLException, ClassNotFoundException {
        GuideEntity e = guideDao.getById(id);
        if (e != null) {
            return new GuideEntity(e.getGuideId(), e.getName(), e.getContactDetails(), e.getExperienceLevel(), e.getPayFor(), e.getStatus());
        }
        return null;
    }

    @Override
    public List<GuideDto> getAllGuides() throws SQLException, ClassNotFoundException {
        List<GuideEntity> entities = guideDao.getAll();
        List<GuideDto> list = new ArrayList<>();
        for (GuideEntity e : entities) {
            list.add(new GuideDto(e.getGuideId(), e.getName(), e.getContactDetails(), e.getExperienceLevel(), e.getPayFor(), e.getStatus()));
        }
        return list;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return guideDao.generateNewId();

    }
}
