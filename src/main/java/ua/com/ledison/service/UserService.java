package ua.com.ledison.service;

import ua.com.ledison.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    User findByName(String username);
    User findById(int id);
    User findByNameAndFetchItems(String username);
    List<User> getAllUsers();
}
