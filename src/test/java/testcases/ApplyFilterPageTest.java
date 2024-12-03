package testcases;

import com.Jooble.qa.base.TestBase;
import com.Jooble.qa.pages.ApplyFilterPage;
import com.Jooble.qa.pages.JobVacanciesSearchPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ApplyFilterPageTest extends TestBase {
    ApplyFilterPage filter;

    public ApplyFilterPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        filter = new ApplyFilterPage();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    @Test
    public void TestApplyFilterPage(){
        filter.DateOFPostingButtonMthd();
        filter.EmployementType();
        filter.DateOfPosting();
        filter.Salary();
        filter.PerMonthSalary();
        filter.TypeOfEmployment();
        filter.WorkExperience();
        filter.Apply();
    }
}
