package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// To load the url in chrome browser
		driver.get("http://leaftaps.com/opentaps/control/login");
		System.out.println("Chrome browser launched successfully");
		// To maxmize the screen
		driver.manage().window().maximize();
		// To enter the username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		System.out.println("username and password provided successfully");
		// To click on submit button
		driver.findElement(By.className("decorativeSubmit")).click();
		// To click on on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		// To click on on Create lead link
		driver.findElement(By.linkText("Create Lead")).click();
		System.out.println("At Create lead page");
		// clicking on the company name
		System.out.println("Entering thr basic details");
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		// clicking on the first name		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Jaison");
		// clicking on the Last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Pradeep");
		// selecting the dropdown
		WebElement dropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select select = new Select(dropDown);
		select.selectByVisibleText("Existing Customer");
		// Entering the Firstlocalname
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Pablo");
		// Entering the Department name
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Business");
		// Entering the description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Man who burnt money for his child");
		// Entering the email
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("pabloescobar@druglord.com");
		// Selecting the drop down NEW YORK from using Select class
		WebElement province = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state = new Select(province);
		state.selectByVisibleText("New York");
		// clicking on the create lead button
		System.out.println("Clicking on the submit button after entering the basic details");
		driver.findElement(By.name("submitButton")).click();
		// to get the title of the current page
		String title = driver.getTitle();
		System.out.println("The tile of the current page is : " + title);
		if (title.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Successfully at View lead page");
		}
		System.out.println("Clickig on the duplicate lead");
		// Clicking on the duplicate lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		System.out.println("Clearing the existing comany name and firstname ");

		// clearing the company name and entering the new company
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("SHALOM");
		// clearing on the first name
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("George");
		// After clearing an checking if we are on the same page
		System.out.println("Checking we are on the leads page");
		String title1 = driver.getTitle();
		System.out.println("The tile of the current page is : " + title1);
		if (title.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Successfully at View lead page after clearing and entering the details");
		}

	}

}
