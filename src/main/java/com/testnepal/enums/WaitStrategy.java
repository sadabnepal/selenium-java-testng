package com.testnepal.enums;

/**
 * Enums to restrict the users to choose an appropriate waiting strategy before operating an element.
 * 
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 * @see com.testnepal.factories.ExplicitWaitFactory
 * @see com.testnepal.pages.BasePage
 */
public enum WaitStrategy {	
	CLICKABLE,
	PRESENCE,
	VISIBLE,
	NONE;
}
