package pages;

import dataProvider.configFileReader;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    //This method got get page title after open the URL to make sure open correct URL
    public void verifyHomePageTitle(){

        configFileReader configFileReader = new configFileReader();
        String actualTitle = driver.getTitle();
        String homePageTitle = configFileReader.getHomePageTitle();
        assertEquals(homePageTitle,actualTitle);
    }
}
