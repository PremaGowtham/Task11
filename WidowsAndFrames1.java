package SeleniumProject;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WidowsAndFrames1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Navigate to the URL
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		Thread.sleep(2000);
		
		 // 3. Click the "Click Here" button to open a new window
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();
        Thread.sleep(3000);

        // 4. Switch to the newly opened window
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // 5. Verify that the text "New Window" is present on the page
        WebElement heading = driver.findElement(By.tagName("h3"));
        if ("New Window".equals(heading.getText())) {
            System.out.println("Text verification successful: " + heading.getText());
        } else {
            System.out.println("Text verification failed!");
        }

        // 6. Close the new window
        driver.close();
        Thread.sleep(3000);
        // 7. Verify that the original window is active
        driver.switchTo().window(originalWindow);
        if (driver.getWindowHandle().equals(originalWindow)) {
            System.out.println("Original window is active.");
        } else {
            System.out.println("Failed to switch back to the original window.");
        }

    
        // 8. Close the browser
        driver.quit();
	}

}
