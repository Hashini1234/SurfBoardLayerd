package org.example.surfboardlayerd.Dao.custom.Impl;

import org.example.surfboardlayerd.Dao.SQLUtil;
import org.example.surfboardlayerd.Dao.custom.BeachLocationDao;
import org.example.surfboardlayerd.entity.BeachLocationEntity;
import org.example.surfboardlayerd.entity.ItemEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BeachLocationDaoImpl implements BeachLocationDao {
    @Override
    public ArrayList<BeachLocationEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT * FROM Beach_Location");
        ArrayList<BeachLocationEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new BeachLocationEntity(
                    rs.getString("beach_id"),
                    rs.getString("name"),
                    rs.getString("peak_season"),
                    rs.getString("month")
            ));
        }
        return list;
    }

    @Override
    public boolean save(BeachLocationEntity entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(
                "INSERT INTO Beach_Location VALUES (?,?,?,?)",
                entity.getBeachId(),
                entity.getName(),
                entity.getPeakSeason(),
                entity.getMonth()
        );
    }

    @Override
    public boolean update(BeachLocationEntity entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(
                "UPDATE Beach_Location SET name=?, peak_season=?, month=? WHERE beach_id=?",
                entity.getName(),
                entity.getPeakSeason(),
                entity.getMonth(),
                entity.getBeachId()
        );
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Beach_Location WHERE beach_id=?", id);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public BeachLocationEntity search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public String getNextId() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT beach_id FROM Beach_Location ORDER BY beach_id DESC LIMIT 1");
        char prefix = 'B';
        if (rs.next()) {
            String lastId = rs.getString(1);
            int num = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format(prefix + "%03d", num);
        }
        return prefix + "001";
    }
}