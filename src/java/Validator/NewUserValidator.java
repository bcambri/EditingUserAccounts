/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import domain.newUser;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 *
 * @author syntel
 */
public class NewUserValidator implements Validator{
    @Override
	public boolean supports(Class<?> clazz) {
		return newUser.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last", "last.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "address.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "address.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "address.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "address.required");
		newUser user = (newUser) target;	
	}
}
