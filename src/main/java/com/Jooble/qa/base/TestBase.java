package com.Jooble.qa.base;

import com.Jooble.qa.util.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestBase {

    public static Properties prop;
    public static WebDriver driver;
    public static Logger loggerr = Logger.getLogger(String.valueOf(TestBase.class));

    // Extent Reports variables
    public static ExtentReports extent;
    public static ExtentTest extentTest;

    public TestBase() {
        PropertyConfigurator.configure("src/main/java/com/Jooble/qa/config/config.properties");
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/com/Jooble/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Initialize Extent Reports with ExtentSparkReporter
    public static void initializeExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\g\\IdeaProjects\\SeleniumAutomationJooble\\test_output\\ExtentReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void initialization() {
        loggerr.info("Initializing browser with name: " + prop.getProperty("browser"));
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
            loggerr.info("Chrome browser initialized.");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        String url = prop.getProperty("url");
        driver.get(url);
        loggerr.info("Navigating to URL: " + url);
    }

    public static void acceptCookiesAndPopups() {
        try {
            loggerr.info("Attempting to accept cookies...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookieAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookiescript_accept")));
            cookieAcceptButton.click();
            loggerr.info("Cookies accepted.");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cookiescript_rightpart")));
        } catch (Exception e) {
            loggerr.warning("No cookies popup found or unable to handle cookies: " + e.getMessage());
        }
    }

    public static void takeScreenshot(String testName) {
        try {
            Path screenshotPath = Paths.get("screenshots/" + testName + ".png");
            if (!Files.exists(screenshotPath.getParent())) {
                Files.createDirectories(screenshotPath.getParent());
            }
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), screenshotPath);
            loggerr.info("Screenshot taken for failed test: " + testName);

            // Attach screenshot to Extent Report if test failed
            extentTest.addScreenCaptureFromPath(screenshotPath.toString());
        } catch (IOException e) {
            loggerr.severe("Error while taking screenshot: " + e.getMessage());
        }
    }
}
