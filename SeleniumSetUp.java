package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumSetUp {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		String attribute = logout.getAttribute("value");

		if (attribute.equals("Logout")) {
			System.out.println("Page navigated correctly");
		} else {
			System.out.println("Not in the login page");
		}
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		Thread.sleep(5000);

		// clicking on the company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");

		// clicking on the first name
		System.out.println("Clicking on the firstname");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Jaison");
		// Thread.sleep(5000);

		// clicking on the last name
		System.out.println("Clicking on the Lastname");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Pradeep");

		// selecting the dropdown
		System.out.println("selecting the dropdown");

		WebElement dropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select select = new Select(dropDown);
		select.selectByVisibleText("Existing Customer");
		
		// Entering the Firstlocalname

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Pablo");
		System.out.println("Entered the Firstlocalname");
		
		// Entering the Department name
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Business");
		System.out.println("Entered the Departnment name");
		
		// Entering the description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Man who burnt money for his child");
		System.out.println("Entered the description name");
		
		// Entering the email
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("pabloescobar@druglord.com");
		System.out.println("Entered the email add");

		// Selecting the drop down NEW YORK from using Select class	
		WebElement province = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state = new Select(province);
		state.selectByVisibleText("New York");

		// Checking the title page is correct or not
		String title1 = driver.getTitle();
		System.out.println(" the tile of the current page is : " + title1);

		if (title1.equals("Create Lead | opentaps CRM")) {
			System.out.println("Successfully at Create lead page");

		}

	}

}
