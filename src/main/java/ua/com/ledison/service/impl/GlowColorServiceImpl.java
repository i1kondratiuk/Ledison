package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.ledison.dao.GlowColorDao;
import ua.com.ledison.entity.GlowColor;
import ua.com.ledison.service.GlowColorService;

import java.util.List;

@Service
public class GlowColorServiceImpl implements GlowColorService {

	@Autowired
	private GlowColorDao glowColorDao;

	@Override
	public List<GlowColor> getGlowColorList() {
		return glowColorDao.findAll();
	}

	@Override
	public GlowColor getGlowColorById(int id) {
		return glowColorDao.findOne(id);
	}

	@Override
	public void addGlowColor(GlowColor glowColor) {
		glowColorDao.save(glowColor);
	}

	@Override
	public void editGlowColor(GlowColor glowColor) {
		glowColorDao.save(glowColor);
	}

	@Override
	public void deleteGlowColor(GlowColor glowColor) {
		glowColorDao.delete(glowColor);
	}
}
