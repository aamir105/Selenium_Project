package testcases;

import com.Jooble.qa.base.TestBase;
import com.Jooble.qa.pages.SignUppage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUppageTest extends TestBase {
    SignUppage signUppage;
    public SignUppageTest(){
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        signUppage = new SignUppage();
    }

    @Test
    public void SignupTest(){
        signUppage.settingClick();
        signUppage.signUpClick();
        signUppage.entermailClick(prop.getProperty("username"));
        signUppage.continuebuttonClick();
        signUppage.enterpassClick(prop.getProperty("password"));
        signUppage.enterSignupClick();
    }
}
