package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ledison.entity.GlowColor;

public interface GlowColorDao extends JpaRepository<GlowColor, Integer> {

}
