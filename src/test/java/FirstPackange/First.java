package FirstPackange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

public class First {
    public static String browser = "Chrome"; // Or "Firefox"
    public static WebDriver driver;

    @BeforeMethod
    public void browserLaunch()  {
        try {
            // Selenium Grid Hub URL (update IP if different)
            URL gridUrl = new URL("http://192.168.1.104:4444/wd/hub");

            if (browser.equalsIgnoreCase("Chrome")) {
                ChromeOptions options = new ChromeOptions();
                driver = new RemoteWebDriver(gridUrl, options);
            } else if (browser.equalsIgnoreCase("Firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                driver = new RemoteWebDriver(gridUrl, options);
            }

            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        driver.get("https://www.google.com");
        System.out.println("Title of test1 is: " + driver.getTitle());
    }

    @Test
    public void test2() {
        driver.get("https://www.google.com");
        System.out.println("Title of test2 is: " + driver.getTitle());
    }

    @Test
    public void test3() {
        driver.get("https://www.google.com");
        System.out.println("Title of test3 is: " + driver.getTitle());
    }

    @AfterMethod
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }
}
