import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Read
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream inFile = new FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(inFile);
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		for(int i=1; i<=sheet.getLastRowNum(); i++)
		{
			for(int j=2; j>=sheet.getLeftCol();j++)
			{
				String data = sheet.getRow(i).getCell(j).toString();
				System.out.println(data);
			}
				
				//String data1 = sheet.getRow(i).getCell(j).toString();
			//	System.out.println(data1);

			}
	}
		

	}

