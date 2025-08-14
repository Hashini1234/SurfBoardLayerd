package org.example.surfboardlayerd.BO.custom;

import org.example.surfboardlayerd.BO.SuperBO;
import org.example.surfboardlayerd.entity.UserEntity;
import org.example.surfboardlayerd.model.UserDto;

import java.util.ArrayList;

public interface UserBO extends SuperBO {
    ArrayList<UserEntity> getAll() throws Exception;
    boolean add(UserDto userDto) throws Exception;
    boolean update(String id,String name,String email,String password,String role) throws Exception;
    boolean delete(String id) throws Exception;
    UserDto search(String id) throws Exception;
    String generateNewId() throws Exception;
    boolean checkUser(String username) throws Exception;
    UserDto getUser(String username) throws Exception;
}
