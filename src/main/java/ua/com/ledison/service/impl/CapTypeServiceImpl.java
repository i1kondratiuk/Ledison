package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.ledison.dao.CapTypeDao;
import ua.com.ledison.entity.CapType;
import ua.com.ledison.service.CapTypeService;

import java.util.List;

@Service
public class CapTypeServiceImpl implements CapTypeService {

	@Autowired
	private CapTypeDao capTypeDao;

	@Override
	public List<CapType> getCapTypeList() {
		return capTypeDao.findAll();
	}

	@Override
	public CapType getCapTypeById(int id) {
		return capTypeDao.findOne(id);
	}

	@Override
	public void addCapType(CapType capType) {
		capTypeDao.save(capType);
	}

	@Override
	public void editCapType(CapType capType) {
		capTypeDao.save(capType);
	}

	@Override
	public void deleteCapType(CapType capType) {
		capTypeDao.delete(capType);
	}
}
