package Utlities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	public static void main(String[] args) {
	 
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		//create Excel Sheet
		
		XSSFSheet samplesheet =workbook.createSheet("sampleSheet");
	   
		//create Data
		Map<String, Object[]> dataSet =new TreeMap<String, Object[]>();
		
		dataSet.put("1", new Object[] {"ID","NAME", "COMPANY"});
		dataSet.put("2", new Object[] {"1","Jonny", "Quest"});
		dataSet.put("3", new Object[] {"2","Jack", "Tata"});
		dataSet.put("4", new Object[] {"3","James", "Google"});
		dataSet.put("5", new Object[] {"4","John", "Techno"});
	
		//Iterate over data
		
		Set<String> set =dataSet.keySet();
	int rownum =0;
	
	for (String key :set) {
		Row row=samplesheet.createRow(rownum++);
		
		Object[] data =dataSet.get(key);
		
		int cellNum =0;
		for (Object value :data) {
			Cell cell =row.createCell(cellNum++);
		
			if (value instanceof String)
				cell.setCellValue((String)value);
			else if(value instanceof Integer)
			   cell.setCellValue((Integer)value);
		}
	}
	
	//Write  file on HadDisk
	try {
		FileOutputStream writeFile = new FileOutputStream("sampleTest.xlsx");
		
		workbook.write(writeFile);
		
		writeFile.close();
		System.out.println("Sample Excel file is being created Successfully");
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	}
	

}
