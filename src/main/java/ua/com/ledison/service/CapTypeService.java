package ua.com.ledison.service;

import ua.com.ledison.entity.CapType;

import java.util.List;

public interface CapTypeService {

	List<CapType> getCapTypeList();

	CapType getCapTypeById(int id);

	void addCapType(CapType capType);

	void editCapType(CapType capType);

	void deleteCapType(CapType capType);
}