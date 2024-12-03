package testcases;

import com.Jooble.qa.base.TestBase;
import com.Jooble.qa.pages.JobVacanciesSearchPage;
import com.Jooble.qa.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JobVacanciesSearchPageTest extends TestBase {
    LoginPage loginPage;
    JobVacanciesSearchPage searchPage;

    public JobVacanciesSearchPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        searchPage = new JobVacanciesSearchPage();
//        searchPage.clickCookiePage();

    }
    @Test
    public void LoginPageSearchTest(){
        searchPage.enterPosition("Data Scientist");
        searchPage.enterLocation("Florida");
        searchPage.FindJobsButton();
    }
//    @AfterTest
//    public void tearDown(){
//        driver.quit();
//    }
}