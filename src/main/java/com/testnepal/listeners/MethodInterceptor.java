package com.testnepal.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.testnepal.constants.FrameworkConstant;
import com.testnepal.utils.ExcelUtils;

/**
 * Implements {@link org.testng.IMethodInterceptor} to leverage the abstract methods
 * Mostly used to read the data from excel and decides on which tests needs to run.
 * 
 * <pre>Please make sure to add the listener details in the testng.xml file</pre>
 * 
 * <p>24-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 */
public class MethodInterceptor implements IMethodInterceptor {

	/**
	 * Intercepts the existing test methods and changes the annotation value at the run time
	 * Values are fetched from the excel sheet.
	 * User has to choose yes/No in the RunManager sheet.
	 * Suppose if there are 3 tests named a,b,c needs to be run, it reads the excel and understand user wants to 
	 * run only a and c, then it will return the same after performing the comparisons.
	 */
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<Map<String, String>> list = ExcelUtils.getExcelData(FrameworkConstant.getRunnerManagerSheetName());
		List<IMethodInstance> result = new ArrayList<>();

		for(int i=0; i<methods.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TestName")) && 
						list.get(j).get("Execute").equalsIgnoreCase("yes")) {
					methods.get(i).getMethod().setDescription(list.get(j).get("TestDescription"));
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Count")));
					methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("Priority")));
					result.add(methods.get(i));
				}
			}
		}
		return result;
	}

}
