package ua.com.ledison.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.ledison.entity.WarrantyPeriod;
import ua.com.ledison.service.WarrantyPeriodService;

import java.util.List;
import java.util.Objects;

@Component
public class WarrantyPeriodFormValidator implements Validator {

	@Autowired
	WarrantyPeriodService warrantyPeriodService;

	@Override
	public boolean supports(Class<?> paramClass) {
		return WarrantyPeriod.class.equals(paramClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "warrantyPeriod", "warrantyPeriod.required");
		WarrantyPeriod warrantyPeriod = (WarrantyPeriod) target;
		List<WarrantyPeriod> warrantyPeriods = warrantyPeriodService.getWarrantyPeriodList();
		for (WarrantyPeriod wp : warrantyPeriods) {
			if (Objects.equals(warrantyPeriod.getWarrantyPeriod(), wp.getWarrantyPeriod())) {
				errors.rejectValue("warrantyPeriod", "warrantyPeriod.alreadyExists");
			}
		}
	}
}
