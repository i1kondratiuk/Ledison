package ua.com.ledison.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.ledison.entity.WarrantyPeriod;
import ua.com.ledison.service.WarrantyPeriodService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class WarrantyPeriodValidator implements ConstraintValidator<WarrantyPeriodAlreadyExists, Integer> {

	@Autowired
	WarrantyPeriodService warrantyPeriodService;

	@Override
	public void initialize(WarrantyPeriodAlreadyExists warrantyPeriodAlreadyExists) {

	}

	@Override
	public boolean isValid(Integer warrantyPeriod, ConstraintValidatorContext constraintValidatorContext) {
		List<WarrantyPeriod> warrantyPeriods = warrantyPeriodService.getWarrantyPeriodList();
		for (WarrantyPeriod wp : warrantyPeriods) {
			if (warrantyPeriod.equals(wp.getWarrantyPeriod())){
				return false;
			}
		}
		return true;
	}
}
