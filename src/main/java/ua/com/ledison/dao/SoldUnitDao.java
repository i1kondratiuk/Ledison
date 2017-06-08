package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ledison.entity.SoldUnit;

public interface SoldUnitDao extends JpaRepository<SoldUnit, Integer> {

}
