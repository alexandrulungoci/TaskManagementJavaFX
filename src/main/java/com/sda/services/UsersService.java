package com.sda.services;


import com.sda.UI.exceptions.WrongCredentialsException;
import com.sda.dao.UserDao;
import com.sda.model.UserModel;

import java.util.List;
import java.util.Optional;

public class UsersService {

    UserDao userDao = new UserDao();

    public void addUser(UserModel userModel) {
        userDao.add(userModel);
    }

    public List<UserModel> getUsers() {
        List<UserModel> userModelList = userDao.getAllUsers();
        return userModelList;
    }

    public UserModel findUserById(int id) {
        UserModel userModel = userDao.findUserById(id);
        return userModel;
    }

    public UserModel findUserByUserName(String userName) throws WrongCredentialsException {
        Optional<UserModel> userModel = userDao.findByUserName(userName);
        if(userModel.isPresent()){
            return userModel.get();
        } else {
            throw new WrongCredentialsException();
        }
    }


    public void updateUsername(UserModel userModel) {
        userDao.update(userModel);
    }

    public void removeUser(UserModel userModel){
        userDao.remove(userModel);
    }

}
