package testcases;

import ListnerClass.TestListener;
import com.Jooble.qa.base.TestBase;
import com.Jooble.qa.pages.JobVacanciesSearchPage;
import com.Jooble.qa.pages.LoginPage;
import com.bl.qa.test.util.ExcelFileReading;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    JobVacanciesSearchPage searchPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        loggerr.info("Initializing the test setup...");
        initialization();
        loginPage = new LoginPage();
    }

     @Test
    public void loginPageTitleTest() {
        loggerr.info("Starting login page title test...");
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Jobs in India - 83.000+ current vacancies - Jooble");
        loggerr.info("Login page title test passed.");
    }

    @Test
    public void logoTest() {
        loggerr.info("Starting logo presence test...");
        boolean flag = loginPage.validateImage();
        Assert.assertTrue(flag);
        loggerr.info("Logo test passed.");
    }

    @Test(priority = 1)
    public void loginTest() {
        loggerr.info("Starting login test...");
        loginPage.clickloginbutton();
        loginPage.entermail(prop.getProperty("username"));
        loginPage.clickcontinuebutton();
        loginPage.enterpass(prop.getProperty("password"));
        loginPage.enterlogin();
        loggerr.info("Login test completed.");
    }

    @Test(priority = 2, dataProvider = "LoginData", dataProviderClass = ExcelFileReading.class)
    public void LoginWithMultipleUser(String emails, String passs) {
        loggerr.info("Logging in with multiple users...");
        loginPage.multipleUserLogin(emails, passs);
        loggerr.info("Multiple user login completed.");
    }

//    @AfterTest
//    public void tearDown() {
//        loggerr.info("Tearing down the test environment...");
//        driver.quit();
//    }
}
