package co.za.profileuiservice.services;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import co.za.profileuiservice.validator.EmailValidator;


@Target({ElementType.METHOD, ElementType.FIELD ,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailValidator.class})
@Documented
public @interface IsEmailValid {
     
	String message() default"Please make sure email address is valid";
	Class<?> [] groups () default {};
	Class<? extends Payload>[] payload() default {};

}

