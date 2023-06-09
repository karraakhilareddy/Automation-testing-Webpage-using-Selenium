package project;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Project1 {

			public static void main(String[] args)  {
				
				// launch chrome webdriver
				WebDriver driver = new ChromeDriver();
				
				 // launch website
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

				// code for static dropdown
				WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				Select dropdown = new Select(staticDropdown);
		     	dropdown.selectByIndex(3);
				System.out.println(dropdown.getFirstSelectedOption().getText());

				 dropdown.selectByValue("AED");
				 System.out.println(dropdown.getFirstSelectedOption().getText());

			  dropdown.selectByVisibleText("INR");
				 System.out.println(dropdown.getFirstSelectedOption().getText());
		           
				 // implicity wait 
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

				 // adding adults using button
				 // adding 5 adults 
				 driver.findElement(By.id("divpaxinfo")).click();
				 System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

				 int i=1;
				 for(i=1;i<=5;i++)
				 {
					 driver.findElement(By.id("hrefIncAdt")).click();
				 }

				 driver.findElement(By.id("btnclosepaxoption")).click();
				 
				 // get the text from the application
				 System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

				 // selecting the states to travel
			     driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		       driver.findElement(By.xpath("//a[@value='BLR']")).click();

				driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
				
				// code for autosuggestive dropdowns
				driver.findElement(By.id("autosuggest")).sendKeys("ind");
				List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

				for(WebElement option : options)
				{
					if(option.getText().equalsIgnoreCase("INDIA"))
					{
						option.click();
						break;
					}
				}

				driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
				// Asert validation step
				Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

				System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

				// validation of UI(whether object is enabled or disabled)
				if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
				{
					System.out.println("disabled");
					Assert.assertTrue(true);
				}else
				{
					Assert.assertFalse(false);
				}

				driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
				
				
		        // Assertion validation step
				Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());

				System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

				if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
				{
					System.out.println("enabled");
					Assert.assertTrue(true);
				}else
				{
					Assert.assertFalse(false);
				}
				
				// closing the page
				driver.quit();

	}

}
