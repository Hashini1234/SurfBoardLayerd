package org.example.surfboardlayerd.BO.custom.impl;

import org.example.surfboardlayerd.BO.custom.UserBO;
import org.example.surfboardlayerd.Dao.DAOFactory;
import org.example.surfboardlayerd.Dao.custom.UserDAO;
import org.example.surfboardlayerd.entity.UserEntity;
import org.example.surfboardlayerd.model.UserDto;

import java.util.ArrayList;

public class UserBOImpl implements UserBO {

    private final UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public ArrayList<UserEntity> getAll() throws Exception {
        ArrayList<UserEntity> users = userDAO.getAll();
        ArrayList<UserDto> dtos = new ArrayList<>();
        for (UserEntity e : users) {
            dtos.add(new UserDto(e.getId(), e.getName(), e.getEmail(), e.getRole(), e.getPassword()));
        }
        return null;
    }

    @Override
    public boolean add(UserDto dto) throws Exception {
      return userDAO.save(new UserEntity(dto.getId(), dto.getName(), dto.getEmail(), dto.getRole(), dto.getPassword()));
    }

    @Override
    public boolean update(String id, String name, String email, String password, String role) throws Exception {
         return userDAO.update(new UserEntity(id, name, email, role, password));
    }

    @Override
    public boolean delete(String id) throws Exception {
        return userDAO.delete(id);
    }

    @Override
    public UserDto search(String id) throws Exception {
        UserEntity user = userDAO.search(id);
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getRole(), user.getPassword());
    }

    @Override
    public String generateNewId() throws Exception {
        return userDAO.generateNewId();
    }

    @Override
    public boolean checkUser(String username) throws Exception {
        return userDAO.checkUser(username);
    }

    @Override
    public UserDto getUser(String username) throws Exception {
        UserEntity user = userDAO.getUser(username);
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getRole(), user.getPassword());
    }
}
