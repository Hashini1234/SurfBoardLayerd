package org.example.surfboardlayerd.BO.custom.impl;

import org.example.surfboardlayerd.BO.custom.GuideBO;
import org.example.surfboardlayerd.Dao.DAOFactory;
import org.example.surfboardlayerd.Dao.custom.GuideDao;
import org.example.surfboardlayerd.entity.GuideEntity;
import org.example.surfboardlayerd.view.tdm.GuideTM;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuideBOImpl implements GuideBO {
private final GuideDao guideDao = ( GuideDao)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GUIDE);


    @Override
    public boolean saveGuide(GuideEntity guide) throws SQLException, ClassNotFoundException {
        return guideDao.save(new GuideEntity(
                guide.getGuide_id(),
                guide.getName(),
                guide.getContact_Details(),
                guide.getExperience_Level(),
                guide.getPay_for()
        ));
    }

    @Override
    public boolean updateGuide(GuideEntity guide) throws SQLException, ClassNotFoundException {
        return guideDao.update(new GuideEntity(
                guide.getGuide_id(),
                guide.getName(),
                guide.getContact_Details(),
                guide.getExperience_Level(),
                guide.getPay_for()
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
            return new GuideEntity(e.getGuide_id(), e.getName(), e.getContact_Details(), e.getExperience_Level(), e.getPay_for());
        }
        return null;
    }

    @Override
    public List<GuideTM> getAllGuides() throws SQLException, ClassNotFoundException {
        List<GuideEntity> entities = guideDao.getAll();
        List<GuideTM> list = new ArrayList<>();
        for (GuideEntity e : entities) {
            list.add(new GuideTM(e.getGuide_id(), e.getName(), e.getContact_Details(), e.getExperience_Level(), e.getPay_for()));
        }
        return list;
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return guideDao.generateNewId();

    }
}
