package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsAndFrames2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(1000);
        
        // Step 2 & 3: Switch to the top frame
        driver.switchTo().frame("frame-top");
        Thread.sleep(2000);
        
        // Step 4: Verify there are three frames (left, middle, right)
        int topFramesCount = driver.findElements(By.xpath("frame")).size();
        if (topFramesCount == 3) {
            System.out.println("Verified: There are three frames in the top frame.");
        } else {
            System.out.println("Verification failed: Expected 3 frames, found " + topFramesCount);
        }
        Thread.sleep(2000);
        
        // Step 5: Switch to the left frame
        driver.switchTo().frame("frame-left");
        Thread.sleep(1000);
        
        
        // Step 6: Verify the left frame has text "LEFT"
        String leftFrameText = driver.findElement(By.xpath("//body")).getText();
        if (leftFrameText.equals("LEFT")) {
            System.out.println("Verified: Left frame has text 'LEFT'.");
        } else {
            System.out.println("Verification failed: Left frame text is " + leftFrameText);
        }
        
        Thread.sleep(1000);

        // Step 7: Switch back to the top frame
        driver.switchTo().parentFrame();

        // Step 8: Switch to the middle frame
        driver.switchTo().frame("frame-middle");
        Thread.sleep(1000);

        // Step 9: Verify the middle frame has text "MIDDLE"
        String middleFrameText = driver.findElement(By.cssSelector("div")).getText();
        if (middleFrameText.equals("MIDDLE")) {
            System.out.println("Verified: Middle frame has text 'MIDDLE'.");
        } else {
            System.out.println("Verification failed: Middle frame text is " + middleFrameText);
        }

        // Step 10: Switch back to the top frame
        driver.switchTo().parentFrame();

        // Step 11: Switch to the right frame
        driver.switchTo().frame("frame-right");

        // Step 12: Verify the right frame has text "RIGHT"
        String rightFrameText = driver.findElement(By.xpath("//body")).getText();
        if (rightFrameText.equals("RIGHT")) {
            System.out.println("Verified: Right frame has text 'RIGHT'.");
        } else {
            System.out.println("Verification failed: Right frame text is " + rightFrameText);
        }

        // Step 13: Switch back to the top frame
        driver.switchTo().parentFrame();

        // Step 14: Switch to the bottom frame
        driver.switchTo().defaultContent(); // Exit top frame first
        driver.switchTo().frame("frame-bottom");
        Thread.sleep(1000); 
        
        // Step 15: Verify the bottom frame has text "BOTTOM"
        String bottomFrameText = driver.findElement(By.xpath("//body")).getText();
        if (bottomFrameText.equals("BOTTOM")) {
            System.out.println("Verified: Bottom frame has text 'BOTTOM'.");
        } else {
            System.out.println("Verification failed: Bottom frame text is " + bottomFrameText);
        }
        Thread.sleep(1000);
        
        // Step 16: Switch back to the top frame
        driver.switchTo().defaultContent();
        
        // Step 17: Verify the page title is "Frames"
        String pageTitle = driver.getTitle();
        
            System.out.println("Verified: Page title is 'Frames'.");
        
        System.out.println("Test completed successfully.");
        Thread.sleep(3000);
        driver.quit();

	}

}
