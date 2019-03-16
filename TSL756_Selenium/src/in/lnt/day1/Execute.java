package in.lnt.day1;

public class Execute {

	public static void main(String[] args) {
		
		
		
	Excel excel=new Excel("C:\\Users\\vshadmin\\Desktop\\abc.xlsx");
	
	System.out.println(excel.rowCount("Sheet1"));
	System.out.println(excel.cellCount("Sheet1", 1));

	System.out.println(excel.Read("Sheet1", 2,2));
	}

}
