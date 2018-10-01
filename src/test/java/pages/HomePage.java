package pages;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    //This method to click User Profile
    public void verifyLandingPage(){
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String landingTitle = "Yojee Driver Admin";
        assertEquals(landingTitle,actualTitle);
    }
}
