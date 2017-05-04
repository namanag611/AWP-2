package POM;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Core.CreateDriver;



public class readdatafromXLS extends CreateDriver{

	ResourceBundle rb= ResourceBundle.getBundle("Elements");
	Logger log = Logger.getLogger("devpinoyLogger");

	double value_for_xls;
	public static int xRows;
	public static int xCols;
	int rownumber=0;
	int mainv=0;
	String values="";
	int count=0;
	int number_of_dates;
	String task1, task2, task3, task4, task5, task6;
	String status1, status2, status3, status4, status5, status6;
	public void readdata() throws IOException, InterruptedException {

		/*
		 * Code to compare current date value to last generated xls value
		 * Start
		 */
		String fixed_date="03/02/2017";
		double fixed_datevalue=42797.0;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String CurrentDate = dateFormat.format(date);

		SimpleDateFormat myFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date date1 = myFormat.parse(fixed_date);
			Date date2 = myFormat.parse(CurrentDate);
			long diff = date2.getTime() - date1.getTime() -1;
			double diff_in_days = TimeUnit.MILLISECONDS.toDays(diff);
			//System.out.println ("Days: " + diff_in_days);
			value_for_xls = fixed_datevalue + diff_in_days;
			//System.out.println ("Value looked in xls will be: " + value_for_xls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Status will be sent for date: "+dateFormat.format(date));
		/*
		 * Code to compare current date value to last generated xls value
		 * End
		 */

		/*
		 * Code to read from password protected XLS file and filter the value according to date 
		 * Start
		 */

		String excelFilePath = rb.getString("filepath");
		boolean readOnly = true;

		NPOIFSFileSystem fileSystem = new NPOIFSFileSystem(new File(excelFilePath), readOnly);

		Biff8EncryptionKey.setCurrentUserPassword("PopcorN");

		Workbook workbook = new HSSFWorkbook(fileSystem);

		Sheet firstSheet = workbook.getSheetAt(0);

		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			double name;
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			rownumber=rownumber+1;

			while (cellIterator.hasNext()) {


				Cell cell = cellIterator.next();



				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:

					//System.out.print(cell.getStringCellValue());

					if(mainv==1)
					{
						values=values+", "+ cell.getStringCellValue();
					}
					break;
				case Cell.CELL_TYPE_NUMERIC:
					name = cell.getNumericCellValue();
					//System.out.print(cell.getNumericCellValue());

					if(name==value_for_xls || count==1)
					{
						//System.out.print(name);
						//System.out.println("Row number: "+rownumber);//Get the row number
						if(values == "")
						{
							values= Double.toString(name);
						}
						else
						{
							values = values+", "+Double.toString(name);
						}

						mainv=1;
						count=1;
					}
					break;
				}
				//System.out.print("\t");
			}
			//System.out.println();
		}



		workbook.close();
		fileSystem.close();

		//System.out.println("This is final string:"+values);
		/*
		 * Code to read from password protected XLS file and filter the value according to date 
		 * End
		 */


		/*
		 * Code to get number of dates
		 * Start 
		 */
		number_of_dates = 0;
		String string_value_for_xls = Double.toString(value_for_xls);
		Pattern p = Pattern.compile(string_value_for_xls);
		Matcher m = p.matcher(values);
		while (m.find()) {
			number_of_dates++;
		}
		//System.out.println(number_of_dates);
		/*
		 * Code to get number of dates
		 * End
		 */

		if (number_of_dates==1)
		{
			String a = new String(values);
		    String b[] = a.split(",");
		    String temptask1 = b[1];
		    String c[]=temptask1.split("\\.");
		    task1=c[0];
		    
		    status1= b[4];
		    System.out.println("task1 is:" +task1);
		    System.out.println("Status1 is:" +status1);
		    
		    //gettingvaluefrom_mentis summary = new gettingvaluefrom_mentis();
		    //String Summary1= getsummary(task1);
		    //sendemail se = new sendemail();
		    //se.send(Summary1);
		}
		else if(number_of_dates==2)
		{
			String a = new String(values);
		    String b[] = a.split(",");
		    
		    String temptask1 = b[1];
		    String temptask2 = b[1+8];
		    
		    String c1[]=temptask1.split("\\.");
		    task1=c1[0];
		    
		    String c2[]=temptask2.split("\\.");
		    task2 = c2[0];
		    
		    status1= b[4];
		    status2= b[12];
		    System.out.println("task1 is:" +task1);
		    System.out.println("Status1 is:" +status1);
		    
		    System.out.println("task2 is:" +task2);
		    System.out.println("Status2 is:" +status2);
		}
		else if(number_of_dates==3)
		{
			String a = new String(values);
		    String b[] = a.split(",");
		    
		    String temptask1 = b[1];
		    String temptask2 = b[1+8];
		    String temptask3 = b[1+8+8];
		    String c1[]=temptask1.split("\\.");
		    task1=c1[0];
		    
		    String c2[]=temptask2.split("\\.");
		    task2 = c2[0];
		    
		    String c3[]=temptask3.split("\\.");
		    task3 = c3[0];
		    
		    status1= b[4];
		    status2= b[4+8];
		    status3= b[4+8+8];
		    System.out.println("task1 is:" +task1);
		    System.out.println("Status1 is:" +status1);
		    
		    System.out.println("task2 is:" +task2);
		    System.out.println("Status2 is:" +status2);
		    
		    System.out.println("task3 is:" +task3);
		    System.out.println("Status3 is:" +status3);
		}
		else if (number_of_dates==4)
		{
			String a = new String(values);
		    String b[] = a.split(",");
		    
		    String temptask1 = b[1];
		    String temptask2 = b[1+8];
		    String temptask3 = b[1+8+8];
		    String temptask4 = b[1+8+8+8];
		    String c1[]=temptask1.split("\\.");
		    task1=c1[0];
		    
		    String c2[]=temptask2.split("\\.");
		    task2 = c2[0];
		    
		    String c3[]=temptask3.split("\\.");
		    task3 = c3[0];
		    
		    String c4[]=temptask4.split("\\.");
		    task4 = c4[0];
		    
		    status1= b[4];
		    status2= b[4+8];
		    status3= b[4+8+8];
		    status4= b[4+8+8+8];
		    System.out.println("task1 is:" +task1);
		    System.out.println("Status1 is:" +status1);
		    
		    System.out.println("task2 is:" +task2);
		    System.out.println("Status2 is:" +status2);
		    
		    System.out.println("task3 is:" +task3);
		    System.out.println("Status3 is:" +status3);
		    
		    System.out.println("task4 is:" +task4);
		    System.out.println("Status4 is:" +status4);
		}
		else if (number_of_dates==5)
		{
			String a = new String(values);
		    String b[] = a.split(",");
		    
		    String temptask1 = b[1];
		    String temptask2 = b[1+8];
		    String temptask3 = b[1+8+8];
		    String temptask4 = b[1+8+8+8];
		    String temptask5 = b[1+8+8+8+8];
		    String c1[]=temptask1.split("\\.");
		    task1=c1[0];
		    
		    String c2[]=temptask2.split("\\.");
		    task2 = c2[0];
		    
		    String c3[]=temptask3.split("\\.");
		    task3 = c3[0];
		    
		    String c4[]=temptask4.split("\\.");
		    task4 = c4[0];
		    
		    String c5[]=temptask5.split("\\.");
		    task5 = c5[0];
		    
		    status1= b[4];
		    status2= b[4+8];
		    status3= b[4+8+8];
		    status4= b[4+8+8+8];
		    status5= b[4+8+8+8+8];
		    System.out.println("task1 is:" +task1);
		    System.out.println("Status1 is:" +status1);
		    
		    System.out.println("task2 is:" +task2);
		    System.out.println("Status2 is:" +status2);
		    
		    System.out.println("task3 is:" +task3);
		    System.out.println("Status3 is:" +status3);
		    
		    System.out.println("task4 is:" +task4);
		    System.out.println("Status4 is:" +status4);
		    System.out.println("task5 is:" +task5);
		    System.out.println("Status5 is:" +status5);
		}
		else if(number_of_dates==6)
		{
			String a = new String(values);
		    String b[] = a.split(",");
		    
		    String temptask1 = b[1];
		    String temptask2 = b[1+8];
		    String temptask3 = b[1+8+8];
		    String temptask4 = b[1+8+8+8];
		    String temptask5 = b[1+8+8+8+8];
		    String temptask6 = b[1+8+8+8+8+8];
		    String c1[]=temptask1.split("\\.");
		    task1=c1[0];
		    
		    String c2[]=temptask2.split("\\.");
		    task2 = c2[0];
		    
		    String c3[]=temptask3.split("\\.");
		    task3 = c3[0];
		    
		    String c4[]=temptask4.split("\\.");
		    task4 = c4[0];
		    
		    String c5[]=temptask5.split("\\.");
		    task5 = c5[0];
		    
		    String c6[]=temptask6.split("\\.");
		    task6 = c6[0];
		    
		    status1= b[4];
		    status2= b[4+8];
		    status3= b[4+8+8];
		    status4= b[4+8+8+8];
		    status5= b[4+8+8+8+8];
		    status6= b[4+8+8+8+8+8];
		    System.out.println("task1 is:" +task1);
		    System.out.println("Status1 is:" +status1);
		    
		    System.out.println("task2 is:" +task2);
		    System.out.println("Status2 is:" +status2);
		    
		    System.out.println("task3 is:" +task3);
		    System.out.println("Status3 is:" +status3);
		    
		    System.out.println("task4 is:" +task4);
		    System.out.println("Status4 is:" +status4);
		    System.out.println("task5 is:" +task5);
		    System.out.println("Status5 is:" +status5);
		    System.out.println("task6 is:" +task6);
		    System.out.println("Status6 is:" +status6);
		}
		else
		{
			
		}
		
	}

	
	public String returntaskvalue1()
	{
		return task1;
	}
	public String returntaskvalue2()
	{
		return task2;
	}
	public String returntaskvalue3()
	{
		return task3;
	}
	public String returntaskvalue4()
	{
		return task4;
	}
	public String returntaskvalue5()
	{
		return task5;
	}
	public String returntaskvalue6()
	{
		return task6;
	}
	public String returnstatusvalue1()
	{
		return status1;
	}
	public String returnstatusvalue2()
	{
		return status2;
	}
	public String returnstatusvalue3()
	{
		return status3;
	}
	public String returnstatusvalue4()
	{
		return status4;
	}
	public String returnstatusvalue5()
	{
		return status5;
	}
	public String returnstatusvalue6()
	{
		return status6;
	}

}


/*
 * //Code to read from password protected XLS file 
		String excelFilePath = rb.getString("filepath");
		boolean readOnly = true;

		NPOIFSFileSystem fileSystem = new NPOIFSFileSystem(new File(excelFilePath), readOnly);

		Biff8EncryptionKey.setCurrentUserPassword("PopcorN");

		Workbook workbook = new HSSFWorkbook(fileSystem);

		Sheet firstSheet = workbook.getSheetAt(0);

		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();



			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				}
				System.out.print("\t");
			}
			System.out.println();
		}



		workbook.close();
		fileSystem.close();
 * 
 */
