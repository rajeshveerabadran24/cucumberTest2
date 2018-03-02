package com.util.pack;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ColoumnName {
	
	 public FileInputStream fis = null;
	    public XSSFWorkbook workbook = null;
	    public XSSFSheet sheet = null;
	    public XSSFRow row = null;
	    public XSSFCell cell = null;
	 
	    public ColoumnName(String xlFilePath) throws Exception
	    {
	        fis = new FileInputStream(xlFilePath);
	        workbook = new XSSFWorkbook(fis);
	        fis.close();
	    }
	 
	    public String getCellData(String sheetName, String colName)
	    {
	        try
	        {
	            int col_Num = -1;
	            sheet = workbook.getSheet(sheetName);
	            row = sheet.getRow(0);
	            for(int i = 0; i < row.getLastCellNum(); i++)
	            {
	                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
	                    col_Num = i;
	            }
	 for (int k = 2; k <=sheet.getLastRowNum()+1; k++) {
		
		 
	            row = sheet.getRow( k- 1);
	
	            cell = row.getCell(col_Num);
	 
	            if(cell.getCellTypeEnum() == CellType.STRING) {
	            	System.out.println(cell.getStringCellValue());
	                return cell.getStringCellValue();
	            }
	            else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
	            {
	                String cellValue = String.valueOf(cell.getNumericCellValue());
	                if(HSSFDateUtil.isCellDateFormatted(cell))
	                {
	                    DateFormat df = new SimpleDateFormat("dd/MM/yy");
	                    Date date = cell.getDateCellValue();
	                    cellValue = df.format(date);
	                }
	                return cellValue;
	            }else if(cell.getCellTypeEnum() == CellType.BLANK)
	                return "";
	            else
	            	
	                return String.valueOf(cell.getBooleanCellValue());
	 }
	 
	 }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            return "row "+" or column "+" does not exist  in Excel";
	        }
			return colName;
			
			
			
	        	
	    }

	    }
