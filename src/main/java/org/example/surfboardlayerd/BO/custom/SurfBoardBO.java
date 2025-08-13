package org.example.surfboardlayerd.BO.custom;

import org.example.surfboardlayerd.BO.SuperBO;
import org.example.surfboardlayerd.entity.SurfBoardEntity;
import org.example.surfboardlayerd.model.SurfBoardDto;

import java.sql.SQLException;
import java.util.List;

public interface SurfBoardBO extends SuperBO  {
    List<SurfBoardEntity> getAllSurfBoards() throws SQLException, ClassNotFoundException;
    boolean saveSurfBoard(SurfBoardEntity dto) throws SQLException, ClassNotFoundException;
    boolean updateSurfBoard(SurfBoardEntity dto) throws SQLException, ClassNotFoundException;
    boolean deleteSurfBoard(String id) throws SQLException, ClassNotFoundException;
    String getNextSurfBoardId() throws SQLException, ClassNotFoundException;
    List<String> getAllSurfBoardIds() throws SQLException, ClassNotFoundException;
}
