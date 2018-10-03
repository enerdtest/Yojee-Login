package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dataProvider.ConfigFileReader;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestLogin {

    WebDriver driver = null;
    ConfigFileReader configFileReader = new ConfigFileReader();
    LoginPage loginpage;
    HomePage homepage;
    AdminPage adminPage;

    @BeforeSuite
    public void initialize() throws IOException {

        String osName = System.getProperty("os.name");
        if (osName.contains("windows")) {
            System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        } else if (osName.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
        }

        driver = new ChromeDriver();
        //To maximize browser
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //To open Admin Login page
        driver.get(configFileReader.getApplicationUrl());

        homepage = new HomePage(driver);
        loginpage = new LoginPage(driver);
        adminPage = new AdminPage(driver);


    }

    @Test(priority = 0)
    public void init() throws Exception {
        homepage.verifyHomePageTitle(); //Get Login page title to make sure open correct URL
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void verifyLogin(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginpage.setEmail(configFileReader.getUserName());
        loginpage.setPassword(configFileReader.getPassword());
        loginpage.clickOnLoginButton();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test (priority = 2)
    public void verifyUserName(){
        //Verify the userName after login successfully
        adminPage.verifyUserName();
    }

    @Test (priority = 3)
    public void addNewWorker(){
        //Go to Workers Page
        adminPage.openWorkerPage();
        //Click add new Worker Button
        adminPage.clickAddWorkerButton();
        //Set Name, Phone, Email, SMS Token and Save new Worker
        adminPage.setWorkerName(configFileReader.getWorkerName());
        adminPage.setWorkerPhoneNumber(configFileReader.getWorkerPhoneNumber());
        adminPage.setWorkerEmail(configFileReader.getWorkerEmail());
        adminPage.checkUseSMSToken();
        adminPage.setSMSToken(configFileReader.getSMSToken());
        adminPage.clickSaveNewWorker();
    }
    @Test (priority = 4)
    public void verifyNewWorkerDetail(){
        adminPage.verifyNewWorker();
    }

    @AfterSuite
    //Test cleanup
    public void TeardownTest() {
        if (driver != null)
            driver.quit();
    }

}
