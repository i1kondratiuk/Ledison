package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ledison.entity.CapType;

public interface CapTypeDao extends JpaRepository<CapType, Integer> {

}