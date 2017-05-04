package Cases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ResourceBundle;

import org.testng.annotations.Test;

import Core.CreateDriver;
import POM.mentis_elements;
import POM.readdatafromXLS;
import POM.sendemail;

public class sendStatusEmail extends CreateDriver{
	ResourceBundle rb = ResourceBundle.getBundle("Elements"); // Get elements of web page from property file

	@Test
	public void sendemail() throws InterruptedException, IOException, AWTException
	{
		String Summary1="", Summary2="", Summary3="", Summary4="", Summary5="", Summary6="";
		readdatafromXLS data=new readdatafromXLS();
		data.readdata();
		
		String task1= data.returntaskvalue1();
		String status1= data.returnstatusvalue1();
		String task2= data.returntaskvalue2();
		String status2= data.returnstatusvalue2();
		String task3= data.returntaskvalue3();
		String status3= data.returnstatusvalue3();
		String task4= data.returntaskvalue4();
		String status4= data.returnstatusvalue4();
		String task5= data.returntaskvalue5();
		String status5= data.returnstatusvalue5();
		String task6= data.returntaskvalue6();
		String status6= data.returnstatusvalue6();
		if(task1 != null && task2 == null && task3 == null && task4 == null && task5 == null && task6 == null)
		{
			mentis_elements me = new mentis_elements(fd);
			fd.get(rb.getString("url"));
			me.EnterUserName("namanagrawal");
			me.EnterPassword("PopcorN");
			me.ClickLogin();
			Thread.sleep(2000);
			me.searchtasknumber(task1);
			Summary1=me.getsummary();
			sendemail se = new sendemail();
			se.send(Summary1, status1);
		}
		else if(task1 != null && task2 != null && task3 == null && task4 == null && task5 == null && task6 == null)
		{
			mentis_elements me = new mentis_elements(fd);
			fd.get(rb.getString("url"));
			me.EnterUserName("namanagrawal");
			me.EnterPassword("PopcorN");
			me.ClickLogin();
			Thread.sleep(2000);
			me.searchtasknumber(task1);
			Summary1=me.getsummary();
			me.searchtasknumber(task2);
			Summary2=me.getsummary();
			sendemail se = new sendemail();
			se.send(Summary1, Summary2, status1, status2);
		}
		else if(task1 != null && task2 != null && task3 != null && task4 == null && task5 == null && task6 == null)
		{
			mentis_elements me = new mentis_elements(fd);
			fd.get(rb.getString("url"));
			me.EnterUserName("namanagrawal");
			me.EnterPassword("PopcorN");
			me.ClickLogin();
			Thread.sleep(2000);
			me.searchtasknumber(task1);
			Summary1=me.getsummary();
			me.searchtasknumber(task2);
			Summary2=me.getsummary();
			me.searchtasknumber(task3);
			Summary3=me.getsummary();
			sendemail se = new sendemail();
			se.send(Summary1, Summary2, Summary3, status1, status2, status3);
		}
		else if(task1 != null && task2 != null && task3 != null && task4 != null && task5 == null && task6 == null)
		{
			mentis_elements me = new mentis_elements(fd);
			fd.get(rb.getString("url"));
			me.EnterUserName("namanagrawal");
			me.EnterPassword("PopcorN");
			me.ClickLogin();
			Thread.sleep(2000);
			me.searchtasknumber(task1);
			Summary1=me.getsummary();
			me.searchtasknumber(task2);
			Summary2=me.getsummary();
			me.searchtasknumber(task3);
			Summary3=me.getsummary();
			me.searchtasknumber(task4);
			Summary4=me.getsummary();
			sendemail se = new sendemail();
			se.send(Summary1, Summary2, Summary3, Summary4, status1, status2, status3, status4);
		}
		else if(task1 != null && task2 != null && task3 != null && task4 != null && task5 != null && task6 == null)
		{
			mentis_elements me = new mentis_elements(fd);
			fd.get(rb.getString("url"));
			me.EnterUserName("namanagrawal");
			me.EnterPassword("PopcorN");
			me.ClickLogin();
			Thread.sleep(2000);
			me.searchtasknumber(task1);
			Summary1=me.getsummary();
			me.searchtasknumber(task2);
			Summary2=me.getsummary();
			me.searchtasknumber(task3);
			Summary3=me.getsummary();
			me.searchtasknumber(task4);
			Summary4=me.getsummary();
			me.searchtasknumber(task5);
			Summary5=me.getsummary();
			sendemail se = new sendemail();
			se.send(Summary1, Summary2, Summary3, Summary4, Summary5, status1, status2, status3, status4, status5);
		}
		else if(task1 != null && task2 != null && task3 != null && task4 != null && task5 != null && task6 != null)
		{
			mentis_elements me = new mentis_elements(fd);
			fd.get(rb.getString("url"));
			me.EnterUserName("namanagrawal");
			me.EnterPassword("PopcorN");
			me.ClickLogin();
			Thread.sleep(2000);
			me.searchtasknumber(task1);
			Summary1=me.getsummary();
			me.searchtasknumber(task2);
			Summary2=me.getsummary();
			me.searchtasknumber(task3);
			Summary3=me.getsummary();
			me.searchtasknumber(task4);
			Summary4=me.getsummary();
			me.searchtasknumber(task5);
			Summary5=me.getsummary();
			me.searchtasknumber(task6);
			Summary6=me.getsummary();
			sendemail se = new sendemail();
			se.send(Summary1, Summary2, Summary3, Summary4, Summary5, Summary6, status1, status2, status3, status4, status5, status6);
		}
		else
		{
			System.out.println("Error in Script.");
		}

	}



}
