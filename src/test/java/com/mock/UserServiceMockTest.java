package com.mock;

import com.mock.dao.UserDao;
import com.mock.models.User;
import com.mock.services.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceMockTest {
    @Test
    public void getAllUsers_success() {
        //Given
        UserDao userDao = mock(UserDao.class);//new UserDao();
        User[] users = {new User(12), new User(15)};
        when(userDao.getAllUsers()).thenReturn(users);
        UserService userService = new UserService(userDao);

        //When
        User[] admins = userService.getAllUsers("ADMIN");

        //Then
        assertNotNull(admins);
    }

    @Test
    public void getAllUsersV2_success() {
        //Given
        UserDao userDao = mock(UserDao.class);//new UserDao();
        User[] users = {};
        when(userDao.getAllUsers()).thenReturn(users);

        UserService userService = new UserService(userDao);

        //When
        User[] admins = userService.getAllUsers("ADMIN");

        //Then
        assertNotNull(admins);

        assertEquals(0, admins.length);
    }

    @Test
    public void getAllUsers_failure() {
        //Given
        UserDao userDao = mock(UserDao.class);//new UserDao();
        User[] users = {new User(12), new User(15)};
        when(userDao.getAllUsers()).thenReturn(users);
        UserService userService = new UserService(userDao);


        //When
        String token = "user";

        //Then
        assertThrows(RuntimeException.class, ()-> userService.getAllUsers(token));
    }

    @Test
    public void getUserById_success() {
        //Given
        UserDao userDao = mock(UserDao.class);
        User user_expected = new User(25);
        when(userDao.getUserByID()).thenReturn(user_expected);
        UserService userService = new UserService(userDao);


        //When
        int userID = 2;

        //Then
        assertEquals(user_expected, userService.getUserByID(userID));
    }

    @Test
    public void getUserById_failure() {
        //Given
        UserDao userDao = mock(UserDao.class);
        User user_expected = new User(25);
        when(userDao.getUserByID()).thenReturn(user_expected);
        UserService userService = new UserService(userDao);


        //When
        int userID = 0;

        //Then
        assertThrows(RuntimeException.class, ()-> userService.getUserByID(userID));
    }

}
