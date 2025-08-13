package org.example.surfboardlayerd.BO.custom;

import org.example.surfboardlayerd.BO.SuperBO;
import org.example.surfboardlayerd.entity.GuideEntity;

import java.sql.SQLException;
import java.util.List;

public interface GuideBO extends SuperBO {
    boolean saveGuide(GuideEntity guide) throws SQLException, ClassNotFoundException;
    boolean updateGuide(GuideEntity guide) throws SQLException, ClassNotFoundException;
    boolean deleteGuide(String id) throws SQLException, ClassNotFoundException;
    GuideEntity getGuideById(String id) throws SQLException, ClassNotFoundException;
    List<GuideEntity> getAllGuides() throws SQLException, ClassNotFoundException;
    String getNextId() throws SQLException, ClassNotFoundException;
}
