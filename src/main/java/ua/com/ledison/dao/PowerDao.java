package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ledison.entity.Power;

public interface PowerDao extends JpaRepository<Power, Integer> {

}