package org.example.surfboardlayerd.Dao.custom.Impl;

import org.example.surfboardlayerd.Dao.SQLUtil;
import org.example.surfboardlayerd.Dao.custom.UserDAO;
import org.example.surfboardlayerd.entity.ItemEntity;
import org.example.surfboardlayerd.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    @Override
    public ArrayList<ItemEntity> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM users");
        ArrayList<UserEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new UserEntity(
                    resultSet.getString("user_id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("role"),
                    resultSet.getString("password")

            ));
        }
        return list;

    }

    @Override
    public boolean save(UserEntity user) throws SQLException, ClassNotFoundException {
       SQLUtil.execute(
               "INSERT INTO users VALUES (?,?,?,?,?)",
               user.getId(),
               user.getName(),
               user.getEmail(),
               user.getRole(),
               user.getPassword()

       );
        return true;
    }

    @Override
    public boolean update(UserEntity customerDTO) throws SQLException, ClassNotFoundException {
        boolean executeUpdate = SQLUtil.execute(
                "UPDATE users SET name=?, email=?, role=?, password=? WHERE user_id=?",
                customerDTO.getName(),
                customerDTO.getEmail(),
                customerDTO.getRole(),
                customerDTO.getPassword(),
                customerDTO.getId()
        );
        return executeUpdate;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM users WHERE user_id=?", id);
        return resultSet.next();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        boolean executeUpdate = SQLUtil.execute("DELETE FROM users WHERE user_id=?", id);
        return executeUpdate;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        try{
            ResultSet rs = SQLUtil.execute("select id from users order by id DESC limit 1");
            char tableCharactor ='U';
            if(rs.next()){
                String lastId =rs.getString(1);
                String lastIdNumberString = lastId.substring(1);
                int lastIdNumber = Integer.parseInt(lastIdNumberString);
                int nextIdNumber = lastIdNumber + 1;
                String nextIdString =String.format("U%03d", nextIdNumber);
                return nextIdString;
            }
            return tableCharactor+"001";

        }catch (Exception e){
            return "U001";
        }
    }

    @Override
    public UserEntity search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM users WHERE user_id=?", id);
        if (resultSet.next()) {
            return new UserEntity(
                    resultSet.getString("user_id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("role"),
                    resultSet.getString("password")

            );
        }
        return null;
    }

    @Override
    public boolean checkUser(String username) throws SQLException, ClassNotFoundException {
        try {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM users WHERE name = ?",username);
        if (resultSet.next()) {
            return true;
        }
        return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}

    @Override
    public UserEntity getUser(String username) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM users WHERE name = ?", username);
        if (resultSet.next()) {
            UserEntity user = new UserEntity(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("role"),
                    resultSet.getString("password")
            );

            return user;
        }

        return null;
    }
}
