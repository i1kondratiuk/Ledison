package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ledison.entity.User;

public interface CustomerDao extends JpaRepository<User, Integer> {

}