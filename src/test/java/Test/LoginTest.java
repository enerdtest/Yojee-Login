package Test;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class LoginTest extends TestBase{

    @Test
    public void init() throws Exception{

        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        loginpage.setEmail("qa@yojee.com");
        loginpage.setPassword("yojee1234");
        loginpage.clickOnLoginButton();

        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.verifyUserName();
    }

}
