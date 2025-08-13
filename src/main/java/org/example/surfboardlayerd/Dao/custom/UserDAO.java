package org.example.surfboardlayerd.Dao.custom;

import org.example.surfboardlayerd.Dao.CrudDao;
import org.example.surfboardlayerd.entity.UserEntity;

import java.sql.SQLException;

public interface UserDAO extends CrudDao<UserEntity> {
    boolean checkUser(String username) throws SQLException, ClassNotFoundException;
    UserEntity getUser(String username) throws SQLException, ClassNotFoundException;
}
