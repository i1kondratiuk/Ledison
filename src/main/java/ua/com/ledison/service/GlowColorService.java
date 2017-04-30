package ua.com.ledison.service;

import ua.com.ledison.entity.GlowColor;

import java.util.List;

public interface GlowColorService {

	List<GlowColor> getGlowColorList();

	GlowColor getGlowColorById(int id);

	void addGlowColor(GlowColor glowColor);

	void editGlowColor(GlowColor glowColor);

	void deleteGlowColor(GlowColor glowColor);
}
