package com.mock;

import com.mock.dao.UserDao;
import com.mock.models.User;
import com.mock.services.UserService;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        UserService userService = new UserService(userDao);
        User[] users = userService.getAllUsers("ADMIN");
        for(User user:users) {
            System.out.println(user);
        }

    }
}
