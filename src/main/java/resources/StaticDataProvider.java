package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class StaticDataProvider {

	public static String[][] getDataValues(String dataFileName , String sheetName) throws IOException{
		FileInputStream fis = new FileInputStream(dataFileName);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		String[][] dataTable = null;
		
		try {
			XSSFSheet sheet=workbook.getSheet(sheetName);
			
			if(sheet==null) {
				throw new Exception("Sheet with name "+sheetName+" is not present in "+dataFileName);
			}
			
			int totalRows=sheet.getLastRowNum()+1;
			int totalColumns=sheet.getRow(0).getLastCellNum();
			dataTable=new String[totalRows][totalColumns];
			DataFormatter df = new DataFormatter();
			
			for(int i=0;i<totalRows;i++) {
				XSSFRow rows=sheet.getRow(i);
				for(int j=0;j<totalColumns;j++) {
					XSSFCell cell=rows.getCell(j);
					if(cell==null) {
						dataTable[i][j]=null;
					}
					else {
						String value = df.formatCellValue(cell);
						dataTable[i][j]=value;
					}
				}
			}
			return dataTable;
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		finally {
			workbook.close();
		}
		
	}
	
	public static Object[][] getDataList(String dataProvider , String sheetName) throws IOException {
		Object[][] testData=getDataValues(dataProvider , sheetName);
		System.out.println("Sheet Name = " +sheetName);
		System.out.println("Number of rows = " +(testData.length-1));
		
		HashMap<String,String> tcAttribMap=null;
		
		Object[][] testDataOutput=new Object[testData.length-1][1];
		for(int i=1;i<testData.length;i++) {
			tcAttribMap = new HashMap<String,String>();
			for(int j=0;j<testData[i].length;j++) {
				if(testData[i][j] ==null || testData[i][j].equals(false)) {
					tcAttribMap.put(testData[0][j].toString(), "");
				}
				else {
					tcAttribMap.put(testData[0][j].toString(), testData[i][j].toString());
				}
			}
			
			testDataOutput[i-1][0]=tcAttribMap;
			tcAttribMap=null;
		}
		return testDataOutput;
	}
	
	@DataProvider(name="excelDP")
	public static Object[][] fileData(Method m) throws IOException {
		
		String dataProvider;
		String sheetName;
		String dataFileName=m.getDeclaringClass().getSimpleName()+"TestData.xlsx";
		dataProvider=System.getProperty("user.dir")+"\\src\\test\\java\\data\\"+dataFileName;
		
		sheetName=m.getName().toUpperCase();
		
		return getDataList(dataProvider,sheetName);
		
	}
}
