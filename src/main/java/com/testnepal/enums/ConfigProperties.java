package com.testnepal.enums;

/**
 *  Enums to restrict the values used on Property files. Without using enums there can be null pointer exceptions happening
 * because of typos.
 * <p>
 * Whenever a new value is added to property file, corresponding enum should be created here.
 * 
 * <p>23-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 * @see com.testnepal.utils.PropertyUtils
 */
public enum ConfigProperties {
	URL,
	BROWSER,
	OVERRIDEREPORTS,
	PASSEDSTEPSCREENSHOTS,
	FAILEDSTEPSCREENSHOTS,
	SKIPPEDSTEPSCREENSHOTS,
	RETRYFAILEDTESTS,
	FAILEDTESTRETRYCOUNT,
	AUTOREPORTOPEN,
}
