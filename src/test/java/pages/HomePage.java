package pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class HomePage {

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();


    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    //This method got get page title after open the URL to make sure open correct URL
    public void verifyHomePageTitle(){
      String actualTitle = driver.getTitle().trim();
      String homePageTitle = configFileReader.getHomePageTitle();
      assertEquals(homePageTitle,actualTitle);
    }
}
