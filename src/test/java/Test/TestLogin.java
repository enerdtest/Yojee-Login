package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCase {

    public static WebDriver driver = null;

    @BeforeSuite
    public void initialize() throws IOException{

        String osName = System.getProperty("os.name");
        if (osName.contains("windows")){
            System.setProperty("webdriver.chrome.driver", "src/test/Drivers/chromedriver.exe");
        }
        else if (osName.contains("Mac")){
            System.setProperty("webdriver.chrome.driver", "src/test/Drivers/chromedriver");
        }

        driver = new ChromeDriver();
        //To maximize browser
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //To open facebook
        driver.get("https://admin.yojee.com/login");

    }

    @Test
    public void init() throws Exception{

        LoginPage loginpage = new LoginPage(driver);
//        HomePage homepage =new HomePage(driver);
        loginpage.setEmail("qa@yojee.com");
        loginpage.setPassword("yojee1234");
        loginpage.clickOnLoginButton();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterSuite
    //Test cleanup
    public void TeardownTest()
    {
        TestCase.driver.quit();
    }

}
