package com.guven.springdemo.mvc.validation;

import java.util.Iterator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements  ConstraintValidator<CourseCode, String> {

	private String[] coursePrefixes ;
	boolean result;
	
	@Override
	public void initialize(CourseCode theCourseCode ) {
	
		
		coursePrefixes=theCourseCode.value();
	}
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		
		if(theCode!=null){
			//result=theCode.startsWith(coursePrefix);
		
			for (String tempPrefix: coursePrefixes) {
				result=theCode.startsWith(tempPrefix);	
				  if (result) {
	                    break;
	                }
			}
		}
		else{
			result=true;
		}
 
		return result;
	}


}
