package week2.day2.HomeAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {
	
public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("Agro solutions");		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Naga");
        driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("Kiruthika");

		driver.findElement(By.name("departmentName")).sendKeys("R&D");
		driver.findElement(By.name("description")).sendKeys("Edit check");
		driver.findElement(By.xpath("//span[text()='E-Mail Address']/following::input")).sendKeys("kiruthikawins@outlook.com");
		
		WebElement stateDropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
        Select selectState = new Select(stateDropdown);
        selectState.selectByVisibleText("New York");
        
        driver.findElement(By.name("submitButton")).click();

        driver.findElement(By.linkText("Edit")).click();

        // Clear the Description Field and Fill the Important Note Field
        driver.findElement(By.name("description")).clear();
        driver.findElement(By.name("importantNote")).sendKeys("Automation Testing with Selenium WebDriver");

        // Click on Update Button
        driver.findElement(By.name("submitButton")).click();

        // Get the Title of the Resulting Page
        String pageTitle = driver.getTitle();
        System.out.println("Title of the resulting page: " + pageTitle);
        
        driver.close();
}		

}