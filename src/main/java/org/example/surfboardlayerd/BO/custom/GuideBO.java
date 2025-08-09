package org.example.surfboardlayerd.BO.custom;

import org.example.surfboardlayerd.entity.Guide;

import java.sql.SQLException;
import java.util.List;

public interface GuideBO {
    boolean saveGuide(Guide guide) throws SQLException, ClassNotFoundException;
    boolean updateGuide(Guide guide) throws SQLException, ClassNotFoundException;
    boolean deleteGuide(String id) throws SQLException, ClassNotFoundException;
    Guide getGuideById(String id) throws SQLException, ClassNotFoundException;
    List<Guide> getAllGuides() throws SQLException, ClassNotFoundException;
    String getNextId() throws SQLException, ClassNotFoundException;
}
