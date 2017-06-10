package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.com.ledison.dao.SoldUnitDao;
import ua.com.ledison.entity.Product;
import ua.com.ledison.entity.SoldUnit;
import ua.com.ledison.service.SoldUnitService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoldUnitServiceImpl implements SoldUnitService {

	@Autowired
	SoldUnitDao soldUnitDao;

	@Override
	public List<SoldUnit> getSoldUnitsList() {
		return soldUnitDao.findAll();
	}

	public List<Product> get8MostPopularProducts() {

		final PageRequest top8 = new PageRequest(
				0, 8, Sort.Direction.DESC, "quantity"
		);

		Page<SoldUnit> soldUnitsPage = soldUnitDao.findAll(top8);

		List<Product> products = new ArrayList<>();
		for (SoldUnit soldUnit : soldUnitsPage) {
			products.add(soldUnit.getProduct());
		}

		return products;
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
