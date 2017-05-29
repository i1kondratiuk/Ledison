package ua.com.ledison.service;

import ua.com.ledison.entity.WarrantyPeriod;

import java.util.List;

public interface WarrantyPeriodService {

	List<WarrantyPeriod> getWarrantyPeriodList();
	WarrantyPeriod getWarrantyPeriodById(int id);
	void addWarrantyPeriod(WarrantyPeriod warrantyPeriod);
	void editWarrantyPeriod(WarrantyPeriod warrantyPeriod);
	void deleteWarrantyPeriod(WarrantyPeriod warrantyPeriod);
}
