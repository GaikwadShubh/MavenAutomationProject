package utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization
{
	public static String readExcelData(String sheetName,int row,int col) throws EncryptedDocumentException, IOException
	{	
		//FileInputStream imports file to our program basically it create a tunnel between program and file
		FileInputStream file = new FileInputStream("F:\\Workspace_spring\\MavenAutomationProject\\src\\test\\resources\\TestData.xlsx");
		
		//to fetch data from external file we need use WorkbookFactory class and its method
		
		//create method of WorkbookFactory create a copy of file into java memory
		String data=WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		
		return data;
	}
}
