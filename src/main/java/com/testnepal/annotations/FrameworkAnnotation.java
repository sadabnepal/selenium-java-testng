package com.testnepal.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.testnepal.enums.CategoryType;

/**
 * <p>Framework Annotation is user built annotation which is annotated on top of test methods to log the author details and 
 * category details to the extent report.</p>
 * 
 * <p>Runtime retention value indicate that this annotation will be available at run time for reflection operations.</p>
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {
	
	/**
	 * 
	 * @author MD SADAB SAQIB
	 * 24-Jan-2021
	 * @return Store author name who created test as String[]
	 */
	public String[] author();
	
	/**
	 * 
	 * @author MD SADAB SAQIB
	 * 24-Jan-2021
	 * @return Stores the category in form of Enum Array. Include the possible values in {@link com.testnepal.enums.CategoryType}
	 */
	public CategoryType[] category();

}
