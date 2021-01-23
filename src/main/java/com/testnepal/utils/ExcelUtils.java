package com.testnepal.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.testnepal.constants.FrameworkConstant;

public final class ExcelUtils {

	private ExcelUtils() {}
	
	public static List<Map<String, String>> getExcelData(String sheetname) {
		List<Map<String, String>> list = null;
		XSSFWorkbook workbook = null;

		try(FileInputStream fis = new FileInputStream(FrameworkConstant.getTestDataExcelPath());) {
			workbook = new XSSFWorkbook(fis);
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
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return list;
	}

}