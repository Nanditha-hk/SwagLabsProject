package baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.PropertiesUtility;
import utilities.WebDriverUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Baseclass {

    protected WebDriver driver;
    protected PropertiesUtility prop;

    WebDriverUtility wUtil = new WebDriverUtility();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println("Suite execution started");
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        System.out.println("Test execution started");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("Class execution started");
    }

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("chrome") String browser) throws Exception {

        prop = new PropertiesUtility();
        String url = prop.getProperty("url");

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--incognito");
            driver = new ChromeDriver(opt);
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterMethod(alwaysRun = true)
    public void logout() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("logged out");
        }
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("Class execution completed");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        System.out.println("Test execution completed");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("Suite execution completed");
    }
}