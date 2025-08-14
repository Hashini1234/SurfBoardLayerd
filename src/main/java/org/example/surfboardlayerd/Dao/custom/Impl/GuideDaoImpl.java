package org.example.surfboardlayerd.Dao.custom.Impl;

import org.example.surfboardlayerd.Dao.SQLUtil;
import org.example.surfboardlayerd.Dao.custom.GuideDao;
import org.example.surfboardlayerd.entity.GuideEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuideDaoImpl implements GuideDao {
    @Override
    public ArrayList<GuideEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT * FROM guide");
        ArrayList<GuideEntity> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new GuideEntity(
                    rs.getString("guide_id"),
                    rs.getString("name"),
                    rs.getString("contact_details"),
                    rs.getString("experience_level"),
                    rs.getDouble("pay_for")
            ));
        }
        return list;
    }

    @Override
    public boolean save(GuideEntity guide) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(
                "INSERT INTO Guide (guide_id, name, contact_details, experience_level, pay_for) VALUES (?,?,?,?,?)",
                guide.getGuide_id(), guide.getName(), guide.getContact_Details(), guide.getExperience_Level(), guide.getPay_for()
        );
    }

    @Override
    public boolean update(GuideEntity guide) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute(
                "UPDATE Guide SET name=?, contact_details=?, experience_level=?, pay_for=? WHERE guide_id=?",
                guide.getName(), guide.getContact_Details(), guide.getExperience_Level(), guide.getPay_for(), guide.getGuide_id()
        );
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public GuideEntity getById(String id) throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT * FROM Guide WHERE guide_id=?", id);
        if (rs.next()) {
            return new GuideEntity(
                    rs.getString("guide_id"),
                    rs.getString("name"),
                    rs.getString("contact_details"),
                    rs.getString("experience_level"),
                    rs.getDouble("pay_for")
            );
        }
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Guide WHERE guide_id=?", id);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rs = SQLUtil.execute("SELECT guide_id FROM Guide ORDER BY guide_id DESC LIMIT 1");
        if (rs.next()) {
            String lastId = rs.getString(1);
            int num = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("G%03d", num);
        }
        return "G001";
    }

    @Override
    public GuideEntity search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

}
