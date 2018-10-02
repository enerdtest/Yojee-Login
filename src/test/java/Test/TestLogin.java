package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import dataProvider.configFileReader;

public class TestLogin {

    public static WebDriver driver = null;

    @BeforeSuite
    public void initialize() throws IOException{

        configFileReader configFileReader= new configFileReader();

        String osName = System.getProperty("os.name");
        if (osName.contains("windows")){
            System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        }
        else if (osName.contains("Mac")){
            System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        }

        driver = new ChromeDriver();
        //To maximize browser
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //To open facebook
        driver.get(configFileReader.getApplicationUrl());

    }

    @Test
    public void init() throws Exception{

        configFileReader configFileReader = new configFileReader();
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage =new HomePage(driver);

        homepage.verifyHomePageTitle(); //Get Login page title to make sure open correct URL
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);

        // Input userName and passWord
        loginpage.setEmail(configFileReader.getUserName());
        loginpage.setPassword(configFileReader.getPassword());
        loginpage.clickOnLoginButton();
        driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);

        // Verify the userName after login successfully
        loginpage.verifyUserName();
    }

    @AfterSuite
    //Test cleanup
    public void TeardownTest()
    {
        TestLogin.driver.quit();
    }

}
