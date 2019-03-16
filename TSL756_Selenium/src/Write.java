import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Write
{
	public static void main(String[] args) throws Exception
	{	
		FileInputStream inFile = new FileInputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(inFile);
		XSSFSheet sheet = book.getSheet("Sheet1");
		sheet.getRow(2).getCell(1).setCellValue("LNT");
		sheet.createRow(3).createCell(1).setCellValue("LNT");
		sheet.getRow(1).getCell(1).setCellValue("R");
		sheet.createRow(5).createCell(1).setCellValue("LNT");
		sheet.createRow(4).createCell(0).setCellValue("ABC");
		//sheet.createRow(4).createCell(
		
		FileOutputStream op = new FileOutputStream("C:\\Users\\vshadmin\\Desktop\\Book1.xlsx");
		book.write(op);
	}
}
