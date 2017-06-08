package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.ledison.dao.SoldUnitDao;
import ua.com.ledison.entity.SoldUnit;
import ua.com.ledison.service.SoldUnitService;

import java.util.List;

@Service
public class SoldUnitServiceImpl implements SoldUnitService {

	@Autowired
	SoldUnitDao soldUnitDao;

	@Override
	public List<SoldUnit> getSoldUnitsList() {
		return soldUnitDao.findAll();
	}

	@Override
	public SoldUnit getSoldUnitById(int soldUnitId) {
		return soldUnitDao.findOne(soldUnitId);
	}

	@Override
	public void update(SoldUnit soldUnit) {
		soldUnitDao.save(soldUnit);
	}
}
