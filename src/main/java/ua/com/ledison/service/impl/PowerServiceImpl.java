package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.ledison.dao.PowerDao;
import ua.com.ledison.entity.Power;
import ua.com.ledison.service.PowerService;

import java.util.List;

@Service
@Transactional
public class PowerServiceImpl implements PowerService {

	@Autowired
	private PowerDao powerDao;

	@Override
	public List<Power> getPowerList() {
		return powerDao.findAll();
	}

	@Override
	public Power getPowerById(int id) {
		return powerDao.findOne(id);
	}

	@Override
	public void addPower(Power power) {
		powerDao.save(power);
	}

	@Override
	public void editPower(Power power) {
		powerDao.save(power);
	}

	@Override
	public void deletePower(Power power) {
		powerDao.delete(power);
	}
}
