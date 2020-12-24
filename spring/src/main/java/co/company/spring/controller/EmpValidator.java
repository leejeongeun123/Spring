package co.company.spring.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import co.company.spring.dao.Emp;

public class EmpValidator implements Validator {

	final static String emailRegExp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	private Pattern pattern;//정규표현식 검사할 변수선언
	
	public EmpValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Emp.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Emp emp = (Emp)target;
		if(emp.getLastName() == null ||
		   emp.getLastName().trim().isEmpty() ) {
			errors.rejectValue("lastName", "requied", new Object[] {"lastName"}, "" );
		}
		
		//null체크 메소드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"jobId", "requied", new Object[] {"jobId"}, "" );
		
		//이메일형식(@.)
		if(emp.getEmail() == null ||
				   emp.getEmail().trim().isEmpty() ) {
					errors.rejectValue("email", "requied", new Object[] {"email"}, "" );
				}else {
					Matcher matcher = pattern.matcher(emp.getEmail());
					if(! matcher.matches()) {
						errors.rejectValue("email", "bad");
					}
				}

	}
	

}
