package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.ledison.dao.UserDao;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.UserService;

import java.util.List;

/**
 * Created by i1kon on 29-Mar-17.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	public void addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public User findByName(String username) {
		return userDao.findByUserName(username);
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return findByName(username);
	}
}
