package First;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.util.List;

public class LinkedIn {
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pavithra\\Downloads\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://in.linkedin.com");
		WebElement search2=driver.findElement(By.linkText("Sign in"));
		search2.click();
		WebElement search3=driver.findElement(By.id("username"));
		search3.sendKeys("Your Email"+Keys.ENTER);
		WebElement search4=driver.findElement(By.id("password"));
		search4.sendKeys("Your Password"+Keys.ENTER);
		Thread.sleep(30000);
		WebElement search5=driver.findElement(By.xpath("//*[@id='global-nav-typeahead']/input"));
		search5.click();
		search5.sendKeys("Hospitals"+Keys.ENTER);
		driver.get("https://www.linkedin.com/search/results/people/?keywords=Hospitals&origin=SWITCH_SEARCH_VERTICAL&sid=jE!");
		
		// TO GET PROFILES
		Thread.sleep(30000);
		CSVWriter writer = new CSVWriter(new FileWriter("data.csv"));
		writer.writeNext(new String[] {"NAMES","HOSPITALS"});
		List<WebElement> results = driver.findElements(By.cssSelector(".reusable-search__result-container"));

        for (WebElement result : results){
            try {
                String name = result.findElement(By.cssSelector(".entity-result__title-text")).getText();
                String hospital = result.findElement(By.cssSelector(".entity-result__primary-subtitle")).getText();
                writer.writeNext(new String[]{name, hospital});
            }
            catch (Exception e) {
                System.out.println("Skipping a result due to missing elements.");
            }
            finally {
            	System.out.println("Created Succesfully");
            }
        }
    }
}
