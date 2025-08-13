package org.example.surfboardlayerd.Dao.custom.Impl;

import org.example.surfboardlayerd.Dao.SQLUtil;
import org.example.surfboardlayerd.Dao.custom.SurfBoardDao;
import org.example.surfboardlayerd.entity.ItemEntity;
import org.example.surfboardlayerd.entity.SurfBoardEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurfBoardDaoImpl implements SurfBoardDao {
    @Override
    public ArrayList<SurfBoardEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT * FROM Surf_Board");
        ArrayList<SurfBoardEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new SurfBoardEntity(
                    rs.getString("surfboard_id"),
                    rs.getString("brand"),
                    rs.getString("condition")

            ));
        }
        return list;
    }

    @Override
    public boolean save(SurfBoardEntity entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Surf_Board VALUES (?,?,?,?)",
                entity.getSurfboardId(),
                entity.getBrand(),
                entity.getConditions());

    }

    @Override
    public boolean update(SurfBoardEntity entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Surf_Board SET brand=?, condition=?, status=? WHERE surfboard_id=?",
                entity.getBrand(),
                entity.getConditions(),

                entity.getSurfboardId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Surf_Board WHERE surfboard_id=?", id);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT surfboard_id FROM Surf_Board ORDER BY surfboard_id DESC LIMIT 1");
        char prefix = 'S';
        if (rs.next()) {
            String lastId = rs.getString(1);
            int num = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("%c%03d", prefix, num);
        }
        return "S001";
    }

    @Override
    public SurfBoardEntity search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getAllIds() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT surfboard_id FROM Surf_Board");
        List<String> ids = new ArrayList<>();
        while (rs.next()) {
            ids.add(rs.getString(1));
        }
        return ids;
    }

    @Override
    public String getNextId() {
        return "";
    }
}

