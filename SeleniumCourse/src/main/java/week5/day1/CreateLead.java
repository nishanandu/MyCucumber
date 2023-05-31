package week5.day1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseHooks {
	@Test(dataProvider="fetchData")
	public void createLead(String CompName, String FirstName , String LastName) {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(CompName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FirstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LastName);
		driver.findElement(By.name("submitButton")).click();
		
		
	}
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		ReadExcel re = new ReadExcel();
		String[][] readData = re.readData("CreateLeads", "Sheet1");
		
		return readData;
		
		
	}
}

