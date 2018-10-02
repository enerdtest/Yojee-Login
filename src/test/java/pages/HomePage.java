package pages;

import dataProvider.configFileReader;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    //This method to click User Profile
    public void verifyHomePageTitle(){

        configFileReader configFileReader = new configFileReader();
        String actualTitle = driver.getTitle();
        String homePageTitle = configFileReader.getHomePageTitle();
        assertEquals(homePageTitle,actualTitle);
    }
}
