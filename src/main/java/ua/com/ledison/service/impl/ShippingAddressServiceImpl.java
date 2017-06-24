package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.ledison.dao.ShippingAddressDao;
import ua.com.ledison.entity.ShippingAddress;
import ua.com.ledison.service.ShippingAddressService;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

	@Autowired
	ShippingAddressDao shippingAddressDao;

	public void addShippingAddress(ShippingAddress shippingAddress) {
		shippingAddressDao.save(shippingAddress);
	}

	@Override
	public void updateShippingAddress(ShippingAddress shippingAddress) {
		shippingAddressDao.save(shippingAddress);
	}

	public ShippingAddress getShippingAddressById(int shippingAddressId) {
		return shippingAddressDao.findOne(shippingAddressId);
	}
}
