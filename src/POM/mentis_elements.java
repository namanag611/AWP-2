package POM;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class mentis_elements {

	ResourceBundle rb= ResourceBundle.getBundle("Elements");
	Logger log = Logger.getLogger("devpinoyLogger");
	WebDriver wdr;
	public mentis_elements(WebDriver any_wdr)
	{
		wdr=any_wdr;
	}

	public void EnterUserName(String username)
	{
		wdr.findElement(By.xpath(rb.getString("username"))).sendKeys(username);
		log.debug("Entered Username: "+username);
		System.out.println("Entered Username: "+username);
	}
	public void EnterPassword(String password)
	{
		wdr.findElement(By.xpath(rb.getString("password"))).sendKeys(password);
		log.debug("Entered Password: ******");
		System.out.println("Entered Password: ******");
	}

	public void ClickLogin()
	{
		wdr.findElement(By.xpath(rb.getString("login"))).click();
		log.debug("Click on Login");
		System.out.println("Clicked on Login");
	}
	
	
	public void searchtasknumber(String task)
	{
		wdr.findElement(By.xpath(rb.getString("searchinput"))).sendKeys(task);
		log.debug("Enter task number: "+task);
		wdr.findElement(By.xpath(rb.getString("jump"))).click();
		log.debug("Click on Jump");
		System.out.println("Search the task and click on Jump");
	}
	
	
	public String getsummary()
	{
		List <WebElement> summary= wdr.findElements(By.xpath(rb.getString("summary")));
		String summaryname=summary.get(2).getText();
		log.debug("Got Summary text: "+summaryname);
		return summaryname;
	}

}

