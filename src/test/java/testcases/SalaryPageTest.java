package testcases;

import com.Jooble.qa.base.TestBase;
import com.Jooble.qa.pages.LoginPage;
import com.Jooble.qa.pages.SalaryPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalaryPageTest extends TestBase {

    SalaryPage salaryPage;
    public SalaryPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        salaryPage = new SalaryPage();
    }

    @Test
    public void Salary(){
        salaryPage.handleCookieBanner();
        salaryPage.settingClick();
        salaryPage.salarybtnClick();
        salaryPage.enterRegionClick("Mumbai");
        salaryPage.enterSalaryButton("500000");
        salaryPage.enterSearchSalary();
    }
}
