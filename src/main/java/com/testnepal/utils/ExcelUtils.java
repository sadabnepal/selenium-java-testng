package com.testnepal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.testnepal.constants.FrameworkConstant;
import com.testnepal.exceptions.FrameworkExceptions;
import com.testnepal.exceptions.InvalidExcelPathException;

/**
 * Utility class to read or write to excel.
 * 
 * <p>24-Jan-2021</p>
 * @author MD SADAB SAQIB
 * @version 1.0
 * @since 1.0
 * @see com.testnepal.listeners.MethodInterceptor
 * @see DataProviderUtils
 */
public final class ExcelUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExcelUtils() {}

	/**
	 * Encapsulates all the value from the mentioned excel sheet and store it in
	 * List holding HashMaps. Key for the map in the column header in the excel sheet.
	 * 
	 * @author MD SADAB SAQIB
	 * <p>24-Jan-2021</p>
	 * @param sheetname : Excel sheetname to read the value from
	 * @return List where each index holds a map and Each map holds the details about the test
	 * TODO create reusable methods
	 */
	public static List<Map<String, String>> getExcelData(String sheetname) {
		List<Map<String, String>> list = null;

		try(FileInputStream fis = new FileInputStream(FrameworkConstant.getTestDataExcelPath());
				XSSFWorkbook workbook = new XSSFWorkbook(fis);) {

			XSSFSheet sheet = workbook.getSheet(sheetname);

			Map<String, String> map = null;
			list = new ArrayList<>();

			int lastRowNum =  sheet.getLastRowNum();
			int colLastNum = sheet.getRow(0).getLastCellNum();

			for(int i=1; i<=lastRowNum; i++) {
				map = new HashMap<>();
				for(int j=0; j<colLastNum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
			
		} catch (FileNotFoundException e) {
			throw new InvalidExcelPathException("Test data Excel file not found!!!!");
		} catch (IOException e) {
			throw new FrameworkExceptions("IO Excepton occured while reading test data excel file");
		}
		return list;
	}

}