package com.mock.services;

import com.mock.dao.UserDao;
import com.mock.models.User;

public class UserService {
    private UserDao userDAO;

    public UserService(UserDao userDAo) {
        this.userDAO = userDAo;
    }

    public User[] getAllUsers(String token){
        if(!token.equals("ADMIN")) throw new RuntimeException("ForbiddenException");
        return userDAO.getAllUsers();
    }

    public User getUserByID(int userID){
        if(userID == 0 ) throw new RuntimeException("Incorrect user id");
        return userDAO.getUserByID();
    }
}
