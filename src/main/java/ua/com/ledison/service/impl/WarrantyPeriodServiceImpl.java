package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.ledison.dao.WarrantyPeriodDao;
import ua.com.ledison.entity.WarrantyPeriod;
import ua.com.ledison.service.WarrantyPeriodService;

import java.util.List;

@Service
@Transactional
public class WarrantyPeriodServiceImpl implements WarrantyPeriodService {

	@Autowired
	WarrantyPeriodDao warrantyPeriodDao;

	@Override
	public List<WarrantyPeriod> getWarrantyPeriodList() {
		return warrantyPeriodDao.findAll();
	}

	@Override
	public WarrantyPeriod getWarrantyPeriodById(int id) {
		return warrantyPeriodDao.findOne(id);
	}

	@Override
	public void addWarrantyPeriod(WarrantyPeriod warrantyPeriod) {
		warrantyPeriodDao.save(warrantyPeriod);
	}

	@Override
	public void editWarrantyPeriod(WarrantyPeriod warrantyPeriod) {
		warrantyPeriodDao.save(warrantyPeriod);
	}

	@Override
	public void deleteWarrantyPeriod(WarrantyPeriod warrantyPeriod) {
		warrantyPeriodDao.delete(warrantyPeriod);
	}
}
