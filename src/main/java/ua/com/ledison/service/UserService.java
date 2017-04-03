package ua.com.ledison.service;

import ua.com.ledison.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User findByName(String username);
    List<User> getAllUsers();
}
