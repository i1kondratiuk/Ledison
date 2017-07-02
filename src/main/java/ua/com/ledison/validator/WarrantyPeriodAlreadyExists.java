package ua.com.ledison.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = WarrantyPeriodValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface WarrantyPeriodAlreadyExists {
	String message() default "This value is already exists";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
